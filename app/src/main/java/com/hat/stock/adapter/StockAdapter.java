package com.hat.stock.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.hat.stock.bean.StockItemData;
import com.hat.stock.R;

import java.util.List;

/**
 * Created by anting.hu on 2015/11/25.
 */
public class StockAdapter extends BaseAdapter {

    private Context mContext;
    private List<StockItemData> mDataList;
    private LayoutInflater mInflater;

    public StockAdapter(Context context, List<StockItemData> dataList)
    {
        mContext = context;
        mDataList = dataList;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodler holder = null;
        if(convertView == null)
        {
            convertView = (View)mInflater.inflate(R.layout.sellstockitem, parent, false);
            holder = new ViewHodler();
            holder.NameTxtView = (TextView)convertView.findViewById(R.id.stockName);
            holder.IdTxtView = (TextView)convertView.findViewById(R.id.stockCode);
            holder.CurPriceTxtView = (TextView)convertView.findViewById(R.id.newPrice);
            holder.CostPriceTxtView = (TextView)convertView.findViewById(R.id.stockCost);
            holder.NumTxtView = (TextView)convertView.findViewById(R.id.positionNum);
            holder.RatioTxtView = (TextView)convertView.findViewById(R.id.profitValue);
            holder.TypeTxtView = (TextView)convertView.findViewById(R.id.typeValue);
            holder.RecommendStarTxtView = (TextView)convertView.findViewById(R.id.recommendStar);
            holder.OnewordDesTxtView = (TextView)convertView.findViewById(R.id.oneword_des_txtview);
            holder.HistoryBtn = (View)convertView.findViewById(R.id.detailsBtn);
            holder.EditBtn = (View)convertView.findViewById(R.id.editBtn);
            convertView.setTag(holder);

            holder.HistoryBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "click history btn", Toast.LENGTH_LONG).show();
                }
            });

            holder.EditBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext,"click edit btn", Toast.LENGTH_LONG).show();
                }
            });
        }
        else
        {
            holder = (ViewHodler)convertView.getTag();
        }
        StockItemData itemData = mDataList.get(position);
        holder.NameTxtView.setText(itemData.getName());
        holder.IdTxtView.setText(""+itemData.getId());
        holder.CurPriceTxtView.setText(""+itemData.getCurPrice());
        holder.CostPriceTxtView.setText(""+itemData.getCostPrice());
        holder.NumTxtView.setText(""+itemData.getNum());
        holder.RatioTxtView.setText(itemData.getRatio());
        holder.TypeTxtView.setText(itemData.getType());
        holder.RecommendStarTxtView.setText(""+itemData.getRecommendStar());
        holder.OnewordDesTxtView.setText(itemData.getOneWordDes());

        return convertView;
    }

    private static class ViewHodler
    {
        public TextView NameTxtView;
        public TextView IdTxtView;
        public TextView CurPriceTxtView;
        public TextView CostPriceTxtView;
        public TextView NumTxtView;
        public TextView RatioTxtView;
        public TextView TypeTxtView;
        public TextView RecommendStarTxtView;
        public TextView OnewordDesTxtView;
        public View HistoryBtn;
        public View EditBtn;
    }
}
