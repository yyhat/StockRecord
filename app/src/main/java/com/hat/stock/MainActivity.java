package com.hat.stock;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;

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
            dialog.show(getSupportFragmentManager(), "AddStockDialogFragment");
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
