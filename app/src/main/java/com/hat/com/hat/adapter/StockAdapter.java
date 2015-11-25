package com.hat.com.hat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hat.bean.StockItemData;
import com.hat.stock.R;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

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
            convertView = (View)mInflater.inflate(R.layout.list_stock_item, parent, false);
            holder = new ViewHodler();
            holder.NameTxtView = (TextView)convertView.findViewById(R.id.name_textview);
            holder.IdTxtView = (TextView)convertView.findViewById(R.id.id_textview);
            holder.CurPriceTxtView = (TextView)convertView.findViewById(R.id.cur_price_txtview);
            holder.CostPriceTxtView = (TextView)convertView.findViewById(R.id.cost_price_txtview);
            holder.NumTxtView = (TextView)convertView.findViewById(R.id.stock_num_txtview);
            holder.RatioTxtView = (TextView)convertView.findViewById(R.id.radio_txtview);
            holder.TypeTxtView = (TextView)convertView.findViewById(R.id.stock_type_txtview);
            holder.RecommendStarTxtView = (TextView)convertView.findViewById(R.id.recommend_star_txtview);
            holder.OnewordDesTxtView = (TextView)convertView.findViewById(R.id.oneword_des_txtview);
            holder.HistoryBtn = (Button)convertView.findViewById(R.id.history_btn);
            holder.EditBtn = (Button)convertView.findViewById(R.id.edit_btn);
            convertView.setTag(holder);

            holder.HistoryBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext,"click history btn", Toast.LENGTH_LONG).show();
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
        public Button HistoryBtn;
        public Button EditBtn;
    }
}
