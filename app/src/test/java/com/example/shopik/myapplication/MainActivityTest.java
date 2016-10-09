package com.example.shopik.myapplication;


import android.widget.Button;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;


@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)

public class MainActivityTest {

    private iMainActivity activity;
    private iMainActivity activityMocked;
    private Button button;

    @Before
    public void setup() {
        activity = Robolectric.buildActivity(MainActivity.class).create().get();
        activityMocked = Mockito.spy(activity.getActivity());
        button = (Button) activityMocked.getActivity().findViewById(R.id.button);
    }


    @Test
    public void isVisible() {
        Mockito.when(activityMocked.random()).thenReturn(20);
        activityMocked.getActivity().ifVisible(activityMocked.random());
        assertEquals(button.getVisibility(), Button.VISIBLE);

    }

    @Test
    public void isInvisible() {
        Mockito.when(activityMocked.random()).thenReturn(-20);
        activityMocked.getActivity().ifVisible(activityMocked.random());
        assertEquals(button.getVisibility(), Button.INVISIBLE);

    }
}