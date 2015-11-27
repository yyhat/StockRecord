package com.hat.stock.bean;

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



    private int ChangeNum;
    private float ChangePrice;
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

    public int getChangeNum() {
        return ChangeNum;
    }

    public void setChangeNum(int changeNum) {
        ChangeNum = changeNum;
    }

    public float getChangePrice() {
        return ChangePrice;
    }

    public void setChangePrice(float changePrice) {
        ChangePrice = changePrice;
    }

    public void updateData()
    {
        //添加股票
        if(getNum() == 0)
        {
            setNum(getChangeNum());
            //保存到数据库
            setCostPrice(getChangePrice());
        }
        else //编辑股票
        {
            boolean isBuy = getChangeNum() > 0;
            float totalCost = getCostPrice() * getNum();
            float changeCost = getChangeNum() * getChangePrice();

            //保存到数据库修改记录

            setCostPrice((totalCost + changeCost) / (getNum() + getChangeNum()));
        }
    }
}
