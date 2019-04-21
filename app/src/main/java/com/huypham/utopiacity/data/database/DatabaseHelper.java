package com.huypham.utopiacity.data.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.huypham.utopiacity.data.model.City;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuyPhamNA on 4/20/19
 */
public class DatabaseHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "utopia_cities.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_TABLE = "cities";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_COUNTRY = "country";
    private static final String COLUMN_CITY = "city";
    private static final String COLUMN_POPULATION = "population";

    private SQLiteDatabase mDatabase;
    private Cursor mCursor;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public List<City> getCityListFromDatabase() {
        List<City> cityList = new ArrayList<>();
        mDatabase = this.getWritableDatabase();
        final String query = "SELECT * FROM " + DATABASE_TABLE;
        mCursor = mDatabase.rawQuery(query, null);
        if (mCursor.moveToFirst()) {
            while (mCursor.moveToNext()) {
                City cityObj = new City();
                cityObj.setId(mCursor.getString(mCursor.getColumnIndex(COLUMN_ID)));
                cityObj.setCountry(mCursor.getString(mCursor.getColumnIndex(COLUMN_COUNTRY)));
                cityObj.setCity(mCursor.getString(mCursor.getColumnIndex(COLUMN_CITY)));
                cityObj.setPopulation(mCursor.getInt(mCursor.getColumnIndex(COLUMN_POPULATION)));
                cityList.add(cityObj);
            }
        }
        mCursor.close();
        mDatabase.close();
        return cityList;
    }

    public int countNumberOfTotalRecord() {
        int totalRecord;
        final String query = "SELECT * FROM " + DATABASE_TABLE;
        mDatabase = this.getWritableDatabase();
        mCursor = mDatabase.rawQuery(query, null);
        totalRecord = mCursor.getCount();
        mCursor.close();
        return totalRecord;
    }
}
