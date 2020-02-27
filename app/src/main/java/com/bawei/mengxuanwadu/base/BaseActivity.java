package com.bawei.mengxuanwadu.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bawei.mengxuanwadu.R;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
protected P mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());

        mPresenter=privatePresenter();
        if (mPresenter != null) {
            mPresenter.aTach(this);
        }
        ButterKnife.bind(this);
        initView();
        initDate();

    }

    protected abstract void initDate();

    protected abstract void initView();

    protected abstract P privatePresenter();

    protected abstract int layoutId();
}
