package com.ultimatega.courses.testsuite;

import com.ultimatega.courses.pages.HomePage;
import com.ultimatega.courses.pages.LoginPage;
import com.ultimatega.courses.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){

        //locate ‘Sign In’ link and click on it
        homePage.signInLink();

        // Verify the text ‘Welcome Back!’
        String expectedMessage = "Welcome Back!";
        String actualMessage= loginPage.getWelcomeText();
        Assert.assertEquals(expectedMessage, actualMessage);


    }

    @Test
    public void verifyTheErrorMessage(){

        //locate ‘Sign In’ link and click on it
        homePage.signInLink();

        // Enter invalid username
        loginPage.enterUsername("123@gmail.com");

        // /Enter invalid password
        loginPage.enterPasswordField("ABC123?");

        // Click on Login button
        loginPage.clickLoginButton();

        // Verify the error message ‘Invalid email or password.’
        String expectedMessage = "Invalid email or password.";
        String actualMessage= loginPage.getErrorMessage();
        Assert.assertEquals(expectedMessage, actualMessage);

    }
}
