package com.example.allure_task;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class GithubLambdaTest {

    public static final String REPOSITORY = "MrDos180/allure_task";
    public static final String ISSUENAME = "Test Issue";

    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Нажать на ссылку репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открыть таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Убедиться в наличии Issue " + ISSUENAME, () -> {
            $(withText(ISSUENAME)).should(Condition.visible);
        });

    }
}
