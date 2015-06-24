package com.noobs2d.android.yamvp.core;

/**
 * Serves as the bridge between the {@link View} and worker or provider classes. <br>
 * The Presenter should also implement the listeners required by a View, so the business
 * logic can be easily removed from the View.
 *
 * @author Julious Igmen
 */
public interface Presenter {

    /** Must be called from the View. */
    public void onPause();

    /** Must be called from the View. */
    public void onResume();

}
