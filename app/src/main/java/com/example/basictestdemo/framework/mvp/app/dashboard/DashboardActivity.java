package com.example.basictestdemo.framework.mvp.app.dashboard;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.basictestdemo.R;

import com.example.basictestdemo.framework.mvp.app.dashboard.benefits.BenefitsFragment;
import com.example.basictestdemo.framework.mvp.app.dashboard.claims.ClaimsFragment;
import com.example.basictestdemo.framework.mvp.app.dashboard.home.HomeFragment;
import com.example.basictestdemo.framework.mvp.app.dashboard.more.MoreFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.nav_home) {
                selectedFragment = new HomeFragment();
            } else if (itemId == R.id.nav_benefits) {
                selectedFragment = new BenefitsFragment();
            } else if (itemId == R.id.nav_claim) {
                selectedFragment = new ClaimsFragment();
            } else if (itemId == R.id.nav_more) {
                selectedFragment = new MoreFragment();
            }

            if (selectedFragment != null) {
                loadFragment(selectedFragment);
            }

            return true;
        });

        // Load the default fragment when the activity is created
        if (savedInstanceState == null) {
            bottomNav.setSelectedItemId(R.id.nav_home); // Set Home as selected
        }
    }

    /**
     * Helper method to load a fragment into the container.
     * @param fragment The fragment to load.
     */
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }
}

