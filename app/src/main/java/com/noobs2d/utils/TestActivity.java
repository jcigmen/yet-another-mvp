package com.noobs2d.utils;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.noobs2d.utils.core.ScreenController;
import com.noobs2d.utils.core.ScreenControllerImpl;
import com.noobs2d.utils.core.ScreenControllerProvider;

/**
 * For the sole purpose of unit testing.
 *
 * @author Julious Igmen
 */
public class TestActivity extends AppCompatActivity implements ScreenControllerProvider {

    private ScreenController screenController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test);

        screenController = new ScreenControllerImpl(getSupportActionBar(), getSupportFragmentManager(), R.id.test_container);
    }

    @Override
    public ScreenController getScreenController() {
        return screenController;
    }
}
