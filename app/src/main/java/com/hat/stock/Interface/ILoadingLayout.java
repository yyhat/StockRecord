package com.hat.stock.Interface;

/**
 * Created by anting.hu on 2015/11/27.
 */
public interface ILoadingLayout {
    public abstract int getContentSize();

    public abstract State getState();

    public abstract void onPull(float paramFloat);

    public abstract void setState(State paramState);

    public enum State
    {
        NONE,
        RESET,
        PULL_TO_REFRESH,
        RELEASE_TO_REFRESH,
        REFRESHING,
        LOADING,
        NO_MORE_DATA
    }



}
