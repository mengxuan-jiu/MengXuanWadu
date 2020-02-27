package com.bawei.mengxuanwadu.base;

/**
 * @包名 com.bawei.mengxuanwadu.base
 * @mengxuan
 * @日期2020/2/21
 * @日期2020 : 02:21
 * @项目名MengXuanWadu
 * @类名BasePresenter
 **/
public abstract class BasePresenter<V> {
    protected V view;

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    public void aTach(V view) {
        this.view = view;
    }

    public void dTach() {
        view = null;
    }
}
