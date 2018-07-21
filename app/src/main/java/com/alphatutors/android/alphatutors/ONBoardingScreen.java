package com.alphatutors.android.alphatutors;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ONBoardingScreen extends AppCompatActivity {


    private ViewPager myViewPager;
    private LinearLayout linearLayout;

    private TextView[] dotsIndicator;


    private SliderAdapter sliderAdapter;

    private Button previousButton;
    private Button nextButton;

    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_screen);


        myViewPager = findViewById(R.id.viewPager);
        linearLayout = findViewById(R.id.slideIndicator);


        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);



        sliderAdapter = new SliderAdapter(this);

        myViewPager.setAdapter(sliderAdapter);

        addDOtsIndicator(0);

        myViewPager.addOnPageChangeListener(viewListener);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewPager.setCurrentItem(currentPage + 1);
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewPager.setCurrentItem(currentPage - 1);
            }
        });
    }

    public void addDOtsIndicator(int position){
        dotsIndicator = new TextView[3];
        linearLayout.removeAllViews();

        for(int i = 0; i < dotsIndicator.length; i++){
            dotsIndicator[i] = new TextView(this);
            dotsIndicator[i].setText(Html.fromHtml("&#8226;"));
            dotsIndicator[i].setTextSize(35);
            dotsIndicator[i].setTextColor(getResources().getColor(R.color.colorGrey));

            linearLayout.addView(dotsIndicator[i]);
        }

        if(dotsIndicator.length > 0){

            dotsIndicator[position].setTextColor(getResources().getColor(R.color.colorWhite));

        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDOtsIndicator(position);
            currentPage = position;

            if(position == 0){
                nextButton.setEnabled(true);
                previousButton.setEnabled(false);
                previousButton.setVisibility(View.INVISIBLE);

                nextButton.setText("next");
                previousButton.setText("");
            } else if (position == dotsIndicator.length - 1){
                nextButton.setEnabled(true);
                previousButton.setEnabled(true);
                previousButton.setVisibility(View.VISIBLE);

                nextButton.setText("");
                previousButton.setText("Previous");

            } else {
                nextButton.setEnabled(true);
                previousButton.setEnabled(true);
                previousButton.setVisibility(View.VISIBLE);

                nextButton.setText("Next");
                previousButton.setText("Previous");
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
