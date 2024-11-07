package com.ucb.cebuadventure;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private ImageView imgProfilePicture;
    private EditText etName, etEmail, etBirthdate;
    private Button btnUploadPhoto, btnSave;
    private SharedPreferences sharedPreferences;

    // Keys for SharedPreferences
    private static final String PREFS_NAME = "UserProfile";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_BIRTHDATE = "birthdate";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize views
        imgProfilePicture = findViewById(R.id.imgProfilePicture);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etBirthdate = findViewById(R.id.etBirthdate);
        btnUploadPhoto = findViewById(R.id.btnUploadPhoto);
        btnSave = findViewById(R.id.btnSave);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        // Load saved data (if any)
        loadProfileData();

        // Upload photo button click handler (Stub - actual implementation depends on app requirements)
        btnUploadPhoto.setOnClickListener(v -> {
            // Code to upload a photo (Implementation would depend on requirements)
        });

        // Save button click handler
        btnSave.setOnClickListener(v -> saveProfileData());
    }

    // Method to save profile data
    private void saveProfileData() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String birthdate = etBirthdate.getText().toString().trim();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_BIRTHDATE, birthdate);
        editor.apply();

        Toast.makeText(this, "Profile saved", Toast.LENGTH_SHORT).show();
    }

    // Method to load profile data
    private void loadProfileData() {
        String name = sharedPreferences.getString(KEY_NAME, "");
        String email = sharedPreferences.getString(KEY_EMAIL, "");
        String birthdate = sharedPreferences.getString(KEY_BIRTHDATE, "");

        etName.setText(name);
        etEmail.setText(email);
        etBirthdate.setText(birthdate);
    }
}