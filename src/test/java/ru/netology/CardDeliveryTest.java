package ru.netology;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryTest {

    @Test
    void shouldEnteringInformationForCardDelivery() {
        open("http://localhost:9999/");
        $("[class='input__control'][placeholder='Город']").setValue("Москва");
        String date = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date']  input").setValue(date);
        $("[name='name']").setValue("Анна Адамова");
        $("[name='phone']").setValue("+79991110022");
        $("[class='checkbox__box']").click();
        $("button").click();

        $("[notification__title]").shouldHave(text("Успешно"), Duration.ofSeconds(15));
        $(".notification__content").shouldBe(visible, Duration.ofSeconds(15)).shouldHave(text("Встреча успешно забронирована"));
        $("").click();
    }
}
