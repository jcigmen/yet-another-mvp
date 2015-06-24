package com.noobs2d.android.yamvp.core;

import com.noobs2d.android.yamvp.TestActivity;
import com.noobs2d.android.yamvp.UnitTest;

/**
 * @author Julious Igmen
 */
public class ScreenControllerImplUnitTest extends UnitTest {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testRemoveTopScreen() {
        addScreen("Screen A");
        addScreen("Screen B");
        addScreen("Screen C");
        removeTopScreen(); // must remove Screen C
        assertTopScreenIsB();
        assertBackstackEntryCountIsTwo();
    }

    private void addScreen(final String screenName) {
        final BaseFragment screen = new BaseFragment() {
            @Override
            public String getScreenTitle() {
                return screenName;
            }
        };

        TestActivity activity = getActivity();
        activity.getScreenController().addScreen(screen, screenName);
        activity.getSupportFragmentManager().executePendingTransactions();
    }

    private void removeTopScreen() {
        getActivity().getScreenController().removeTopScreen();
        getActivity().getSupportFragmentManager().executePendingTransactions();
    }

    private void assertTopScreenIsB() {
        assertTrue(getActivity().getSupportFragmentManager().findFragmentByTag("Screen B") != null);
    }

    private void assertBackstackEntryCountIsTwo() {
        assertTrue(getActivity().getSupportFragmentManager().getBackStackEntryCount() == 2);
    }
}
