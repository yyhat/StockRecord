package com.hat.stock.activity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.hat.stock.InputListener;
import com.hat.stock.R;
import com.hat.stock.Tools.DialogUtils;
import com.hat.stock.bean.StockItemData;

/**
 * Created by anting.hu on 2015/11/26.
 */
public class AddStockDialogFragment extends DialogFragment {

    private Button mOkBtn;
    private Button mCancelBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(false);
        View view =  inflater.inflate(R.layout.activity_add, container);
        mOkBtn = (Button)view.findViewById(R.id.addOkBtn);
        mCancelBtn = (Button)view.findViewById(R.id.addCancelBtn);


        mOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    InputListener listener = (InputListener)getActivity();
                StockItemData data = new StockItemData();
                data.setName("");
                listener.onAddInputComplete(true, data);
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        WindowManager.LayoutParams lp = DialogUtils.createLayoutParams(getDialog());
        getDialog().getWindow().setAttributes(lp);
    }

}
