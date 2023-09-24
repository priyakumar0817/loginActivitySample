package com.example.myapplication;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    // Test Case 1: Check if a valid login succeeds
    @Test
    public void testLoginSuccess() {
        // Input a valid email and password
        Espresso.onView(withId(R.id.edt_email)).perform(ViewActions.typeText("validemail@gmail.com"));
        Espresso.onView(withId(R.id.edt_pass)).perform(ViewActions.typeText("valid123"));

        // Click the login button
        Espresso.onView(withId(R.id.btn_login)).perform(ViewActions.click());

        // Check if "LOGIN SUCCESS!" message is displayed
        Espresso.onView(withId(R.id.tv_result))
                .check(matches(isDisplayed()))
                .check(matches(withText("LOGIN SUCCESS!")));
    }

    // Test Case 2: Check if login fails with an invalid email
    @Test
    public void testLoginFailureWithInvalidEmail() {
        // Input an invalid email and password
        Espresso.onView(withId(R.id.edt_email)).perform(ViewActions.typeText("invalidemail"));
        Espresso.onView(withId(R.id.edt_pass)).perform(ViewActions.typeText("valid123"));

        // Click the login button
        Espresso.onView(withId(R.id.btn_login)).perform(ViewActions.click());

        // Check if "LOGIN FAILED" message is displayed
        Espresso.onView(withId(R.id.tv_result))
                .check(matches(isDisplayed()))
                .check(matches(withText("LOGIN FAILED")));
    }

    // Test Case 3: Check if login fails with empty text fields
    @Test
    public void testLoginFailureEmptyTextField() {
        // Leave email and password fields empty
        Espresso.onView(withId(R.id.edt_email)).perform(ViewActions.typeText(""));
        Espresso.onView(withId(R.id.edt_pass)).perform(ViewActions.typeText(""));

        // Click the login button
        Espresso.onView(withId(R.id.btn_login)).perform(ViewActions.click());

        // Check if "LOGIN FAILED" message is displayed
        Espresso.onView(withId(R.id.tv_result))
                .check(matches(isDisplayed()))
                .check(matches(withText("LOGIN FAILED")));
    }

    // Test Case 4: Check if login fails with an empty password field
    @Test
    public void testLoginFailureWithEmptyPasswordField() {
        // Input a valid email and leave the password field empty
        Espresso.onView(withId(R.id.edt_email)).perform(ViewActions.typeText("validemail@gmail.com"));
        Espresso.onView(withId(R.id.edt_pass)).perform(ViewActions.typeText(""));

        // Click the login button
        Espresso.onView(withId(R.id.btn_login)).perform(ViewActions.click());

        // Check if "LOGIN FAILED" message is displayed
        Espresso.onView(withId(R.id.tv_result))
                .check(matches(isDisplayed()))
                .check(matches(withText("LOGIN FAILED")));
    }

    @Test
    public void testLoginFailureWithEmptyEmailField() {
        // Input a valid password and leave the email field empty
        Espresso.onView(withId(R.id.edt_email)).perform(ViewActions.typeText(""));
        Espresso.onView(withId(R.id.edt_pass)).perform(ViewActions.typeText("validpwd"));

        // Click the login button
        Espresso.onView(withId(R.id.btn_login)).perform(ViewActions.click());

        // Check if "LOGIN FAILED" message is displayed
        Espresso.onView(withId(R.id.tv_result))
                .check(matches(isDisplayed()))
                .check(matches(withText("LOGIN FAILED")));
    }
}
