package com.bawei.mengxuanwadu.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.mengxuanwadu.R;
import com.bawei.mengxuanwadu.base.BaseActivity;
import com.bawei.mengxuanwadu.base.BasePresenter;
import com.bawei.mengxuanwadu.view.fragment.FindFragment;
import com.bawei.mengxuanwadu.view.fragment.HomeFragment;
import com.bawei.mengxuanwadu.view.fragment.MyFragment;
import com.bawei.mengxuanwadu.view.fragment.OrderFragment;
import com.bawei.mengxuanwadu.view.fragment.ShoppingCartFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.main_vp)
    ViewPager mainVp;
    @BindView(R.id.sy)
    RadioButton sy;
    @BindView(R.id.fx)
    RadioButton fx;
    @BindView(R.id.gwc)
    RadioButton gwc;
    @BindView(R.id.order)
    RadioButton order;
    @BindView(R.id.mine)
    RadioButton mine;
    @BindView(R.id.main_rg)
    RadioGroup mainRg;

    @Override
    protected void initDate() {
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new FindFragment());
        list.add(new ShoppingCartFragment());
        list.add(new OrderFragment());
        list.add(new MyFragment());
        mainVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
    }

    @Override
    protected void initView() {
        mainVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mainRg.check(mainRg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected BasePresenter privatePresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }


    @OnClick({R.id.sy, R.id.fx, R.id.gwc, R.id.order, R.id.mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sy:
                mainVp.setCurrentItem(0);
                break;
            case R.id.fx:
                mainVp.setCurrentItem(1);
                break;
            case R.id.gwc:
                mainVp.setCurrentItem(2);
                break;
            case R.id.order:
                mainVp.setCurrentItem(3);
                break;
            case R.id.mine:
                mainVp.setCurrentItem(4);
                break;
        }
    }
}
