package com.huypham.utopiacity.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.huypham.utopiacity.R;
import com.huypham.utopiacity.data.model.City;
import com.huypham.utopiacity.presenter.CityContract;
import com.huypham.utopiacity.presenter.CityPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuyPhamNA on 4/21/19
 */
public class CityInformationActivity extends AppCompatActivity implements CityContract.View {
    private RecyclerView mRecyclerViewCity;

    private CityContract.Presenter mPresenter;
    private List<City> mCityList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_information);
        setup();
        initViews();
        loadRecyclerViewCity();
    }

    @Override
    public void setPresenter(CityContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void loadDataToRecyclerView(List<City> cityList) {
        mCityList = cityList;
    }

    private void initViews() {
        mRecyclerViewCity = findViewById(R.id.rvCityInformation);
    }

    private void setup() {
        CityPresenter mCityPresenter = new CityPresenter(CityInformationActivity.this, CityInformationActivity.this);
        mCityPresenter.getCityList(mCityList);
    }

    private void loadRecyclerViewCity() {
        CityInformationAdapter adapter = new CityInformationAdapter(mCityList, CityInformationActivity.this);
        mRecyclerViewCity.setLayoutManager(new LinearLayoutManager(CityInformationActivity.this));
        mRecyclerViewCity.setHasFixedSize(true);
        mRecyclerViewCity.setAdapter(adapter);
    }
}
