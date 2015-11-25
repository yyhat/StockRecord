package com.hat.bean;

import java.util.List;

/**
 * Created by anting.hu on 2015/11/25.
 */
public class StockItemData {
    private int Id;
    private String Name;
    private float CurPrice;
    private float CostPrice;
    private int Num;
    private String Ratio;
    private String Type;
    private float RecommendStar;
    private String OneWordDes;
    public List<Integer> mDiaryList;


    public float getCostPrice() {
        return CostPrice;
    }

    public void setCostPrice(float costPrice) {
        CostPrice = costPrice;
    }

    public float getCurPrice() {
        return CurPrice;
    }

    public void setCurPrice(float curPrice) {
        CurPrice = curPrice;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        Num = num;
    }

    public String getOneWordDes() {
        return OneWordDes;
    }

    public void setOneWordDes(String oneWordDes) {
        OneWordDes = oneWordDes;
    }

    public String getRatio() {
        return Ratio;
    }

    public void setRatio(String ratio) {
        Ratio = ratio;
    }

    public float getRecommendStar() {
        return RecommendStar;
    }

    public void setRecommendStar(float recommendStar) {
        RecommendStar = recommendStar;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

}
