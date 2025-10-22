plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.basictestdemo"
    compileSdk = 34 // It's better to use a specific number, e.g., 34, which is common now

    defaultConfig {
        applicationId = "com.example.basictestdemo"
        minSdk = 24
        targetSdk = 34 // Target SDK should also be a specific number
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        // The old support libraries require this flag, but it's better to migrate to AndroidX
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8 // Changed to 1.8 for better compatibility with older libs
        targetCompatibility = JavaVersion.VERSION_1_8 // Changed to 1.8
    }
}

dependencies {
    // --- MODERN ANDROIDX LIBRARIES (from your plugins) ---
    // These are the correct, modern libraries. You should use these instead of the old "com.android.support" ones.
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation("com.github.bumptech.glide:glide:5.0.5")
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
