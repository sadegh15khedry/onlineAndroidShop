package com.example.sadeghshop;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ResultsActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //setting our custom toolbar
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //bottom navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_profile);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

//        bottomNavigationView.setOnItemSelectedListener((NavigationBarView.OnItemSelectedListener) bottomNavigationItemSelectedListener);

        //setting drawer and drawer toggle btn
        drawerLayout = findViewById(R.id.myDrawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open_actionbar, R.string.close_actionbar);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }

    public void onResume() {

//        String[] titles = {"آیتم1", "آیتم1", "آیتم1", "آیتم1", "آیتم1"};
        //String[] titles = {"test","test","test","test","test"};
        //String[] prices = {"2000", "2000", "2000", "2000", "2000"};

        String[] titles = getResources().getStringArray(R.array.results_titles);
        String[] prices = getResources().getStringArray(R.array.results_prices);
        int[] images = {R.drawable.wallpaper, R.drawable.wallpaper,
                R.drawable.wallpaper};
        RecyclerView recyclerResultsView = findViewById(R.id.recycler_results_view);
        ResultsAdapter adapter = new ResultsAdapter(this, titles, prices,images);
        recyclerResultsView.setAdapter(adapter);
        recyclerResultsView.setLayoutManager(new LinearLayoutManager(getBaseContext()));


        super.onResume();
    }

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
}
