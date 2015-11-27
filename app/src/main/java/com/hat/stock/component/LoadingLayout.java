package com.hat.stock.component;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.hat.stock.Interface.ILoadingLayout;

/**
 * Created by anting.hu on 2015/11/27.
 */

public abstract class LoadingLayout extends FrameLayout implements ILoadingLayout
{
    private View mContainer;
    private ILoadingLayout.State mCurState;
    private ILoadingLayout.State mPreState;

    public LoadingLayout(Context paramContext)
    {
        this(paramContext, null);
    }

    public LoadingLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
        this(paramContext, paramAttributeSet, 0);
    }

    public LoadingLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
        ILoadingLayout.State localState1 = ILoadingLayout.State.NONE;
        this.mCurState = localState1;
        ILoadingLayout.State localState2 = ILoadingLayout.State.NONE;
        this.mPreState = localState2;
        init(paramContext, paramAttributeSet);
    }

    protected abstract View createLoadingView(Context paramContext, AttributeSet paramAttributeSet);

    public abstract int getContentSize();

    protected ILoadingLayout.State getPreState()
    {
        return this.mPreState;
    }

    public ILoadingLayout.State getState()
    {
        return this.mCurState;
    }

    protected void init(Context paramContext, AttributeSet paramAttributeSet)
    {
        View localView1 = createLoadingView(paramContext, paramAttributeSet);
        this.mContainer = localView1;
        if (this.mContainer == null)
            throw new NullPointerException("Loading view can not be null.");
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
        View localView2 = this.mContainer;
        addView(localView2, localLayoutParams);
    }

    protected void onNoMoreData()
    {
    }

    public void onPull(float paramFloat)
    {
    }

    protected void onPullToRefresh()
    {
    }

    protected void onRefreshing()
    {
    }

    protected void onReleaseToRefresh()
    {
    }

    protected void onReset()
    {
    }

    protected void onStateChanged(ILoadingLayout.State paramState1, ILoadingLayout.State paramState2)
    {
        switch(paramState1)
        {
            case RESET:
                onReset();
                break;

            case PULL_TO_REFRESH:
                onPullToRefresh();
                break;
            case RELEASE_TO_REFRESH:
                onReleaseToRefresh();
                break;
            case REFRESHING:
                onRefreshing();
                break;
            case LOADING:
                break;

            case NO_MORE_DATA:
                onNoMoreData();
                break;
        }
    }

    public void setLastUpdatedLabel(CharSequence paramCharSequence)
    {
    }

    public void setLoadingDrawable(Drawable paramDrawable)
    {
    }

    public void setPullLabel(CharSequence paramCharSequence)
    {
    }

    public void setRefreshingLabel(CharSequence paramCharSequence)
    {
    }

    public void setReleaseLabel(CharSequence paramCharSequence)
    {
    }

    public void setState(ILoadingLayout.State paramState)
    {
        if (this.mCurState != paramState)
        {
            ILoadingLayout.State localState1 = this.mCurState;
            this.mPreState = localState1;
            this.mCurState = paramState;
            ILoadingLayout.State localState2 = this.mPreState;
            onStateChanged(paramState, localState2);
        }
    }

    public void show(boolean paramBoolean)
    {

        ViewGroup.LayoutParams localLayoutParams = mContainer.getLayoutParams();
        if(paramBoolean)
        {
            localLayoutParams.height = LayoutParams.MATCH_PARENT;
            requestLayout();
            setVisibility(View.VISIBLE);
        }
        else
        {
            localLayoutParams.height = 0;
            setVisibility(View.INVISIBLE);
        }
    }
}