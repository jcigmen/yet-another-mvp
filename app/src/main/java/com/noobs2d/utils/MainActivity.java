package com.noobs2d.utils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.noobs2d.utils.core.ScreenController;
import com.noobs2d.utils.core.ScreenControllerImpl;
import com.noobs2d.utils.core.ScreenControllerProvider;
import com.noobs2d.utils.sample.SampleScreen;


public class MainActivity extends AppCompatActivity implements ScreenControllerProvider {

    private ScreenController screenController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screenController = new ScreenControllerImpl(getSupportActionBar(), getSupportFragmentManager(), R.id.container);
        screenController.navigateToScreen(new SampleScreen(), "");
    }

    @Override
    public ScreenController getScreenController() {
        return screenController;
    }

}
