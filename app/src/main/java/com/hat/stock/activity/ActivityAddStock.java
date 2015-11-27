package com.hat.stock.activity;

import android.app.Activity;
import android.os.Bundle;

import com.hat.stock.R;

/**
 * Created by anting.hu on 2015/11/26.
 */
public class ActivityAddStock extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trade_virtual_layout);
    }
}
