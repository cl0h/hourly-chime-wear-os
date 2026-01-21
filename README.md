# Hourly Chime for Wear OS

## Overview
"Hourly Chime" brings the timeless tradition of the hourly chime right to your wrist. Designed for Wear OS devices (including Google Pixel Watch), this app offers a gentle nudge through sound or vibration, ensuring you stay aligned with time throughout your day.

## Current Status

⚠️ **Early Development Phase** - This project is in active development. Core functionality is being implemented, but the app is not yet feature-complete.

### What Works
- ✅ Basic Wear OS app structure with Compose UI
- ✅ Hourly alarm scheduling (starts at 8 AM)
- ✅ Basic chime/vibration mechanism
- ✅ Wear OS Tile support (displays "Hello World!")
- ✅ Wear OS Complication support (shows day of week)

### What's In Progress
- 🚧 Customizable chime sounds
- 🚧 User settings interface
- 🚧 Do Not Disturb integration
- 🚧 Flexible scheduling options
- 🚧 Battery optimization

## Prerequisites

Before building this project, ensure you have the following installed:

1. **Android Studio** (Arctic Fox or newer recommended)
   - Download from: https://developer.android.com/studio

2. **Java Development Kit (JDK) 11 or newer**
   - Android Studio typically includes this
   - Verify with: `java -version`

3. **Android SDK** with the following components:
   - Android SDK Build-Tools 34.0.0 or newer
   - Android SDK Platform 34 (Android 14)
   - Wear OS system images (for emulator testing)

4. **A Wear OS Device or Emulator**
   - Physical device: Google Pixel Watch, Samsung Galaxy Watch 4/5/6, or other Wear OS 3.0+ device
   - Emulator: Wear OS emulator (can be configured in Android Studio AVD Manager)

## Building the Project

### Step 1: Clone the Repository

```bash
git clone https://github.com/cl0h/hourly-chime-wear-os.git
cd hourly-chime-wear-os
```

### Step 2: Open in Android Studio

1. Launch Android Studio
2. Select **File > Open**
3. Navigate to the cloned repository directory
4. Click **OK**
5. Wait for Gradle sync to complete (this may take a few minutes on first run)

### Step 3: Configure Build

The project uses:
- **Gradle 8.2** (specified in gradle-wrapper.properties)
- **Android Gradle Plugin 8.2.2**
- **Kotlin 1.9.0**
- **Compile SDK: 34** (Android 14)
- **Min SDK: 30** (Wear OS 3.0+)
- **Target SDK: 34**

No additional configuration should be needed.

### Step 4: Build the APK

#### Using Android Studio:
1. Select **Build > Make Project** to compile
2. Select **Build > Build Bundle(s) / APK(s) > Build APK(s)**
3. Once complete, click **locate** in the notification to find the APK
4. The APK will be in: `app/build/outputs/apk/debug/app-debug.apk`

#### Using Command Line:
```bash
# On Linux/macOS:
./gradlew assembleDebug

# On Windows:
gradlew.bat assembleDebug
```

The APK will be generated at: `app/build/outputs/apk/debug/app-debug.apk`

## Installing on Google Pixel Watch (or Other Wear OS Devices)

### Method 1: Direct Installation via ADB (Recommended for Development)

1. **Enable Developer Options on your watch:**
   - Go to **Settings > System > About**
   - Tap **Build number** 7 times
   - Go back to **Settings > Developer options**
   - Enable **ADB debugging** and **Debug over Wi-Fi**

2. **Connect your watch to your computer:**

   **Via USB (if using a phone as bridge):**
   ```bash
   # Check connected devices
   adb devices
   
   # If watch appears, install directly
   adb -s <DEVICE_ID> install app/build/outputs/apk/debug/app-debug.apk
   ```

   **Via Wi-Fi:**
   ```bash
   # Find watch IP address (Settings > Developer options > Debug over Wi-Fi)
   # Connect to watch
   adb connect <WATCH_IP_ADDRESS>:5555
   
   # Verify connection
   adb devices
   
   # Install APK
   adb install app/build/outputs/apk/debug/app-debug.apk
   ```

3. **Launch the app:**
   - Open app drawer on watch
   - Find "Hourly Chime"
   - Tap to open

### Method 2: Installation via Android Studio

1. **Connect your Wear OS device** (via USB or Wi-Fi)
2. **In Android Studio:**
   - Select your watch from the device dropdown menu at the top
   - Click the **Run** button (green play icon) or press **Shift+F10**
   - Android Studio will build and install the app automatically

### Method 3: Using a Wear OS Emulator

1. **Create a Wear OS emulator:**
   - In Android Studio, go to **Tools > Device Manager**
   - Click **Create Device**
   - Select a Wear OS device (e.g., "Wear OS Small Round")
   - Select a system image (API 30 or higher with Wear OS)
   - Click **Finish**

2. **Run the app:**
   - Start the emulator
   - Click the **Run** button in Android Studio
   - Select the running emulator

## Using the App

Once installed:

1. **Grant Permissions:** The app may request permissions for alarms and notifications
2. **Main Screen:** Shows "HourlyChime" text with current time
3. **Hourly Chimes:** The app will chime/vibrate every hour starting from 8 AM
4. **Tile:** You can add the Hourly Chime tile to your watch face
5. **Complication:** You can add the day-of-week complication to supported watch faces

## Project Structure

```
hourly-chime-wear-os/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/cl0h/hourlychime/
│   │       │   ├── presentation/
│   │       │   │   ├── MainActivity.kt       # Main app UI and alarm setup
│   │       │   │   └── theme/Theme.kt        # Compose theme
│   │       │   ├── tile/
│   │       │   │   └── MainTileService.kt    # Wear OS Tile implementation
│   │       │   ├── complication/
│   │       │   │   └── MainComplicationService.kt  # Watch face complication
│   │       │   └── AlarmReceiver.kt          # Handles hourly chime triggers
│   │       ├── res/                          # Resources (layouts, strings, icons)
│   │       └── AndroidManifest.xml
│   └── build.gradle.kts                      # App-level build configuration
├── build.gradle.kts                          # Project-level build configuration
├── settings.gradle.kts                       # Gradle settings
└── README.md
```

## Troubleshooting

### Build Issues

**Problem:** Gradle sync fails
- **Solution:** Ensure you have JDK 11 installed and Android Studio is up to date
- Try: **File > Invalidate Caches > Invalidate and Restart**

**Problem:** "Android Gradle plugin requires Java 11 to run"
- **Solution:** Set JDK 11 in **File > Project Structure > SDK Location**

### Installation Issues

**Problem:** `adb devices` shows no devices
- **Solution:** 
  - Ensure USB debugging is enabled on the watch
  - Try different USB cable or port
  - For Wi-Fi: Verify IP address and ensure devices are on same network

**Problem:** "INSTALL_FAILED_UPDATE_INCOMPATIBLE"
- **Solution:** Uninstall existing version: `adb uninstall com.cl0h.hourlychime`

### Runtime Issues

**Problem:** App crashes on launch
- **Solution:** Check logs: `adb logcat | grep HourlyChime`
- The app requires Wear OS 3.0+ (API level 30+)

**Problem:** Chimes not sounding
- **Solution:** 
  - Ensure app has permission to set alarms
  - Check if Do Not Disturb is enabled
  - Restart the watch

## Contributing

Contributions are welcome! Areas that need work:

- Implementing user settings for chime customization
- Adding Do Not Disturb integration
- Improving battery efficiency
- Adding more chime sound options
- Implementing flexible scheduling (e.g., business hours only)
- UI/UX improvements
- Testing on various Wear OS devices

Please open an issue before starting work on major features.

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.

## Compatibility

- **Minimum:** Wear OS 3.0 (API level 30)
- **Target:** Android 14 (API level 34)
- **Tested on:** Google Pixel Watch (Wear OS 4.0)
- **Expected to work on:** Samsung Galaxy Watch 4/5/6, Fossil Gen 6, TicWatch Pro 3/5, and other Wear OS 3.0+ devices

## Support

For issues, questions, or suggestions:
- Open an issue on GitHub: https://github.com/cl0h/hourly-chime-wear-os/issues
- Check existing issues before creating a new one
