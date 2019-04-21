package com.huypham.utopiacity.presenter;

import android.content.Context;

import com.huypham.utopiacity.data.database.DatabaseAccess;
import com.huypham.utopiacity.data.model.City;

import java.util.List;

/**
 * Created by HuyPhamNA on 4/21/19
 */
public class CityPresenter implements CityContract.Presenter {
    private DatabaseAccess mDatabaseAccess;
    private CityContract.View mView;

    public CityPresenter(CityContract.View cityView, Context context) {
        this.mView = cityView;
        mView.setPresenter(CityPresenter.this);
        mDatabaseAccess = new DatabaseAccess(context);
    }

    @Override
    public void getCityList(List<City> cityList) {
        mView.loadDataToRecyclerView(mDatabaseAccess.getCityListData());
    }
}
