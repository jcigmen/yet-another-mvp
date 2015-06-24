package com.noobs2d.android.yamvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.noobs2d.android.yamvp.core.ScreenController;
import com.noobs2d.android.yamvp.core.ScreenControllerImpl;
import com.noobs2d.android.yamvp.core.ScreenControllerProvider;


public class MainActivity extends AppCompatActivity implements ScreenControllerProvider {

    private ScreenController screenController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screenController = new ScreenControllerImpl(getSupportActionBar(), getSupportFragmentManager(), R.id.container);
    }

    @Override
    public ScreenController getScreenController() {
        return screenController;
    }

}
