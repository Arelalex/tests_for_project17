package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$x;

public class ContactsPage {

    private SelenideElement
            selectyLoader = $x("//img[@alt='Selecty animation']"),
            tabContacts = $x("//a[contains(text(),'Контакты')]"),
            addressOfficeHow = $x("//h2[contains(text(),'Как добраться?')]"),
            inputName = $x("//input[@placeholder='Имя']"),
            inputCompany = $x("//input[@placeholder='Компания']"),
            inputContact = $x("//input[@placeholder='Ваш контакт (телефон, E-mail или Telegram)']"),
            inputTopic = $x("//input[@placeholder='Тема запроса']"),
            checkboxAgreement = $x("//div[@class='t-checkbox__indicator']"),
            buttonCookies = $x("//*[@class='t657__btn t-btn t-btn_sm']");

    public ContactsPage clickContacts() {
        tabContacts.click();

        return this;
    }

    public ContactsPage setName(String value) {
        addressOfficeHow.scrollIntoView(false);
        inputName.setValue(value);

        return this;
    }

    public ContactsPage setCompany(String value) {
        inputCompany.setValue(value);

        return this;
    }

    public ContactsPage setContact(String value) {
        inputContact.setValue(value);

        return this;
    }

    public ContactsPage setTopic(String value) {
        inputTopic.setValue(value);

        return this;
    }

    public ContactsPage setCheckbox() {
        checkboxAgreement.click();

        return this;
    }

    public ContactsPage acceptCookies() {
        buttonCookies.click();

        return this;
    }

    public ContactsPage loadPage() {
        selectyLoader.should(disappear, Duration.ofSeconds(100));

        return this;
    }
}
