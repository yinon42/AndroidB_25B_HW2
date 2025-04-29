# 🎨 StyledToast

A customizable Toast library for Android – featuring icons, custom backgrounds, multiple animations, vibration support, loader toasts, preset types (Success, Error, Warning, Info), and more.

---

## ✅ Key Features

- ✔️ Beautiful toasts with icons  
- ✔️ Preset Toasts: `Success`, `Error`, `Warning`, `Info`  
- ✔️ Flexible custom toast using a Builder pattern  
- ✔️ Support for multiple animation types: `Slide`, `Fade`, `Pop`, `Bounce`  
- ✔️ Loader Toast with dismiss option  
- ✔️ Global Theme support for unified style  
- ✔️ Vibration support on toast display  
- ✔️ Rounded corners and RTL support  
- ✔️ Custom duration (in milliseconds)

---

## 📱 Demo Application

This project includes a **fully working demo app** (`:app` module)  
that lets you interactively test all toast types:

- Regular styled toasts  
- Custom Builder toasts  
- Loader toasts  
- All animation types  
- Toasts with vibration

> The demo app makes it easy to preview all features live.

---

## 🛠 Installation

Add the library as a module or import it as an `.aar` file.  
Don't forget to add this permission in your `AndroidManifest.xml`:

```xml
<uses-permission android:name="android.permission.VIBRATE" />
```

---

## ✨ Usage Examples

### 🔹 Preset Toasts

```java
StyledToast.preset(context, ToastType.SUCCESS, "Saved successfully!");
StyledToast.preset(context, ToastType.ERROR, "Something went wrong!");
StyledToast.preset(context, ToastType.WARNING, "This is a warning.");
StyledToast.preset(context, ToastType.INFO, "FYI: Information message.");
```

---

### 🔹 Custom Toast (Builder)

```java
StyledToast.custom(context)
    .message("Hello World!")
    .backgroundColor(Color.DKGRAY)
    .textColor(Color.WHITE)
    .icon(R.drawable.success)
    .animationType(AnimationType.BOUNCE_IN)
    .duration(3000) // milliseconds
    .vibrate(true)
    .show();
```

---

### 🔹 Loader Toast (with auto-dismiss)

```java
StyledToast.showLoader(context, "Uploading...");

new Handler().postDelayed(() -> {
    StyledToast.dismissLoader();
    StyledToast.preset(context, ToastType.SUCCESS, "Upload complete!");
}, 3000);
```

---

### 🔹 Global Theme

```java
StyledToast.setGlobalTheme(new StyledToastTheme()
    .setBackgroundColor(Color.BLACK)
    .setTextColor(Color.WHITE)
    .setFontSizeSp(16)
    .setCornerRadiusDp(20));
```

---

## 🎬 Supported Animation Types

| Type              | Description                      |
|-------------------|----------------------------------|
| `SLIDE_IN_BOTTOM` | Smooth slide from bottom         |
| `FADE_IN`         | Soft fade-in with slight scaling |
| `POP_IN`          | Fast pop/bounce effect           |
| `BOUNCE_IN`       | Springy bounce entrance          |

Use via:

```java
.animationType(AnimationType.FADE_IN)
```

---

## 📋 Notes

- Vibration requires the permission in manifest  
- Animations are stored under `res/anim`  
- RTL support is built-in  
- Duration is fully customizable (not limited to Toast.LENGTH_SHORT/Toast.LENGTH_LONG)

---

## 🧪 Screenshots

> *(Coming soon — add screenshots here)*

---

## 🧱 Modules Structure

```
/styledtoast     → Library Module (reusable Toast logic)
/app             → Demo Application (interactive testing)
```

---

## 📚 Credits

Created with ❤️ to improve user experience and toast styling for Android apps.
