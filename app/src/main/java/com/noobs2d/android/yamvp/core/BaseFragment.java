package com.noobs2d.android.yamvp.core;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * To be extended by any Fragment that wishes to utilize {@link ScreenController}. The activity that uses this
 * fragment must implement {@link ScreenControllerProvider}, otherwise the app will purposely crash.
 * <br><br>
 * This Fragment has its own management of the toolbar title; everytime {@link Fragment#onResume()} is called
 * or {@link #onBackStackChanged()} occurs and this fragment {@link #isVisible()}, {@link #changeToolbarTitle(String)}
 * is called to update the toolbar title.
 *
 * @author Julious Igmen
 */
public abstract class BaseFragment extends Fragment implements FragmentManager.OnBackStackChangedListener {

    public abstract String getScreenTitle();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        checkIfMainActivityImplementsScreenController();
        addBackstackListener();
    }

    private void checkIfMainActivityImplementsScreenController() {
        boolean activityDoesntImplementScreenControllerProvider = !(getActivity() instanceof ScreenControllerProvider);
        if (activityDoesntImplementScreenControllerProvider) {
            throw new RuntimeException("The activity that utilizes BaseFragment must implement ScreenController and return a valid instance!");
        }
    }

    private void addBackstackListener() {
        FragmentActivity activity = getActivity();
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        fragmentManager.addOnBackStackChangedListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();

        changeToolbarTitle(getScreenTitle());
    }

    @Override
    public void onBackStackChanged() {
        // when the user returns to this screen/fragment after pressing back, we return the title of the toolbar
        if (isVisible()) {
            changeToolbarTitle(getScreenTitle());
        }
    }

    private void changeToolbarTitle(String title) {
        getScreenController().setToolbarTitle(title);
    }

    public ScreenController getScreenController() {
        return ((ScreenControllerProvider) getActivity()).getScreenController();
    }
}
