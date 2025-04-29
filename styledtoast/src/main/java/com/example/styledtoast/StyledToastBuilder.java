package com.example.styledtoast;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Vibrator;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * StyledToastBuilder - Builder class for creating fully customizable Toast messages.
 */
public class StyledToastBuilder {

    private final Context context;
    private String message;
    private int backgroundColor = -1;
    private int textColor = -1;
    private int iconResId = 0;
    private int durationMillis = 2000;
    private AnimationType animationType = AnimationType.SLIDE_IN_BOTTOM;
    private boolean vibrateOnShow = false;

    /**
     * Constructor that initializes the builder with a Context and applies global theme if set.
     */
    public StyledToastBuilder(Context context) {
        this.context = context;
        applyGlobalTheme();
    }

    /**
     * Applies a global theme if one is set.
     */
    private void applyGlobalTheme() {
        StyledToastTheme theme = StyledToast.getGlobalTheme();
        if (theme != null) {
            backgroundColor = theme.getBackgroundColor();
            textColor = theme.getTextColor();
        }
    }

    //========================//
    //    Builder Setters
    //========================//

    public StyledToastBuilder message(String message) {
        this.message = message;
        return this;
    }

    public StyledToastBuilder backgroundColor(int color) {
        this.backgroundColor = color;
        return this;
    }

    public StyledToastBuilder textColor(int color) {
        this.textColor = color;
        return this;
    }

    public StyledToastBuilder icon(int iconResId) {
        this.iconResId = iconResId;
        return this;
    }

    public StyledToastBuilder duration(int millis) {
        this.durationMillis = millis;
        return this;
    }

    public StyledToastBuilder animationType(AnimationType type) {
        this.animationType = type;
        return this;
    }

    public StyledToastBuilder vibrate(boolean vibrate) {
        this.vibrateOnShow = vibrate;
        return this;
    }

    //========================//
    //    Showing the Toast
    //========================//

    /**
     * Builds and shows the customized Toast.
     */
    public void show() {
        View layout = View.inflate(context, R.layout.custom_toast, null);

        LinearLayout container = layout.findViewById(R.id.toast_container);
        TextView text = layout.findViewById(R.id.toast_text);
        ImageView icon = layout.findViewById(R.id.toast_icon);
        Button action = layout.findViewById(R.id.toast_action);

        initToastViews(container, text, icon, action);
        animateToast(layout);

        Toast toast = new Toast(context);
        toast.setView(layout);
        toast.setGravity(Gravity.BOTTOM, 0, 150);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();

        handleCustomDuration(toast);
        handleVibration();
    }

    /**
     * Initializes the views inside the custom toast layout.
     */
    private void initToastViews(LinearLayout container, TextView text, ImageView icon, Button action) {
        text.setText(message);
        container.setBackgroundColor(backgroundColor != -1 ? backgroundColor : Color.DKGRAY);
        text.setTextColor(textColor != -1 ? textColor : Color.WHITE);

        if (iconResId != 0) {
            icon.setVisibility(View.VISIBLE);
            icon.setImageResource(iconResId);
        } else {
            icon.setVisibility(View.GONE);
        }

        action.setVisibility(View.GONE); // Hide action button by default
    }

    /**
     * Applies the chosen animation type to the layout.
     */
    private void animateToast(View layout) {
        int animResId = getAnimationResId(animationType);
        if (animResId != 0) {
            Animation anim = AnimationUtils.loadAnimation(context, animResId);
            layout.startAnimation(anim);
        }
    }

    /**
     * Handles custom duration logic if duration is longer than default.
     */
    private void handleCustomDuration(Toast toast) {
        if (durationMillis > 2000) {
            new Handler().postDelayed(toast::cancel, durationMillis);
        }
    }

    /**
     * Handles device vibration if enabled.
     */
    private void handleVibration() {
        if (vibrateOnShow) {
            Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
            if (vibrator != null && vibrator.hasVibrator()) {
                vibrator.vibrate(100);
            }
        }
    }

    /**
     * Maps AnimationType enum to corresponding animation resource ID.
     */
    private int getAnimationResId(AnimationType type) {
        switch (type) {
            case SLIDE_IN_BOTTOM:
                return R.anim.slide_in_bottom;
            case FADE_IN:
                return R.anim.fade_in;
            case POP_IN:
                return R.anim.pop_in;
            case BOUNCE_IN:
                return R.anim.bounce_in;
            default:
                return 0;
        }
    }
}