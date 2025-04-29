package com.example.styledtoast;

import android.graphics.Color;

/**
 * StyledToastTheme - Class representing the customizable theme for StyledToast.
 * Allows setting background color, text color, font size, and corner radius.
 */
public class StyledToastTheme {

    private int backgroundColor = Color.DKGRAY;
    private int textColor = Color.WHITE;
    private int fontSizeSp = 16;
    private int cornerRadiusDp = 12;

    //========================//
    //    Getters and Setters
    //========================//

    /**
     * Get the background color.
     */
    public int getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Set the background color.
     * @param backgroundColor color to be set
     * @return this StyledToastTheme instance
     */
    public StyledToastTheme setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * Get the text color.
     */
    public int getTextColor() {
        return textColor;
    }

    /**
     * Set the text color.
     * @param textColor color to be set
     * @return this StyledToastTheme instance
     */
    public StyledToastTheme setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    /**
     * Get the font size in sp units.
     */
    public int getFontSizeSp() {
        return fontSizeSp;
    }

    /**
     * Set the font size in sp units.
     * @param fontSizeSp font size to be set
     * @return this StyledToastTheme instance
     */
    public StyledToastTheme setFontSizeSp(int fontSizeSp) {
        this.fontSizeSp = fontSizeSp;
        return this;
    }

    /**
     * Get the corner radius in dp units.
     */
    public int getCornerRadiusDp() {
        return cornerRadiusDp;
    }

    /**
     * Set the corner radius in dp units.
     * @param cornerRadiusDp radius to be set
     * @return this StyledToastTheme instance
     */
    public StyledToastTheme setCornerRadiusDp(int cornerRadiusDp) {
        this.cornerRadiusDp = cornerRadiusDp;
        return this;
    }
}