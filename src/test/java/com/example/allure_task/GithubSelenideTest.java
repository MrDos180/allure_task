package com.example.allure_task;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.SetValueOptions.withText;
import static org.openqa.selenium.By.linkText;

public class GithubSelenideTest {


    @Test
    public void testIsseSearch(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("MrDos180/allure_task");
        $(".header-search-input").submit();

        $(linkText("MrDos180/allure_task")).click();
        $("#issues-tab").click();
        //$(withText("#80")).should(Condition.exist);
    }
}
