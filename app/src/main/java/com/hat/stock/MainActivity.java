package com.hat.stock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;

import com.hat.stock.Interface.InputListener;
import com.hat.stock.activity.ActivityAddStock;
import com.hat.stock.activity.AddStockDialogFragment;
import com.hat.stock.activity.BaseFragment;
import com.hat.stock.bean.StockItemData;

import java.util.List;


public class MainActivity extends FragmentActivity implements InputListener {

    private Menu mOptionMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        mOptionMenu = menu;

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_add)
        {
            AddStockDialogFragment dialog = new AddStockDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("flag", true);
            dialog.setArguments(bundle);
            dialog.show(getSupportFragmentManager(), "AddStockDialogFragment");
        }
        else if(item.getItemId() == R.id.menu_test)
        {
            Intent intent = new Intent(MainActivity.this, ActivityAddStock.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAddInputComplete(boolean isAdd, StockItemData data) {
        FragmentManager fm = getSupportFragmentManager();
        List<Fragment> fragList = fm.getFragments();
        for(int i=0; i< fragList.size(); i++)
        {
            if(fragList.get(i) instanceof BaseFragment)
            {
                BaseFragment baseFrag = (BaseFragment)fragList.get(i);
                baseFrag.onAddInputComplete(isAdd, data);
            }
        }
    }
}
