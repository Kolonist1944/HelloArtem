package com.vsrstudio.helloartem.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.vsrstudio.helloartem.R;
import com.vsrstudio.helloartem.adapters.CountriesAdapter;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener,
        SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout refreshLayout;

    private String[] countriesArray = {
            "Абхазия",
            "Австралийский Союз",
            "Австрийская Республика",
            "Азербайджанская Республика",
            "автономная территория Финляндии",
            "Республика Албания",
            "Алжирская Народная Демократическая Республика",
            "заморская территория Великобритании",
            "Республика Ангола",
            "Княжество Андорра",
            "Антигуа и Барбуда",
            "Аргентинская Республика",
            "Республика Армения",
            "Исламская Республика Афганистан",
            "Содружество Багамских Островов",
            "Народная Республика Бангладеш",
            "Барбадос",
            "Королевство Бахрейн",
            "Белиз",
            "Республика Беларусь",
            "Бельгия"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh_layout);
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorSchemeColors(R.color.red, R.color.green, R.color.blue);

        final ListView countriesList = (ListView) findViewById(R.id.countries_list);

        final CountriesAdapter adapter = new CountriesAdapter(this, countriesArray);
        countriesList.setAdapter(adapter);
        countriesList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final TextView text = (TextView) view.findViewById(R.id.country_name);
        final String elementText = String.valueOf(text.getText());
        Toast.makeText(this, elementText, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this, "Updated", Toast.LENGTH_LONG).show();
                refreshLayout.setRefreshing(false);
            }
        }).run();
    }
}
