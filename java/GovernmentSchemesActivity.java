package com.example.cropguard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class GovernmentSchemesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_government_schemes);

        // Agriculture Infrastructure Fund Link
        TextView agriInfraLink = findViewById(R.id.agriInfraLink);
        agriInfraLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = getString(R.string.agriculture_infrastructure_fund_link); // Corrected
                openUrl(url);
            }
        });

        // Animal Husbandry Infrastructure Development Fund Link
        TextView ahidfLink = findViewById(R.id.ahidfLink);
        ahidfLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = getString(R.string.animal_husbandry_fund_link); // Corrected
                openUrl(url);
            }
        });

        // Credit facility for farmers Link
        TextView cfffLink = findViewById(R.id.cfffLink);
        cfffLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = getString(R.string.credit_facility_link); // Corrected
                openUrl(url);
            }
        });

        // Crop insurance schemes Link
        TextView cisLink = findViewById(R.id.cisLink);
        cisLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = getString(R.string.crop_insurance_link); // Corrected
                openUrl(url);
            }
        });

        // National Mission on Natural Farming Link
        TextView nmonfLink = findViewById(R.id.nmonfLink);
        nmonfLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = getString(R.string.natural_farming_link); // Corrected
                openUrl(url);
            }
        });

        // Pradhan Mantri Kisan Samman Nidhi Link
        TextView pmksnLink = findViewById(R.id.pmksnLink);
        pmksnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = getString(R.string.kisan_samman_nidhi_link); // Corrected
                openUrl(url);
            }
        });
    }

    private void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}