package com.vsrstudio.helloartem.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.vsrstudio.helloartem.R;
import com.vsrstudio.helloartem.adapters.AnimalsAdapter;

public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private final String[] animalNames = {
            "Медведь",
            "Бегемот"/*,
            "Дельфин",
            "Орел",
            "Слон",
            "Лиса",
            "Геккон",
            "Хаски",
            "Колибри",
            "Божья коровка",
            "Леопард",
            "Панда",
            "Белый медведь",
            "Щенок",
            "Тигр",
            "Кит",
            "Волк" */
    };

    private final int[] animalPics = {
            R.drawable.bear,
            R.drawable.begemoth/*,
            R.drawable.dolphin,
            R.drawable.eagle,
            R.drawable.elephant,
            R.drawable.fox,
            R.drawable.gecko,
            R.drawable.hasky,
            R.drawable.kolibri,
            R.drawable.ladybug,
            R.drawable.leopard,
            R.drawable.panda,
            R.drawable.polar_bear,
            R.drawable.puppy,
            R.drawable.tiger,
            R.drawable.whale,
            R.drawable.wolf */
    };
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView animalsList = (ListView) findViewById(R.id.animals_list);
        animalsList.setAdapter(new AnimalsAdapter(this, animalNames, animalPics));
        animalsList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, AnimalActivity.class);
        intent.putExtra("name", animalNames[position]);
        intent.putExtra("pic", animalPics[position]);
        startActivity(intent);
    }
}
