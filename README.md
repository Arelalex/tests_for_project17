## Демопроект по автоматизации тестовых сценариев для сайта компании Selecty

>**Selecty** — лидер рынка ИТ рекрутинга и аутсорсинга.

## :feather: Содержание:

- [Используемый стек](#books-используемый-стек)
- [Реализованные проверки](#heavy_check_mark-реализованные-проверки)
- [Запуск автотестов](#arrow_forward-запуск-автотестов)
- [Пример Allure-отчета](#пример-allure-отчета)
- [Интеграция с Allure TestOps](#интеграция-с-allure-testops)
- [Интеграция с Jira](#интеграция-с-jira)
- [Уведомления в Telegram](#уведомления-в-telegram-с-использованием-бота)
- [Видео примера запуска тестов в Selenoid](#видео-примера-запуска-тестов-в-selenoid)

## :books: Используемый стек
<p align="center">
<a href="https://www.jetbrains.com/ru-ru/idea/"><img src="media/logo/intellij.svg" width="50" alt="IntelliJ IDEA"></a>
<a href="https://www.java.com/"><img src="media/logo/java.svg" width="50" alt="Java"></a>
<a href="https://junit.org/junit5/docs/current/user-guide/"><img src="media/logo/junit5.svg" width="50" alt="JUnit 5"></a>
<a href="https://selenide.org/"><img src="media/logo/selenide.svg" width="50" alt="Selenide"></a>
<a href="https://gradle.org/"><img src="media/logo/gradle.svg" width="50" alt="Gradle"></a>
<a href="https://allurereport.org/"><img src="media/logo/allure.svg" width="50" alt="Allure Report"></a>
<a href="https://aerokube.com/selenoid/latest/"><img src="media/logo/selenoid.svg" width="50" alt="Selenoid"></a>
<a href="https://www.jenkins.io/"><img src="media/logo/jenkins.svg" width="50" alt="Jenkins"></a>
<a href="https://web.telegram.org/"><img src="media/logo/telegram.svg" width="50" alt="Telegram"></a>
<a href="https://github.com/"><img src="media/logo/github.svg" width="50" alt="GitHub"></a>
<a href="https://qameta.io/"><img src="media/logo/allure testops.svg" width="50" alt="Allure TestOps"></a>
<a href="https://www.atlassian.com/ru/software/jira"><img src="media/logo/jira.svg" width="50" alt="Jira"></a>
</p>

- Тесты написаны на языке `Java`
- Используется фреймворк для автоматизированного тестирования `Selenide` и `JUnit 5`
- Проект собирается в `Gradle`
- Для запуска браузеров используется `Selenoid`
- Запуск автотестов осуществляется с помощью джобы настроенной в `Jenkins`
- После прохождения тестов формируется `Allure-отчет`
- Результаты приходят в `Telegram`
- Так же есть интеграция с `Allure TestOps` и `Jira`

## :heavy_check_mark: Реализованные проверки
- Параметризованный тест смены языка на русский, английский
- На главной странице отображаются иконки социальных сетей
- Отображение статистических показателей
- Отображение табов с группированием клиентов
- Заполнение формы для связи с контактами

## :arrow_forward: Запуск автотестов
### Запуск тестов из терминала:
```bash
gradle clean demo
```
При выполнении данной команды в терминале IDE тесты запустятся удаленно в `Selenoid`

### Запуск тестов удаленно через Jenkins:

```bash
clean
${TASK}
-Dbrowser=${BROWSER}
-Dversion=${BROWSER_VERSION}
-DwindowSize=${BROWSER_SIZE}
-DremoteWebDriver=${REMOTE_DRIVER_URL}
```

### <img src="media/logo/jenkins.svg" title="Jenkins" width="2%"/> Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/22-a_moskotina-jenkins_17_project/)

Для запуска сборки необходимо перейти в раздел `Build with Parameters` и нажать кнопку `Build`
<p align="center">
<img title="Job with Jenkins" src="media/screens/Job with Jenkins.png">
</p>

### Параметры сборки:

- `REMOTE_DRIVER_URL` – адрес удаленного сервера, на котором будут запускаться тесты
- `BROWSER` – браузер, в котором будут выполняться тесты (по умолчанию - chrome)
- `BROWSER_VERSION` – версия браузера, в которой будут выполняться тесты (по умолчанию - 100.0)
- `BROWSER_SIZE` – размер окна браузера, в котором будут выполняться тесты (по умолчанию - 1920x1080)


После выполнения сборки и прогона тестов, в блоке `Build History` напротив номера сборки появятся значки `Allure Report` и `Allure TestOps`, при клике на которые откроется страница с сформированным html-отчетом и тестовой документацией соответственно.

## <img src="media/logo/allure.svg" title="Allure Report" width="2%"/> Пример [Allure-отчета](https://jenkins.autotests.cloud/job/22-a_moskotina-jenkins_17_project/12/allure/)

<p align="center">
<img title="Allure Overview" src="media/screens/Allure Report.png">
</p>


## <img src="media/logo/allure testops.svg" title="Allure TestOps" width="2%"/> Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/3837/dashboards)

На Dashboard в `Allure TestOps` отображается статистика с количеством ручных и автоматизированных тестов. Новые тесты, а так же результаты прогона появляются при каждом запуске сборки

<p align="center">
<img title="Allure TestOps DashBoard" src="media/screens/Allure TestOps.png">
</p>


### Результат выполнения автотестов:
<p align="center">
<img title="Test Results in Alure TestOps" src="media/screens/Allur Results.png">
</p>


## <img src="media/logo/jira.svg" title="Jira" width="2%"/> Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-981)

Реализована интеграция `Allure TestOps` с `Jira`, в тикете отображается, какие тест-кейсы были написаны в рамках задачи и результат их прогона.

<p align="center">
<img title="Jira Task" src="media/screens/Jira.png">
</p>


## <img src="media/logo/telegram.svg" title="Telegram" width="2%"> Уведомления в Telegram с использованием бота

После завершения прогона автотестов автоматически отправляется отчет с результами прогона тестов в `Telegram`

<p align="center">
<img title="Telegram Notifications" src="media/screens/Report in telegram.png" width="70%">
</p>


## <img src="media/logo/selenoid.svg" title="Selenoid" width="2%"> Видео примера запуска тестов в Selenoid

В отчетах Allure для каждого теста прикреплен не только скриншот, но и видео прохождения теста
<p align="center">
  <img title="Selenoid Video" src="media/screens/Video.gif">
</p>