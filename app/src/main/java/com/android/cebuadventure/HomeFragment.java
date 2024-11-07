package com.android.cebuadventure;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;

public class HomeFragment extends Fragment {

    private Spinner citySpinner;
    private EditText searchBar;
    private TextView locationTitle;
    private TextView popularTitle;
    private TextView recommendedTitle;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize views
        citySpinner = view.findViewById(R.id.citySpinner);
        searchBar = view.findViewById(R.id.searchBar);
        locationTitle = view.findViewById(R.id.locationTitle);
        popularTitle = view.findViewById(R.id.popularTitle);
        recommendedTitle = view.findViewById(R.id.recommendedTitle);

        // Set up city spinner, search bar, and other elements as needed

        return view;
    }
}
