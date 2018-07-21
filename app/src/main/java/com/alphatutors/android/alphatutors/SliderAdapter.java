package com.alphatutors.android.alphatutors;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    //Image Array
    public int[] onboardImages = {
            R.drawable.tutor2,
            R.drawable.tutor2,
            R.drawable.tutor2
    };

    //Image Array
    public String[] onboardHeader = {
            "me",
            "you",
            "us"
    };

    //Image Array
    public String[] onboardText = {
            "me",
            "you",
            "us"
    };


    @Override
    public int getCount() {
        return onboardHeader.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImages = view.findViewById(R.id.onboardImages);
        TextView textHeading = view.findViewById(R.id.onboardHeader);
        TextView textDescription = view.findViewById(R.id.onboardText);

        slideImages.setImageResource(onboardImages[position]);
        textHeading.setText(onboardHeader[position]);
        textDescription.setText(onboardText[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
