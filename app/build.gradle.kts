plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)

    alias(libs.plugins.kotlin.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.kya.newsapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.kya.newsapplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    buildFeatures {
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }


}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // ViewModel
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.livedata)
    // by viewModels() 사용을 위한 Activity KTX, Fragment KTX
    implementation(libs.activity.ktx)

    // Coroutine
    implementation(libs.coroutines.android)

    // Hilt
    implementation(libs.hilt.navigation.fragment)
    implementation(libs.lifecycle.viewmodel.ktx)

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    // Retrofit2
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.gson)

    // Coil(이미지 로더)
    implementation(libs.coil)
}
