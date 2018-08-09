package com.maxpay.test.ui.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class DashboardPageSteps {

    public ElementsCollection getMenuList(){
    $(By.xpath("//div[@class='side-content']")).waitUntil(Condition.exist, 50000);
        return $$(By.xpath("//li[@data-ng-repeat='menu in features track by $index']//span"));
    }
}
