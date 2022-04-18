package ru.netology;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class CardDeliveryTest {

    @Test
    void shouldEnteringInformationForCardDelivery() {
       Selenide.open("http://localhost:9999/");
       $("").setValue("");
       $("").setValue("");
       $("").setValue("Мария Адамова");
       $("").setValue("+79991110022");
       $("").click();
       $("").click();



    }
}
