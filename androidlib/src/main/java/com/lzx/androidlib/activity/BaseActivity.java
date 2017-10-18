package com.lzx.androidlib.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews(savedInstanceState);
        initDatas();
    }

    protected abstract void initViews(@Nullable Bundle savedInstanceState);

    protected abstract void initDatas();

    protected void newActivity(Class<?> cls, @Nullable Bundle bundle){
        Intent intent = new Intent(this, cls);
        if (bundle != null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    protected void replaceFragment(@IdRes int contentViewId, Fragment fragment){
        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.replace(contentViewId, fragment).commit();
    }

    protected void showShortToast(@StringRes int redID){
        Toast.makeText(this, redID, Toast.LENGTH_SHORT).show();
    }

    protected void showLongToast(@StringRes int redID){
        Toast.makeText(this, redID, Toast.LENGTH_LONG).show();
    }
}
