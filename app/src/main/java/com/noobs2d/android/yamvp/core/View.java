package com.noobs2d.android.yamvp.core;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Implemented by a {@link Fragment}. <br>
 * All implementors of a View should have an instance of a {@link Presenter}.<br><br>
 *
 * @author Julious Igmen
 */
public interface View {

    /**
     * Preferably called on {@link Activity#onCreate(Bundle)} or {@link Fragment#onCreate(Bundle)}.
     */
    public void initializePresenter();

    /**
     * Where the View's components (i.e., Buttons, Fields, etc. etc.) should be instantiated. <br>
     * This must be called after {@link Fragment#onCreateView(LayoutInflater, ViewGroup, Bundle)},
     * preferably on {@link Fragment#onActivityCreated(Bundle)}, so you can legally call {@link Fragment#getView()} from which
     * you will instantiate the components.
     */
    public void initializeComponents();
}
