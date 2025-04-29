package com.example.toastproject;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.styledtoast.AnimationType;
import com.example.styledtoast.StyledToast;
import com.example.styledtoast.ToastType;
import com.google.android.material.snackbar.Snackbar;

/**
 * MainActivity - Demonstrates usage of the StyledToast library with various examples.
 */
public class MainActivity extends AppCompatActivity {

    // UI Components
    private Button btnSuccess, btnError, btnWarning, btnInfo;
    private Button btnRetry, btnCustom, btnPreset, btnLoading, btnVibrate;
    private View rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
    }

    /**
     * Initializes view components by finding them from the layout.
     */
    private void initViews() {
        rootLayout = findViewById(R.id.root_layout);

        btnSuccess = findViewById(R.id.btn_success);
        btnError = findViewById(R.id.btn_error);
        btnWarning = findViewById(R.id.btn_warning);
        btnInfo = findViewById(R.id.btn_info);
        btnRetry = findViewById(R.id.btn_retry);
        btnCustom = findViewById(R.id.btn_custom);
        btnPreset = findViewById(R.id.btn_preset);
        btnLoading = findViewById(R.id.btn_loading);
        btnVibrate = findViewById(R.id.btn_vibrate);
    }

    /**
     * Sets up the click listeners for each button.
     */
    private void initListeners() {
        btnSuccess.setOnClickListener(v ->
                StyledToast.success(this, "Success Toast!"));

        btnError.setOnClickListener(v ->
                StyledToast.error(this, "Something went wrong!"));

        btnWarning.setOnClickListener(v ->
                StyledToast.warning(this, "Warning Toast!"));

        btnInfo.setOnClickListener(v ->
                StyledToast.info(this, "Info Toast!"));

        btnRetry.setOnClickListener(v ->
                Snackbar.make(rootLayout, "Connection failed", Snackbar.LENGTH_INDEFINITE)
                        .setAction("RETRY", v1 -> showRetrySnackbar())
                        .setActionTextColor(Color.YELLOW)
                        .show()
        );

        btnCustom.setOnClickListener(v ->
                StyledToast.custom(this)
                        .message("🚀 Custom Toast Working!")
                        .backgroundColor(Color.parseColor("#6200EA"))
                        .textColor(Color.WHITE)
                        .icon(R.drawable.success)
                        .animationType(AnimationType.SLIDE_IN_BOTTOM)
                        .duration(3000)
                        .show()
        );

        btnVibrate.setOnClickListener(v ->
                StyledToast.custom(this)
                        .message("✅ Vibrate Toast")
                        .backgroundColor(Color.parseColor("#388E3C"))
                        .textColor(Color.WHITE)
                        .icon(R.drawable.success)
                        .animationType(AnimationType.FADE_IN)
                        .duration(2500)
                        .vibrate(true)
                        .show()
        );

        btnPreset.setOnClickListener(v ->
                StyledToast.preset(this, ToastType.SUCCESS, "Preset: Data saved!")
        );

        btnLoading.setOnClickListener(v -> {
            StyledToast.showLoader(this, "Uploading...");
            new Handler().postDelayed(() -> {
                StyledToast.dismissLoader();
                StyledToast.preset(this, ToastType.SUCCESS, "Upload complete!");
            }, 3000);
        });
    }

    /**
     * Shows a Snackbar when the retry action is pressed.
     */
    private void showRetrySnackbar() {
        Snackbar.make(rootLayout, "RETRY BUTTON PRESSED", Snackbar.LENGTH_SHORT).show();
    }
}
