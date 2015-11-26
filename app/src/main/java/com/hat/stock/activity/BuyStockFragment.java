package com.hat.stock.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.hat.stock.InputListener;
import com.hat.stock.bean.StockItemData;
import com.hat.stock.adapter.StockAdapter;
import com.hat.stock.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anting.hu on 2015/11/25.
 */
public class BuyStockFragment extends BaseFragment{

    private StockAdapter mStockAdapter;
    private ListView mBuyStockListView;
    private TextView mEmptyTxtView;
    private List<StockItemData> mBuyStockDataList = new ArrayList<StockItemData>();

    //test
    void initData() {

        for(int i=0; i< 2; i++) {

            StockItemData data = new StockItemData();
            data.setId(00000);
            data.setName("龙头股份");
            data.setCurPrice(10);
            data.setCostPrice(22);
            data.setRatio("100%");
            data.setNum(1000);
            data.setRecommendStar(4);
            data.setOneWordDes("逢高减仓");
            data.setType("上海迪士尼");
            mBuyStockDataList.add(data);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        Log.i("test", "onCreateView");
        View view =  inflater.inflate(R.layout.activity_buy_stock,container, false);
        mBuyStockListView = (ListView)view.findViewById(R.id.buy_stock_list);
        mEmptyTxtView = (TextView)view.findViewById(R.id.empty_txtview);



        if(mBuyStockDataList.size() == 0) {
            mEmptyTxtView.setVisibility(View.VISIBLE);
            mBuyStockListView.setVisibility(View.GONE);
        }
        else
        {
            mEmptyTxtView.setVisibility(View.GONE);
            mBuyStockListView.setVisibility(View.VISIBLE);
        }

        mStockAdapter = new StockAdapter(getActivity(),mBuyStockDataList);
        mBuyStockListView.setAdapter(mStockAdapter);

        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("test", "onCreate");

        initData();


    }

    @Override
    public void onAddInputComplete(boolean isAdd, StockItemData data) {

        if(isAdd)
        {
            mBuyStockDataList.add(data);
            mBuyStockListView.invalidate();
        }
    }
}
