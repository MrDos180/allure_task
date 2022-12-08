package com.example.allure_task;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class GithubSelenideTest {


    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("MrDos180/allure_task");
        $(".header-search-input").submit();
        $(linkText("MrDos180/allure_task")).click();
        $("#issues-tab").click();
        $(withText("Test Issue")).should(Condition.visible);
    }
}
