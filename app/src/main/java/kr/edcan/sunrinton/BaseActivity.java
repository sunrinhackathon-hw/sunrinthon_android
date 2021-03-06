package kr.edcan.sunrinton;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public abstract class BaseActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewDataBinding baseBinding;
    Menu menu;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        baseBinding = DataBindingUtil.setContentView(this, onCreateViewId());
        if (onCreateViewToolbarId() != 0) {
            toolbar = (Toolbar) findViewById(onCreateViewToolbarId());
            setSupportActionBar(toolbar);
            toolbar.setTitleTextColor(Color.BLACK);
            toolbar.setContentInsetStartWithNavigation(0);
            toolbar.setTitleTextAppearance(getApplicationContext(),R.style.ActionBar_NameText);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.parseColor("#BDBDBD"));
            getWindow().setNavigationBarColor(Color.BLACK);
        }
        setDefault();
    }

    @Override
    public void setContentView(int layoutResId) {
        super.setContentView(layoutResId);
    }

    protected abstract void setDefault();

    @LayoutRes
    protected abstract int onCreateViewId();

    @IdRes
    protected abstract int onCreateViewToolbarId();


    public void disableToggle() {
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    public void enableToggle() {
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void setToolbarTitle(String titleStr) {
        this.getSupportActionBar().setTitle(titleStr);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
