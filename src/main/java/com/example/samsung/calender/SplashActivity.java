package com.example.samsung.calender;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * Created by samsung on 2016-12-04.
 */

public class SplashActivity extends AppCompatActivity{

    final String TAG = "SplashAnim";
    ImageView mSch;
    FrameLayout mFrame;
    int mScreenHeight;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setTitle("DR Scheduler");

        mSch = (ImageView)findViewById(R.id.schP);
        mFrame = (FrameLayout)findViewById(R.id.activity_splash);
    }
    protected void onResume() {
        super.onResume();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        mScreenHeight = displayMetrics.heightPixels;

        startCalValueAnimation();
    }

        private void startCalValueAnimation() {
            ValueAnimator positionAnimator = ValueAnimator.ofFloat(0, -mScreenHeight);
            positionAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float value = (float) valueAnimator.getAnimatedValue();
                    mSch.setTranslationY(value);
                }
            });

            positionAnimator.start();
            positionAnimator.start();
            ValueAnimator fadeAnim = ObjectAnimator.ofFloat(mSch, "alpha", 0f, 1f);
            fadeAnim.setDuration(1000);
            ValueAnimator scaleAnimator = ValueAnimator.ofFloat(0f, 1f);
            scaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float value = (float) valueAnimator.getAnimatedValue();
                    mSch.setScaleX(value);
                    mSch.setScaleY(value);
                }
            });

            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new DecelerateInterpolator());
            animatorSet.play(fadeAnim).with(scaleAnimator);
            // animatorSet.play(scaleAnimator).with(fadeAnim);
            animatorSet.setStartDelay(2000);
            animatorSet.setDuration(2000);
            animatorSet.start();
            animatorSet.addListener(animatorListener);

        }
    Animation.AnimationListener animationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {
            Log.i(TAG, "onAnimationStart");
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Log.i(TAG, "onAnimationEnd");
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            Log.i(TAG, "onAnimationRepeat");
        }
    };

    Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animator) {
            Log.i(TAG, "onAnimationStart");
        }

        @Override
        public void onAnimationEnd(Animator animator) {
            Log.i(TAG, "onAnimationEnd");
        }

        @Override
        public void onAnimationCancel(Animator animator) {
            Log.i(TAG, "onAnimationCancel");
        }

        @Override
        public void onAnimationRepeat(Animator animator) {
            Log.i(TAG, "onAnimationRepeat");
        }
    };

}
