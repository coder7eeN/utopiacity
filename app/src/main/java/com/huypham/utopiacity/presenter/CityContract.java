package com.huypham.utopiacity.presenter;

import com.huypham.utopiacity.data.model.City;

import java.util.List;

/**
 * Created by HuyPhamNA on 4/21/19
 */
public interface CityContract {
    interface View {
        void setPresenter(Presenter presenter);

        void loadDataToRecyclerView(List<City> cityList);
    }

    interface Presenter {
        void getCityList(List<City> cityList);
    }
}
