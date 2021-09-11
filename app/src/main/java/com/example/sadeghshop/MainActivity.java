package com.example.sadeghshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;


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


public class MainActivity extends AppCompatActivity{

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Fragment selectedFragment  = null;
   // private boolean loggedIn = true;
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
        drawerLayout =  findViewById(R.id.myDrawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open_actionbar, R.string.close_actionbar);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //setting drawer menu item listener
        NavigationView navigationView = findViewById(R.id.side_navigation);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) sideNavigationItemSelectedListener);



        //setting bottom navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener((NavigationBarView.OnItemSelectedListener) bottomNavigationItemSelectedListener);

        //setting our first fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

    }



    public void setMyFragment(Fragment fragment){
        this.selectedFragment = fragment;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //drawer btn stuff
        if (item != null && item.getItemId() == android.R.id.home) {
            if (drawerLayout.isDrawerOpen(Gravity.RIGHT))
                drawerLayout.closeDrawer(Gravity.RIGHT);
            else
                drawerLayout.openDrawer(Gravity.RIGHT);
        }
        return super.onOptionsItemSelected(item);
    }



    //bottom nav item select
    private BottomNavigationView.OnItemSelectedListener bottomNavigationItemSelectedListener = new BottomNavigationView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.nav_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.nav_profile:
                    if (loggedIn) {
                        selectedFragment = new ProfileFragment();
                        break;
                    }
                    else {
                        Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                        startActivity(intent);
                        return true;
                    }
                case R.id.nav_cart:
                    selectedFragment = new CartFragment();
                    break;
                case R.id.nav_categories:
                    selectedFragment = new CategoriesFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();
            return true;
        }
    };





    //side nav item selected
    private NavigationView.OnNavigationItemSelectedListener sideNavigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
//            Toast.makeText(getBaseContext(),"this works",
//                    Toast.LENGTH_SHORT).show();

            switch (item.getItemId()) {
                case R.id.nav_about:
                    selectedFragment = new AboutFragment();
                    break;
                case R.id.nav_settings:
                    selectedFragment = new SettingsFragment();
                    break;
                case R.id.nav_exit:
                    finish();
                    System.exit(0);
                    break;
            }
            drawerLayout.closeDrawers();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();
            return true;
        }
    };




}