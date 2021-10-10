package com.example.sadeghshop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onResume() {
        Button myButton = getView().findViewById(R.id.first_row_more_btn);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ResultsFragment()).commit();




            }
        });


//        ViewPager2 viewPager2 = getView().findViewById(R.id.view_pager);
//        SlideShowAdapter adapter = new SlideShowAdapter(getContext());
//        viewPager2.se


        super.onResume();
    }

}
