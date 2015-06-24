package com.noobs2d.android.yamvp;

import android.content.Context;
import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.RenamingDelegatingContext;

import com.noobs2d.utils.R;

/**
 * @author Julious Igmen
 */
public class UnitTest extends ActivityUnitTestCase<TestActivity> {

    public UnitTest() {
        super(TestActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        Context context = new RenamingDelegatingContext(getInstrumentation().getTargetContext(), "android-utils-test");
        context.setTheme(R.style.AppTheme);

        Intent intent = new Intent(context, TestActivity.class);
        startActivity(intent, null, null);
    }
}
