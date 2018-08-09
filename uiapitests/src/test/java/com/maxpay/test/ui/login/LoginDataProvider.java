package com.maxpay.test.ui.login;

import com.maxpay.test.ui.data.UserData;
import org.testng.annotations.DataProvider;

public class LoginDataProvider  {

    String email = "qa+test+user@maxpay.com";
    String pass = "21TSeWbq";

    @DataProvider(name = "Login as regular User")
    public static Object[][] loginAsRegularUser() {
        return new Object[][]{{new UserData.Builder().email("qa+test+user@maxpay.com").password("21TSeWbq").build()}};
    }

    @DataProvider(name = "Login as User, that has invalid credentials")
    public static Object[][] loginWithIncorrectCredentials() {
        return new Object[][]{{new UserData.Builder().email("pavel.123@tea2mdev.com").password("1233").build()}};
    }

    @DataProvider(name = "Login as User, that has valid login, but invalid password")
    public static Object[][] loginWithPartiallyCorrectCredentials() {
        return new Object[][]{{new UserData.Builder().email("pavel.123@tea2mdev.com").password("1233").build()}};
    }
}
