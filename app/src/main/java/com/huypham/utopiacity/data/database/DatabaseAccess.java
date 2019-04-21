package com.huypham.utopiacity.data.database;

import android.content.Context;

import com.huypham.utopiacity.data.model.City;

import java.util.List;

/**
 * Created by HuyPhamNA on 4/20/19
 */
public class DatabaseAccess {
    private DatabaseHelper mDatabaseHelper;

    public DatabaseAccess(Context context) {
        mDatabaseHelper = new DatabaseHelper(context);
    }

    public List<City> getCityListData() {
        return mDatabaseHelper.getCityListFromDatabase();
    }

    public int getTotalRecord() {
        return mDatabaseHelper.countNumberOfTotalRecord();
    }
}
