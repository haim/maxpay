package com.maxpay.test.ui.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.maxpay.test.ui.data.UserData;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPageSteps {

    public DashboardPageSteps login(UserData userData){
        $(By.id("login-email")).shouldBe(Condition.visible).setValue(userData.getEmail());
        $(By.id("login-password")).shouldBe(Condition.visible).setValue(userData.getPassword());
        $(By.xpath("//button[@class='btn btn-block btn-primary mheight-40 text-uppercase ng-binding'][1]")).shouldBe(Condition.visible).click();
        return page(DashboardPageSteps.class);
    }

    public String getLoginErrorText() {
        return $(By.xpath("//div[@class='alert alert-danger alert-dismissable push-15']/p")).shouldBe(Condition.visible).getText();
    }
}
