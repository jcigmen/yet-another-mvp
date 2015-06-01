package com.noobs2d.utils.framework;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;

import com.noobs2d.noobandroid.R;

/**
 * @see ScreenController
 * @author Julious Igmen
 */
public class ScreenControllerImpl implements ScreenController {

    private final ActionBar actionBar;
    private final FragmentManager fragmentManager;
    private final int containerId;

    public ScreenControllerImpl(ActionBar actionBar, FragmentManager fragmentManager, int containerId) {
        this.actionBar = actionBar;
        this.fragmentManager = fragmentManager;
        this.fragmentManager.addOnBackStackChangedListener(this);
        this.containerId = containerId;
    }

    @Override
    public void navigateToScreen(Fragment screen, String tag) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(containerId, screen, tag);
        fragmentTransaction.commit();
    }

    @Override
    public void removeAllOtherScreens() {
        fragmentManager.popBackStack();
    }

    @Override
    public void removeTopScreen() {
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    @Override
    public void setToolbarTitle(String title) {
        actionBar.setTitle(title);
    }

    @Override
    public boolean hasScreen(String tag) {
        return fragmentManager.findFragmentByTag(tag) != null;
    }

    @Override
    public boolean isToolbarVisible() {
        return actionBar.isShowing();
    }

    @Override
    public void setToolbarVisible(boolean visible) {
        if (visible) {
            actionBar.show();
        } else {
            actionBar.hide();
        }
    }

    @Override
    public void showDialog(DialogFragment dialog) {
        dialog.show(fragmentManager, dialog.getTag());
    }

    @Override
    public boolean isNavigationDrawerEnabled() {
        return false; // this app has no drawer
    }

    @Override
    public void setNavigationDrawerEnabled(boolean enabled) {
        // this app has no drawer
    }

    @Override
    public void setGlobalNavigationEnabled(boolean enabled) {
        setNavigationDrawerEnabled(enabled);
        setToolbarVisible(enabled);
    }

    @Override
    public void addScreen(Fragment screen, String tag) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(containerId, screen, tag); // the container shouldn't be a static-reference to the project
        fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackStackChanged() {
        boolean hasStackedScreens = fragmentManager.getBackStackEntryCount() > 0;
        if (hasStackedScreens) {
            setUpArrowEnabled(true);
        } else {
            setUpArrowEnabled(false);
        }
    }

    private void setUpArrowEnabled(boolean enabled) {
        actionBar.setDisplayHomeAsUpEnabled(enabled);
        actionBar.setHomeButtonEnabled(enabled);

        if (enabled) {
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_action_back);
        } else {
            actionBar.setHomeAsUpIndicator(null);
        }
    }

}
