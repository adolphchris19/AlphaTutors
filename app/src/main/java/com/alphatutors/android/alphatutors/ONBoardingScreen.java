package com.alphatutors.android.alphatutors;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
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
    private Button skip;
    private Button login;
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDOtsIndicator(position);
            currentPage = position;

            if (position == 0) {
                nextButton.setEnabled(true);
                previousButton.setEnabled(true);
                previousButton.setVisibility(View.INVISIBLE);
                skip.setVisibility(View.VISIBLE);
                nextButton.setVisibility(View.VISIBLE);
                login.setVisibility(View.GONE);
                //previousButton.setText("Skip");

                nextButton.setText("next");
                skip.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ONBoardingScreen.this, LoginActivity.class);
                        startActivity(intent);
                    }
                });

            } else if (position == dotsIndicator.length - 1) {
                nextButton.setEnabled(true);
                previousButton.setEnabled(true);
                skip.setVisibility(View.GONE);
                previousButton.setVisibility(View.VISIBLE);
                nextButton.setEnabled(false);
                //nextButton.setText("Sign In");
                nextButton.setVisibility(View.GONE);
                login.setVisibility(View.VISIBLE);
                previousButton.setText("Previous");

                login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ONBoardingScreen.this, LoginActivity.class);
                        startActivity(intent);
                    }
                });
            } else {
                nextButton.setEnabled(true);
                previousButton.setEnabled(true);
                previousButton.setVisibility(View.VISIBLE);
                skip.setVisibility(View.GONE);
                login.setVisibility(View.GONE);
                nextButton.setVisibility(View.VISIBLE);
                nextButton.setText("Next");
                previousButton.setText("Previous");

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private int currentPage;
    private TextView header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_screen);


        myViewPager = findViewById(R.id.viewPager);
        linearLayout = findViewById(R.id.slideIndicator);


        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);
        skip = findViewById(R.id.skipButton);
        header = findViewById(R.id.onboardHeader);
        login = findViewById(R.id.loginButton);



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

}
