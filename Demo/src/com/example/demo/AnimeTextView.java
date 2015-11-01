package com.example.demo;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

public class AnimeTextView extends TextView{

	public AnimeTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	public void setFadeText(CharSequence text){
		final int color = AnimeTextView.this.getCurrentTextColor();
		final CharSequence cs = text;
		final int alpha = color >>> 24, red = Color.red(color), green = Color.green(color), blue = Color.blue(color);
		
		ValueAnimator valueAnimator = ValueAnimator.ofInt(alpha, 0, alpha);
		valueAnimator.setEvaluator(new IntEvaluator());
		valueAnimator.setInterpolator(new LinearInterpolator());
	    valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
	        @Override
	        public void onAnimationUpdate(ValueAnimator animator) {
	            int value = (Integer)animator.getAnimatedValue();
	            AnimeTextView.this.setTextColor(Color.argb(value, red, green, blue));
	            if(value == 0){
	            	AnimeTextView.this.setText(cs);
	            }
	        }
	    });
	    valueAnimator.setDuration(5000).start();
	}

}
