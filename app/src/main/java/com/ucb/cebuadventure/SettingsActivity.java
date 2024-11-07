package com.ucb.cebuadventure;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private Switch switchLocation, switchDarkMode;
    private SharedPreferences sharedPreferences;

    // Keys for SharedPreferences
    private static final String PREFS_NAME = "UserSettings";
    private static final String KEY_LOCATION = "location_enabled";
    private static final String KEY_DARK_MODE = "dark_mode_enabled";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Initialize views
        switchLocation = findViewById(R.id.switchLocation);
        switchDarkMode = findViewById(R.id.switchDarkMode);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        // Load saved states
        loadSettings();

        // Toggle precise location switch
        switchLocation.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(KEY_LOCATION, isChecked);
            editor.apply();
        });

        // Toggle dark mode switch
        switchDarkMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(KEY_DARK_MODE, isChecked);
            editor.apply();
        });
    }

    // Method to load saved settings
    private void loadSettings() {
        boolean isLocationEnabled = sharedPreferences.getBoolean(KEY_LOCATION, false);
        boolean isDarkModeEnabled = sharedPreferences.getBoolean(KEY_DARK_MODE, false);

        switchLocation.setChecked(isLocationEnabled);
        switchDarkMode.setChecked(isDarkModeEnabled);
    }
}