package com.vsrstudio.helloartem.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.vsrstudio.helloartem.R;

public class AnimalActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        Intent intent = getIntent();

        final TextView animalNameText = (TextView) findViewById(R.id.animal_name);
        animalNameText.setText(intent.getStringExtra("name"));

        final RoundedImageView animalPic = (RoundedImageView) findViewById(R.id.animal_pic);
        animalPic.setOval(true);
        animalPic.setBorderColor(getResources().getColor(R.color.black));
        animalPic.setBorderWidth(1f);
        animalPic.setImageResource(intent.getIntExtra("pic", R.drawable.polar_bear));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
