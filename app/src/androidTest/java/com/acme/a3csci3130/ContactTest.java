package com.acme.a3csci3130;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ContactTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule=new ActivityTestRule<>(MainActivity.class);

    @Test
    public void createContact(){
        //check submitButton exist
        onView(withId(R.id.submitButton)).perform(click());

        //check edit text name
        onView(withId(R.id.name)).perform(typeText("Alicia"));
        closeSoftKeyboard();
        onView(withId(R.id.name)).check(matches(withText("Alicia")));

        //check edit text number
        onView(withId(R.id.number)).perform(typeText("012345678"));
        closeSoftKeyboard();
        onView(withId(R.id.number)).check(matches((withText("012345678"))));

        //check edit text primary
        onView(withId(R.id.primary)).perform(typeText("Fisher"));
        closeSoftKeyboard();
        onView(withId(R.id.primary)).check(matches(withText("Fisher")));

        //check edit text province
        onView(withId(R.id.province)).perform(typeText("NS"));
        closeSoftKeyboard();
        onView(withId(R.id.province)).check(matches(withText("NS")));

        //check edit text address
        onView(withId(R.id.address)).perform(typeText("this is a test address"));
        closeSoftKeyboard();
        onView(withId(R.id.address)).check(matches(withText("this is a test address")));

        onView(withId(R.id.submitButton)).perform(click());

    }

    @Test
    public void updateContact(){
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.name)).perform(clearText());
        onView(withId(R.id.name)).perform(typeText("Beta"));
        closeSoftKeyboard();
        onView(withId(R.id.updateButton)).perform(click());

    }

    @Test
    public void deleteContact() throws InterruptedException {
        Thread.sleep(5000);
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
    }

}
