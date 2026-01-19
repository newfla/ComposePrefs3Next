import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.compiler)
}

android {

    compileSdk = 36
    defaultConfig {
        applicationId = "com.jamal.composeprefs3sample"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled  = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlin {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_1_8
        }
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    namespace = "com.jamal.composeprefs3sample"
}

dependencies {

    implementation (libs.core.ktx)
    implementation (libs.material)
    implementation(libs.material.icons.extended)
    implementation (libs.compose.ui)
    implementation (libs.material3)
    implementation (libs.material3.window.size)
    implementation (libs.ui.tooling.preview)
    implementation (libs.lifecycle.runtime.ktx)
    implementation (libs.activity.compose)
    testImplementation (libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)

    // ComposePrefs library
    implementation(project(":ComposePrefs3"))
    implementation(libs.datastore.preferences)
}