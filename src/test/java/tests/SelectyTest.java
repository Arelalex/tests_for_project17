package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.ContactsPage;
import pages.MainPage;

import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

@Tag("demoqa_m")
public class SelectyTest extends TestBase {
    TestData testData = new TestData();
    MainPage mainPage = new MainPage();
    ContactsPage contactsPage = new ContactsPage();

    static Stream<Arguments> checkLanguageFromStreamTest() {
        return Stream.of(
                Arguments.of("EN", List.of(
                        "Selecty",
                        "Services",
                        "Career",
                        "Contacts")),
                Arguments.of("RU", List.of(
                        "Selecty",
                        "Услуги",
                        "Карьера",
                        "Блог",
                        "Контакты"))
        );
    }

    @ParameterizedTest(name = "Check results {1} for query {0}")
    @Feature("Главная страница")
    @Story("Добавление локализации")
    @Owner("a.moskotina")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Test case", url = "https://allure.autotests.cloud/")
    @DisplayName("Checking language switching")
    @Tag("Regress")
    @MethodSource
    void checkLanguageFromStreamTest(String searchQuery, List<String> expectedTabs) {
        step("Открыть главную страницу", () -> {
            mainPage.openPage();
            mainPage.loadPage();
        });
        step("Переключить язык", () -> {
            mainPage.changeLanguage(searchQuery);
            mainPage.loadPage();
        });
        step("Проверить названия табов в соответствии с выбранным языком", () -> {
            mainPage.checkingTabs(expectedTabs);
        });
    }

    @Test
    @Feature("Главная страница")
    @Story("Добавление социальных сетей")
    @Owner("a.moskotina")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Test case", url = "https://allure.autotests.cloud/")
    @DisplayName("Checking social links")
    @Tag("Smoke")
    @MethodSource
    void checkingSocialLinksTest() {
        step("Открыть главную страницу", () -> {
            mainPage.openPage();
            mainPage.loadPage();
        });
        step("Проверить отображение иконок социальных сетей", () -> {
            mainPage.checkingSocialLinks(mainPage.listSocialLinks());
        });
    }

    @Test
    @Feature("Главная страница")
    @Story("Selecty в цифрах")
    @Owner("a.moskotina")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Test case", url = "https://allure.autotests.cloud/")
    @DisplayName("Checking statistics indicators")
    @Tag("Regress")
    @MethodSource
    void checkingStatisticsVacanciesTest() {
        step("Открыть главную страницу", () -> {
            mainPage.openPage();
            mainPage.loadPage();
        });
        step("Принять cookie", () -> {
            mainPage.acceptCookies();
        });
        step("Проверить отображение статистики закрытых вакансий", () -> {
            mainPage.checkStatisticsVacancy();
        });
        step("Проверить отображение статистики клиентов из рейтинга", () -> {
            mainPage.checkStatisticsClients();
        });
        step("Проверить отображение статистики клиентов ИТ рекрутеров", () -> {
            mainPage.checkStatisticsRecruiters();
        });
        step("Проверить отображение статистики кандидатов", () -> {
            mainPage.checkStatisticsCandidates();
        });
        step("Проверить отображение статистики устроенных кандидатов", () -> {
            mainPage.checkStatisticsEmployedCandidates();
        });
        step("Проверить отображение статистики специалистов в базе", () -> {
            mainPage.checkStatisticsSpecialists();
        });
    }

    @Test
    @Feature("Главная страница")
    @Story("Наши клиенты")
    @Owner("a.moskotina")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Test case", url = "https://allure.autotests.cloud/")
    @DisplayName("Checking of Our Clients")
    @Tag("Smoke")
    @MethodSource
    void checkingOurClientsTest() {
        step("Открыть главную страницу", () -> {
            mainPage.openPage();
            mainPage.loadPage();
        });
        step("Проверить отображение заголовка Финансовый сектор", () -> {
            mainPage.checkOurClients();
        });
        step("Проверить отображение заголовка Ритейл, FMCG", () -> {
            mainPage.checkRetail();
        });
        step("Проверить отображение заголовка Промышленность", () -> {
            mainPage.checkIndustry();
        });
        step("Проверить отображение заголовка Телеком, E-com", () -> {
            mainPage.checkTelecom();
        });
    }

    @Test
    @Feature("Контакты")
    @Story("Сontact contacts")
    @Owner("a.moskotina")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Test case", url = "https://allure.autotests.cloud/")
    @DisplayName("Checking of form Contacts")
    @Tag("Regress")
    @MethodSource
    void fillFormContatsTest() {
        step("Открыть главную страницу", () -> {
            mainPage.openPage();
            mainPage.loadPage();
        });
        step("Открыть страницу Контакты", () -> {
            contactsPage.clickContacts();
            contactsPage.loadPage();
        });
        step("Принять cookie", () -> {
            contactsPage.acceptCookies();
        });
        step("Заполнить форму", () -> {
            contactsPage.setName(testData.firstName);
            contactsPage.setCompany(testData.company);
            contactsPage.setContact(testData.email);
            contactsPage.setTopic(testData.topics);
            contactsPage.setCheckbox();
        });
    }
}