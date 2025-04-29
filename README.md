
🎨 StyledToast
A customizable Toast library for Android – featuring icons, custom backgrounds, multiple animations, vibration support, Loader Toasts, preset types (Success, Error, Warning, Info), and more!

🚀 Key Features
✅ Beautiful toasts with icons

✅ Preset Toasts: Success, Error, Warning, Info

✅ Flexible custom toast using a Builder pattern

✅ Support for multiple animation types (Slide, Fade, Pop, Bounce)

✅ Loader Toast with dismiss option

✅ Global Theme support for unified style

✅ Vibration support on toast display

✅ Rounded corners and RTL (Right-to-Left) support

✅ Custom duration (any milliseconds)

📱 Demo Application
This project includes a fully working demo app (:app module)
where you can interactively test:

Regular styled toasts

Custom Builder toasts

Loader toasts

All animation types

Toasts with vibration

The demo app makes it easy to preview all features live.

🛠 Installation
Add the library as a module or import it as an .aar file.

Add the required permission for vibration in your AndroidManifest.xml:

xml
Copy
Edit
<uses-permission android:name="android.permission.VIBRATE" />
✨ Usage
Preset Toasts
java
Copy
Edit
StyledToast.preset(context, ToastType.SUCCESS, "Saved successfully!");
StyledToast.preset(context, ToastType.ERROR, "Something went wrong!");
StyledToast.preset(context, ToastType.WARNING, "This is a warning.");
StyledToast.preset(context, ToastType.INFO, "FYI: Information message.");
Custom Toast with Builder
java
Copy
Edit
StyledToast.custom(context)
    .message("Hello World!")
    .backgroundColor(Color.DKGRAY)
    .textColor(Color.WHITE)
    .icon(R.drawable.success)
    .animationType(AnimationType.BOUNCE_IN)
    .duration(3000) // milliseconds
    .vibrate(true)
    .show();
Loader Toast (With Auto Dismiss)
java
Copy
Edit
StyledToast.showLoader(context, "Uploading...");

new Handler().postDelayed(() -> {
    StyledToast.dismissLoader();
    StyledToast.preset(context, ToastType.SUCCESS, "Upload complete!");
}, 3000);
Global Theme (Optional)
java
Copy
Edit
StyledToast.setGlobalTheme(new StyledToastTheme()
    .setBackgroundColor(Color.BLACK)
    .setTextColor(Color.WHITE)
    .setFontSizeSp(16)
    .setCornerRadiusDp(20));
Once set, all StyledToasts will inherit this theme unless explicitly overridden.

🎬 Supported Animation Types

Animation Type	Description
SLIDE_IN_BOTTOM	Smooth slide from bottom
FADE_IN	Soft fade-in with slight scaling
POP_IN	Quick pop/bounce effect
BOUNCE_IN	Springy bounce entrance
Use like:

java
Copy
Edit
.animationType(AnimationType.POP_IN)
📸 Screenshots
(Screenshots of sample toasts can be added here.)

📋 Important Notes
Vibration: Requires <uses-permission android:name="android.permission.VIBRATE" />

Animations: Located inside res/anim folder

RTL Support: Built-in (layoutDirection="locale")

Custom Duration: Supports manual millisecond duration instead of just SHORT/LONG.

📚 Credits
Developed with ❤️ to enhance Android user experience with more modern and customizable toasts.
