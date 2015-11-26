package com.hat.stock;

import com.hat.stock.bean.StockItemData;

/**
 * Created by anting.hu on 2015/11/26.
 */
public interface InputListener {
    void onAddInputComplete(boolean isAdd, StockItemData data);
}
