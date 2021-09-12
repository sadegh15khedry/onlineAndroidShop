package com.example.sadeghshop;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_home,container,false);

    }

    @Override
    public void onResume() {
        Button myButton = getView().findViewById(R.id.fist_row_see_more);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view,"thank god",Snackbar.LENGTH_LONG).show();
                Intent intent = new Intent(getContext(), ResultsActivity.class);
                startActivity(intent);
            }
        });
        super.onResume();
    }
}
