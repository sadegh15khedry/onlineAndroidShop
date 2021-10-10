package com.example.sadeghshop;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.sadeghshop.services.MyService;
import com.example.sadeghshop.utils.NetworkHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Fragment selectedFragment;
    private BottomNavigationView bottomNavigationView;
    private boolean isNetworkConnected;
    //private boolean loggedIn = true;
    private boolean loggedIn = false;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //setting our custom toolbar
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        //setting bottom navigation
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(bottomNavigationItemSelectedListener);


        //setting our first fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.nav_home);


        //network check
        isNetworkConnected = NetworkHelper.hasNetwork(this);
//        if (isNetworkConnected){
//            Toast.makeText(getBaseContext(),"network connected",
//                    Toast.LENGTH_SHORT).show();
//        }
//        else {
//            Toast.makeText(getBaseContext(),"network is not connected",
//                    Toast.LENGTH_SHORT).show();
//        }



        //broadcast
        LocalBroadcastManager.getInstance(getApplicationContext())
                .registerReceiver(broadcastReceiver,
                        new IntentFilter(MyService.MY_SERVICE_MESSAGE));



        final TextInputLayout textInputLayout = findViewById(R.id.search_input_layout);
        textInputLayout.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://192.168.88.250:5001/api/items";
                //String url = "https://10.0.2.2:5001/api/items";
                //String url = "https://jsonplaceholder.typicode.com/todos/";
                Intent intent = new Intent(MainActivity.this, MyService.class);
                intent.setData(Uri.parse(url));
                startService(intent);

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
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

            } else if (item.getItemId() == R.id.nav_profile && !loggedIn) {
                selectedFragment = new LoginFragment();
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();
            return true;
        }

    };





    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String message = intent.getStringExtra(MyService.MY_SERVICE_PAYLOAD);

            Toast.makeText(getBaseContext(), message,
                    Toast.LENGTH_SHORT).show();

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();

        LocalBroadcastManager.getInstance(getApplicationContext())
            .unregisterReceiver(broadcastReceiver);
    }
}







//                    Toast.makeText(getBaseContext(),"this works",
//                    Toast.LENGTH_SHORT).show();


//                OkHttpClient client = new OkHttpClient();
//                String url = "http://192.168.88.250:44329/api/Items";
//                Request request = new Request.Builder()
//                        .url(url).build();
//                client.newCall(request).enqueue(new Callback() {
//                    @Override
//                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
//                        e.printStackTrace();
//                    }
//
//                    @Override
//                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
//                        if (response.isSuccessful()){
//                            String myres = response.body().string();
//
//                            MainActivity.this.runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    Toast.makeText(getBaseContext(), myres,
//                                            Toast.LENGTH_SHORT).show();
//                                }
//                            });
//
//                        }
//
//                    }
//                });




//        Button button = (Button) findViewById(R.id.button_1);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Snackbar.make(view,"thank god",Snackbar.LENGTH_LONG).show();
//                Intent intent = new Intent(HomeActivity.this, AboutActivity.class);
//                startActivity(intent);
//            }
//        });\


//    boolean connected = false;
//    ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
//        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
//                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
//                //we are connected to a network
//                connected = true;
//                Toast.makeText(getBaseContext(),"this works",
//                Toast.LENGTH_SHORT).show();
//                }
//                else
//                Toast.makeText(getBaseContext(),"not working",
//                Toast.LENGTH_SHORT).show();