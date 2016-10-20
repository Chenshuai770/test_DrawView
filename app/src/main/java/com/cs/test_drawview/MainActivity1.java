package com.cs.test_drawview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

public class MainActivity1 extends AppCompatActivity {
    private Toolbar mToolBar;
    private ActionBarDrawerToggle mDrawerToggle;
    private NavigationView nv_menu_left;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.two);

        mToolBar = (Toolbar) findViewById(R.id.mToolBar);
        nv_menu_left = (NavigationView) findViewById(R.id.nv_menu_left);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        mToolBar.setTitle("标题");  //设置主标题
        setSupportActionBar(mToolBar); //设置actionbar

        getSupportActionBar().setHomeButtonEnabled(true);  //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //创建返回键，并实现打开关/闭监听
/*
* 给定的Activity将被链接到指定的DrawerLayout及其ActionBar的向上按钮将被设置为自定义绘制。
此drawable在抽屉关闭时显示一个汉堡图标，当抽屉打开时显示一个箭头。 它在抽屉打开时在这两个状态之间动画。
* */
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                mToolBar.setTitle("我还是高手");
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                mToolBar.setTitle("");

            }
        };
        mDrawerToggle.syncState();  //初始化状态
        mDrawerLayout.addDrawerListener(mDrawerToggle); //将DrawerLayout与DrawerToggle绑定
       mDrawerLayout.setScrimColor(Color.TRANSPARENT);   //去除侧边阴影

//给NavigationView设置点击事件
        nv_menu_left.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_item1:
                        mToolBar.setTitle("选项一");
                        break;
                    case R.id.navigation_item2:
                        mToolBar.setTitle("选项二");
                        break;
                    case R.id.navigation_item3:
                        mToolBar.setTitle("选项三");
                        break;
                    case R.id.navigation_sub_item1:
                        mToolBar.setTitle("简介");
                        break;
                    case R.id.navigation_sub_item2:
                        mToolBar.setTitle("详情");
                        break;
                    case R.id.navigation_sub_item3:
                        mToolBar.setTitle("更多");
                        break;
                }

                //将选中设为点击状态
                item.setChecked(true);
                //关闭抽屉
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }


}
