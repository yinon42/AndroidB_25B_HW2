package com.example.styledtoast;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
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
 * StyledToast - A customizable Toast library with support for preset styles,
 * custom themes, and loading indicators.
 */
public class StyledToast {

    // Global toast used for showing loader toasts
    private static Toast loadingToast;

    // Optional global theme applied to all toasts
    private static StyledToastTheme globalTheme = null;

    //========================//
    //    Public Methods
    //========================//

    /**
     * Show a success toast.
     */
    public static void success(Context context, String message) {
        showPresetToast(context, message, Color.parseColor("#2E7D32"), R.drawable.success);
    }

    /**
     * Show an error toast.
     */
    public static void error(Context context, String message) {
        showPresetToast(context, message, Color.parseColor("#C62828"), R.drawable.error);
    }

    /**
     * Show a warning toast.
     */
    public static void warning(Context context, String message) {
        showPresetToast(context, message, Color.parseColor("#EF6C00"), R.drawable.warning);
    }

    /**
     * Show an info toast.
     */
    public static void info(Context context, String message) {
        showPresetToast(context, message, Color.parseColor("#1565C0"), R.drawable.info);
    }

    /**
     * Create a fully customized StyledToast using a builder.
     */
    public static StyledToastBuilder custom(Context context) {
        return new StyledToastBuilder(context);
    }

    /**
     * Show a preset styled toast based on ToastType.
     */
    public static void preset(Context context, ToastType type, String message) {
        int bgColor;
        int iconRes;

        switch (type) {
            case SUCCESS:
                bgColor = Color.parseColor("#2E7D32");
                iconRes = R.drawable.success;
                break;
            case ERROR:
                bgColor = Color.parseColor("#C62828");
                iconRes = R.drawable.error;
                break;
            case WARNING:
                bgColor = Color.parseColor("#EF6C00");
                iconRes = R.drawable.warning;
                break;
            case INFO:
            default:
                bgColor = Color.parseColor("#1565C0");
                iconRes = R.drawable.info;
                break;
        }

        custom(context)
                .message(message)
                .backgroundColor(bgColor)
                .icon(iconRes)
                .duration(2500)
                .animationType(AnimationType.SLIDE_IN_BOTTOM)
                .show();
    }

    /**
     * Show a loader-style toast.
     */
    public static void showLoader(Context context, String message) {
        View layout = View.inflate(context, R.layout.toast_loading, null);
        TextView text = layout.findViewById(R.id.toast_text);

        initLoaderText(text, message);

        loadingToast = new Toast(context);
        loadingToast.setView(layout);
        loadingToast.setDuration(Toast.LENGTH_LONG);
        loadingToast.setGravity(Gravity.BOTTOM, 0, 150);
        loadingToast.show();
    }

    /**
     * Dismiss the currently showing loader toast.
     */
    public static void dismissLoader() {
        if (loadingToast != null) {
            loadingToast.cancel();
            loadingToast = null;
        }
    }

    /**
     * Set a global theme for all toasts.
     */
    public static void setGlobalTheme(StyledToastTheme theme) {
        globalTheme = theme;
    }

    /**
     * Get the currently set global theme.
     */
    public static StyledToastTheme getGlobalTheme() {
        return globalTheme;
    }

    //========================//
    //    Private Helpers
    //========================//

    /**
     * Internal method to show a basic styled toast with background color and icon.
     */
    private static void showPresetToast(Context context, String message, int backgroundColor, int iconResId) {
        View layout = View.inflate(context, R.layout.custom_toast, null);

        LinearLayout container = layout.findViewById(R.id.toast_container);
        TextView text = layout.findViewById(R.id.toast_text);
        ImageView icon = layout.findViewById(R.id.toast_icon);
        Button button = layout.findViewById(R.id.toast_action);

        initToastViews(container, text, icon, button, message, backgroundColor, iconResId);

        animateToast(layout, context);

        Toast toast = new Toast(context);
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 150);
        toast.show();
    }

    /**
     * Initialize views for the custom toast layout.
     */
    private static void initToastViews(LinearLayout container, TextView text, ImageView icon, Button button,
                                       String message, int backgroundColor, int iconResId) {
        text.setText(message);
        container.setBackgroundColor(backgroundColor);
        icon.setImageResource(iconResId);
        icon.setColorFilter(null); // Keep original icon color
        button.setVisibility(View.GONE); // No action button for default toasts
    }

    /**
     * Animate the toast appearance.
     */
    private static void animateToast(View layout, Context context) {
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.slide_in_bottom);
        layout.startAnimation(anim);
    }

    /**
     * Initialize loader toast text view.
     */
    private static void initLoaderText(TextView textView, String message) {
        textView.setText(message);
    }
}
