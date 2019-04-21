package com.huypham.utopiacity.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.huypham.utopiacity.R;
import com.huypham.utopiacity.data.model.City;

import java.util.List;
import java.util.Locale;

/**
 * Created by HuyPhamNA on 4/21/19
 */
public class CityInformationAdapter extends RecyclerView.Adapter<CityInformationAdapter.CityViewHolder> {
    private List<City> mCityList;
    private Context mContext;

    public CityInformationAdapter(List<City> cityList, Context context) {
        this.mContext = context;
        this.mCityList = cityList;
    }

    @NonNull
    @Override
    public CityInformationAdapter.CityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recycler_city, viewGroup, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityInformationAdapter.CityViewHolder cityViewHolder, int position) {
        cityViewHolder.initData(position);
    }

    @Override
    public int getItemCount() {
        return mCityList.size();
    }

    class CityViewHolder extends RecyclerView.ViewHolder {
        private final TextView mTvCity;
        private final TextView mTvCountry;
        private final TextView mTvPopulation;

        private CityViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvCity = itemView.findViewById(R.id.tvCity);
            mTvCountry = itemView.findViewById(R.id.tvCountry);
            mTvPopulation = itemView.findViewById(R.id.tvPopulation);
        }

        private void initData(int position) {
            City city = mCityList.get(position);
            if (city != null) {
                if (!TextUtils.isEmpty(city.getCity())) {
                    mTvCity.setText(city.getCity());
                } else {
                    mTvCity.setText("");
                }
                if (!TextUtils.isEmpty(city.getCountry())) {
                    mTvCountry.setText(city.getCountry());
                } else {
                    mTvCountry.setText("");
                }
                final String populationValue = String.format(Locale.getDefault(), "%,2d", city.getPopulation());
                mTvPopulation.setText(populationValue);
            } else {
                mTvCountry.setText("");
                mTvCity.setText("");
                mTvPopulation.setText("");
            }
        }
    }
}
