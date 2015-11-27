package com.hat.stock.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.hat.stock.Interface.InputListener;
import com.hat.stock.R;
import com.hat.stock.Tools.DialogUtils;
import com.hat.stock.bean.StockItemData;

/**
 * Created by anting.hu on 2015/11/26.
 */
public class AddStockDialogFragment extends DialogFragment {


    private EditText addStockName;
    private EditText addStockCode;
    private RadioGroup addStockRadioGroup;
    private EditText addStockNum;
    private EditText addStockPrice;
    private EditText addStockType;
    private EditText addStockRecommendStar;
    private Button mOkBtn;
    private Button mCancelBtn;

    private boolean mIsAdd;
    private StockItemData mData;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle.containsKey("flag"))
            mIsAdd = bundle.getBoolean("flag");

        if(bundle.containsKey("stock"))
            mData = (StockItemData)bundle.get("stock");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(false);
        View view =  inflater.inflate(R.layout.activity_add, container);
        initControl(view);
        initData();

        mOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameStr = addStockName.getText().toString().trim();
                String codeStr = addStockCode.getText().toString().trim();
                String numStr = addStockNum.getText().toString().trim();
                String priceStr = addStockPrice.getText().toString().trim();
                String starStr = addStockRecommendStar.getText().toString().trim();
                String typeStr = addStockType.getText().toString().trim();

                if ((nameStr == null || nameStr.isEmpty()) &&
                        (codeStr == null || codeStr.isEmpty())) {
                    Toast.makeText(getActivity(), "亲，股票名称和股票代码不能都不填", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!isCheck()) {
                    Toast.makeText(getActivity(), "亲，你是想买入还是卖出呢？", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean isBuy = addStockRadioGroup.getCheckedRadioButtonId() == R.id.buyRadioBtn;

                int num = 0, code = 0;
                float price = 0;
                float star = 0;

                if(numStr != null  && !numStr.isEmpty())
                    num = Integer.parseInt(numStr);

                if(priceStr != null&& !priceStr.isEmpty())
                    price = Float.parseFloat(priceStr);

                if(starStr != null&& !starStr.isEmpty())
                    star = Float.parseFloat(starStr);

                if(codeStr != null && !codeStr.isEmpty())
                    code = Integer.parseInt(codeStr);

                //检查 卖出数量不可以超过持有数量
                if (!isBuy && num > mData.getNum()) {
                    Toast.makeText(getActivity(), "亲，你没有那么多股票可卖", Toast.LENGTH_SHORT).show();
                    return;
                }

                StockItemData data = new StockItemData();

                if (isBuy) {
                    data.setChangeNum(num);
                } else {
                    data.setChangeNum(-num);
                }

                data.setChangePrice(price);
                data.setName(nameStr);
                data.setId(code);
                data.setType(typeStr);
                data.setRecommendStar(star);
                InputListener listener = (InputListener) getActivity();
                listener.onAddInputComplete(mIsAdd, data);
                dismiss();
            }
        });

        mCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    dismiss();
            }
        });
        return view;
    }


    private void initControl(View view) {
        addStockName = (EditText)view.findViewById(R.id.addStockName);
        addStockCode = (EditText)view.findViewById(R.id.addStockCode);
        addStockRadioGroup = (RadioGroup)view.findViewById(R.id.addStockRadioGroup);
        addStockNum = (EditText)view.findViewById(R.id.addStockNum);
        addStockPrice = (EditText)view.findViewById(R.id.addStockPrice);
        addStockType = (EditText)view.findViewById(R.id.addStockType);
        addStockRecommendStar = (EditText)view.findViewById(R.id.addStockRecommendStar);
        mOkBtn = (Button)view.findViewById(R.id.addOkBtn);
        mCancelBtn = (Button)view.findViewById(R.id.addCancelBtn);
    }

    private void initData() {
        if(mIsAdd)
        {
            addStockRadioGroup.check(R.id.buyRadioBtn);
            addStockRadioGroup.setEnabled(false);
        }
        else
        {
            addStockName.setText(mData.getName());
            addStockCode.setText(mData.getId());
            addStockRadioGroup.setEnabled(true);
            addStockNum.setText(mData.getNum());
            addStockPrice.setText(mData.getCurPrice() + "");
            addStockType.setText(mData.getType());
            addStockRecommendStar.setText(mData.getRecommendStar() +"");
        }
    }

    private boolean isCheck() {

        int id= addStockRadioGroup.getCheckedRadioButtonId();
        return (id == R.id.buyRadioBtn || id == R.id.sellRadioBtn);
    }
    @Override
    public void onStart() {
        super.onStart();
        WindowManager.LayoutParams lp = DialogUtils.createLayoutParams(getDialog());
        getDialog().getWindow().setAttributes(lp);
    }

}
