package cn.simonlee.widgetdemo.slidingtablayout;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import cn.simonlee.widget.slidingtablayout.SlidingTabLayout;
import cn.simonlee.widgetdemo.BaseActivity;
import cn.simonlee.widgetdemo.R;

/**
 * 滑动标签页面
 *
 * @author Simon Lee
 * @e-mail jmlixiaomeng@163.com
 * @github https://github.com/Simon-Leeeeeeeee/SLWidget
 * @createdTime 2018-08-16
 */
public class SlidingTabActivity extends BaseActivity implements View.OnClickListener, ViewPager.OnPageChangeListener, SlidingTabLayout.OnTabClickListener {

    private ViewPager mViewPager;
    private SlidingTabLayout mSlidingTabLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slidingtab);
        initView();
    }

    private void initView() {
        Toolbar toolbar = getToolbar();
        if (toolbar != null) {
            toolbar.setTitle(R.string.slidingtablayout);
            toolbar.setNavigationOnClickListener(this);
        }
        mSlidingTabLayout = findViewById(R.id.slidingtab_layout);
        mSlidingTabLayout.setOnTabClickListener(this);

        mViewPager = findViewById(R.id.slidingtab_viewpager);

        mViewPager.setAdapter(new SimpleViewPagerAdapter(10));
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.base_toolbar_navigation: {
                onBackPressed();
                break;
            }
        }
    }

    @Override
    public void onTabClick(SlidingTabLayout parent, View tab, int position) {
        //A. 和ViewPager联动，由ViewPager控制标签的位置
        mViewPager.setCurrentItem(position);
        //B. 不与ViewPager联动，自行切换选中标签
        //mSlidingTabLayout.startSlideAnimation(position, 300);
        //mSlidingTabLayout.selectTab(position, false);
    }

    @Override
    public void onPageSelected(int position) {
        mSlidingTabLayout.selectTab(position, false);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        mSlidingTabLayout.slideTo(position, positionOffset);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

}
