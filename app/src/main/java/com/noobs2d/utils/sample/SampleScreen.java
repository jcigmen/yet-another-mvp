package com.noobs2d.utils.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.noobs2d.utils.core.BaseFragment;

/**
 * Just a simple screen that shows random color. Tapping on the screen adds a new screen.
 *
 * @author Julious Igmen
 */
public class SampleScreen extends BaseFragment {

    private int randomColor = (int) (Color.BLACK * Math.random());

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setBackgroundColor(randomColor);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getScreenController().addScreen(new SampleScreen(), "");
            }
        });

        return linearLayout;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getScreenController().removeTopScreen();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public String getScreenTitle() {
        return randomColor + "";
    }
}
