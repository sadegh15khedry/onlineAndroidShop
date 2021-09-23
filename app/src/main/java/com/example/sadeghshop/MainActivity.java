package com.example.sadeghshop;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;


//                    Toast.makeText(getBaseContext(),"this works",
//                    Toast.LENGTH_SHORT).show();

//        Button button = (Button) findViewById(R.id.button_1);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Snackbar.make(view,"thank god",Snackbar.LENGTH_LONG).show();
//                Intent intent = new Intent(HomeActivity.this, AboutActivity.class);
//                startActivity(intent);
//            }
//        });


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Fragment selectedFragment;
    private BottomNavigationView bottomNavigationView;
    //private boolean loggedIn = true;
    private boolean loggedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting our custom toolbar
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //setting drawer and drawer toggle btn
        drawerLayout = findViewById(R.id.myDrawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open_actionbar, R.string.close_actionbar);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //setting drawer menu item listener
        NavigationView navigationView = findViewById(R.id.side_navigation);
        navigationView.setNavigationItemSelectedListener(sideNavigationItemSelectedListener);

        //setting bottom navigation
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(bottomNavigationItemSelectedListener);

        //setting our first fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.nav_home);


//        final TextInputLayout textInputLayout = findViewById(R.id.search_input_layout);
//        textInputLayout.setEndIconOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Toast.makeText(getBaseContext(), "this works",
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //drawer btn stuff
//        if (item != null && item.getItemId() == android.R.id.home) {
        if (item.getItemId() == android.R.id.home) {

            if (drawerLayout.isDrawerOpen(Gravity.RIGHT))
                drawerLayout.closeDrawer(Gravity.RIGHT);
            else
                drawerLayout.openDrawer(Gravity.RIGHT);
        }
        return super.onOptionsItemSelected(item);
    }


    //bottom nav item select
    final private BottomNavigationView.OnItemSelectedListener bottomNavigationItemSelectedListener = new BottomNavigationView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            if (item.getItemId() == R.id.nav_home) {
                selectedFragment = new HomeFragment();

            } else if (item.getItemId() == R.id.nav_categories) {
                selectedFragment = new CategoriesFragment();

            } else if (item.getItemId() == R.id.nav_cart) {
                selectedFragment = new CartFragment();

            } else if (item.getItemId() == R.id.nav_profile && loggedIn) {
                selectedFragment = new ProfileFragment();

            } else if (item.getItemId() == R.id.nav_profile&& !loggedIn) {
                selectedFragment = new LoginFragment();
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();
            return true;
        }

    };


    //side nav item selected
    final private NavigationView.OnNavigationItemSelectedListener sideNavigationItemSelectedListener
            = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            selectedFragment = new HomeFragment();

            if (item.getItemId() == R.id.nav_about) {
                selectedFragment = new AboutFragment();
            } else if (item.getItemId() == R.id.nav_exit) {
                Intent intent = new Intent(getBaseContext(), ItemActivity.class);
                startActivity(intent);
                return true;
            }

            drawerLayout.closeDrawers();
            bottomNavigationView.getMenu().setGroupCheckable(0, false, true);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();
            return true;
        }
    };


}
