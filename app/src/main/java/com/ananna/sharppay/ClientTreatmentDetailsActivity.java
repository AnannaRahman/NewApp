package com.ananna.sharppay;

import android.graphics.Color;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ClientTreatmentDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_treatment_details);

        ToolbarInit();
        BottombarInit();
    }
    public void BottombarInit() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);
    }
    public void ToolbarInit() {
        TextView toolbartitle = findViewById(R.id.toolbar_title);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.mounting_name));
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorGray));
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorOffWhite));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbartitle.setVisibility(View.GONE);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        setSupportActionBar(toolbar);

    }

}
