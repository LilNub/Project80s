package com.example.project80s;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.CirclePageIndicator;
import com.synnapps.carouselview.ImageListener;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    int[] imagesShoes = {R.drawable.cv6,R.drawable.cv7,R.drawable.cv8};
    int[] imagesShoes_test = {R.drawable.cv1,R.drawable.cv2,R.drawable.cv3,R.drawable.cv4,R.drawable.cv5};
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    ImageListener imageListener = (position, imageView) -> imageView.setImageResource(imagesShoes[position]);

    ImageListener imageListener2 = (position, imageView2) -> imageView2.setImageResource(imagesShoes_test[position]);


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView =  inflater.inflate(R.layout.fragment_home, container, false);
        firebaseAuth =firebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        Button shop = rootView.findViewById(R.id.shop);
        shop.setOnClickListener(v -> {
            Intent shop1 = new Intent(v.getContext(), Shop.class);
            startActivity(shop1);
        });
        Button wash = rootView.findViewById(R.id.wash);
        wash.setOnClickListener(v -> {
            Intent wash1 = new Intent(v.getContext(), Wash.class);
            startActivity(wash1);
        });
        Button map = rootView.findViewById(R.id.location);
        map.setOnClickListener(v -> {
            Intent map1 = new Intent(v.getContext(), MapsActivity.class);
            startActivity(map1);
        });

        CarouselView carouselView = rootView.findViewById(R.id.carouselView);
        CirclePageIndicator indicator = carouselView.findViewById(R.id.indicator);
        if(indicator !=null){
            indicator.setVisibility(View.GONE);
        }
        carouselView.setPageCount(imagesShoes.length);
        carouselView.setImageListener(imageListener);
        final CardView cv_testimony = rootView.findViewById(R.id.cardview2);
        cv_testimony.setVisibility(View.GONE);
        CarouselView carouselView1 = rootView.findViewById(R.id.carouselView1);
        carouselView1.setPageCount(imagesShoes_test.length);
        carouselView1.setImageListener(imageListener2);

        final Button dd = rootView.findViewById(R.id.dd);
                dd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cv_testimony.getVisibility() == View.GONE){
                    cv_testimony.setVisibility(View.VISIBLE);
                    dd.setBackgroundResource(R.drawable.ic_drop_up);
                }else if (cv_testimony.getVisibility() == View.VISIBLE){
                    cv_testimony.setVisibility(View.GONE);
                    dd.setBackgroundResource(R.drawable.ic_dropdown);
                }
            }
        });
        return rootView;
    }
}
