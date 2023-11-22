package pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement
            selectyLoader = $x("//img[@alt='Selecty animation']"),
            statisticsTitle = $x("//span[text()='в цифрах']"),
            statisticSelectorVacancies = $x("//div[text()='Закрытых вакансий']/../div[contains(@class, 'heading')]"),
            statisticSelectorClients = $x("//div[text()='Клиентов из рейтинга Топ-500 РБК']/../div[contains(@class, 'heading')]"),
            statisticsRecruiters = $x("//div[text()='ИТ рекрутеров']/../div[contains(@class, 'heading')]"),
            statisticsСandidates = $x("//div[contains(text(),'Каждый 5-й')]/../div[contains(@class, 'heading')]"),
            statisticsEmployedCandidates = $x("//div[contains(text(),'Устроенных кандидатов')]/../div[contains(@class, 'heading')]"),
            statisticsSpecialists = $x("//div[contains(text(),'Специалистов в базе')]/../div[contains(@class, 'heading')]"),
            smiAboutUs = $x("//h2[text()='о нас']"),
            clientFinance = $x("//button[text()='Финансовый сектор']"),
            clientRetail = $x("//button[text()='Ритейл, FMCG']"),
            clientIndustry = $x("//button[text()='Промышленность']"),
            clientTelecom = $x("//button[text()='Телеком, E-com']"),
            buttonCookies = $x("//*[@class='t657__btn t-btn t-btn_sm']");


    public MainPage openPage() {
        open("");

        return this;
    }

    public MainPage loadPage() {
        selectyLoader.shouldBe(visible);
        selectyLoader.should(disappear, Duration.ofSeconds(15));

        return this;
    }

    public MainPage changeLanguage(String value) {
        String LanguageSelector = "//a[text()='%s']";
        $x(String.format(LanguageSelector, value)).click();

        return this;
    }

    public MainPage checkingTabs(List<String> expectedTabs) {
        String resultSelector = "//a[contains(text(),'%s')]";
        expectedTabs.forEach(someText ->
                $x(String.format(resultSelector, someText)).shouldBe(visible));

        return this;
    }

    public List<String> listSocialLinks() {

        return List.of("vk.com", "linkedin", "career.habr.com", "t.me", "hh.ru");
    }

    public MainPage checkingSocialLinks(List<String> listSocialLinks) {
        String socialSelector = "//li/a[contains(@href,'%s')]";
        listSocialLinks.forEach(someText ->
                $x(String.format(socialSelector, someText)).shouldBe(visible));

        return this;
    }

    private void helpMatcherForValue1(String value) {
        String pattern = "\\d+(?:\\.\\d+)?%";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(value);
        Assertions.assertTrue(m.matches());
    }

    private void helpMatcherForValue2(String value) {
        String pattern = "\\d+(?:\\.\\d+)?\\+";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(value);
        Assertions.assertTrue(m.matches());
    }

    private void helpMatcherForValue3(String value) {
        String pattern = "^[0-9]+$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(value);
        Assertions.assertTrue(m.matches());
    }

    private void helpMatcherForValue4(String value) {
        String pattern = "^[0-9 ]+$?\\+";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(value);
        Assertions.assertTrue(m.matches());
    }

    public MainPage checkStatisticsVacancy() {
        statisticSelectorVacancies.scrollIntoView(false);
        helpMatcherForValue2(statisticSelectorVacancies.getText());

        return this;
    }

    public MainPage checkStatisticsClients() {
        statisticSelectorClients.scrollIntoView(false);
        helpMatcherForValue2(statisticSelectorClients.getText());

        return this;
    }

    public MainPage checkStatisticsRecruiters() {
        statisticsRecruiters.scrollIntoView(false);
        helpMatcherForValue2(statisticsRecruiters.getText());

        return this;
    }

    public MainPage checkStatisticsCandidates() {
        statisticsСandidates.scrollIntoView(false);
        helpMatcherForValue3(statisticsСandidates.getText());

        return this;
    }

    public MainPage checkStatisticsEmployedCandidates() {
        statisticsEmployedCandidates.scrollIntoView(false);
        helpMatcherForValue1(statisticsEmployedCandidates.getText());

        return this;
    }

    public MainPage checkStatisticsSpecialists() {
        statisticsSpecialists.scrollIntoView(false);
        helpMatcherForValue4(statisticsSpecialists.getText());

        return this;

    }
    public MainPage checkOurClients() {
        smiAboutUs.scrollIntoView(false);
        clientFinance.shouldBe(visible);

        return this;
    }

    public MainPage checkRetail() {
        clientRetail.shouldBe(visible);

        return this;
    }

    public MainPage checkIndustry() {
        clientIndustry.shouldBe(visible);

        return this;
    }

    public MainPage checkTelecom() {
        clientTelecom.shouldBe(visible);

        return this;
    }

    public MainPage acceptCookies() {
        buttonCookies.click();

        return this;
    }
}





