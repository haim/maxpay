package com.maxpay.test.ui.login;

import com.codeborne.selenide.Condition;
import com.maxpay.test.ui.data.UserData;
import com.maxpay.test.ui.stepdefinitions.DashboardPageSteps;
import com.maxpay.test.ui.stepdefinitions.LoginPageSteps;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

public class LoginTest {


    @Test(dataProvider = "Login as regular User", dataProviderClass = LoginDataProvider.class)
    public void loginAsRegularUse(UserData user){
        LoginPageSteps loginPageSteps = open("https://my-sandbox.maxpay.com/#/signin", LoginPageSteps.class);
        DashboardPageSteps dashboardPageSteps = new DashboardPageSteps();
        loginPageSteps.login(user);
        assertEquals(dashboardPageSteps.getMenuList().get(0).getText(),"Панель управления" );
    }

    @Test(dataProvider = "Login as User, that has invalid credentials", dataProviderClass = LoginDataProvider.class)
    public void loginWithIncorrectCredentials(UserData userWithInvalidCredentionals){
        LoginPageSteps loginPageSteps = open("https://my-sandbox.maxpay.com/#/signin", LoginPageSteps.class);
        loginPageSteps.login(userWithInvalidCredentionals);
        assertEquals(loginPageSteps.getLoginErrorText(), "Некорректны пароль или email");
    }

    @Test(dataProvider = "Login as User, that has valid login, but invalid password", dataProviderClass = LoginDataProvider.class)
    public void loginWithPartiallyCorrectCredentials(UserData userWithInvalidPassword) {
        LoginPageSteps loginPageSteps = open("https://my-sandbox.maxpay.com/#/signin", LoginPageSteps.class);
        loginPageSteps.login(userWithInvalidPassword);
        assertEquals(loginPageSteps.getLoginErrorText(), "Некорректны пароль или email");
    }
}
