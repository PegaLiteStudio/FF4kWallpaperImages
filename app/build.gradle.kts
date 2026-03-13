plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services)
    alias(libs.plugins.google.firebase.firebase.perf)
}

android {
    namespace = "com.pegalite.ff4kwallpaperimages"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.pegalite.ff4kwallpaperimages"
        minSdk = 24
        targetSdk = 36
        versionCode = 8
        versionName = "1.8"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        viewBinding = true
    }

//    tasks.withType<JavaCompile>().configureEach {
//        options.compilerArgs.add("-Xlint:deprecation")
//    }

}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    implementation(project(":app:alerts"))

    /* For Responsive Layout*/
    implementation(libs.sdp.android)
    implementation(libs.ssp.android)

    implementation(libs.picasso)

    implementation(libs.glide)

    /*For Ads*/
    implementation(libs.play.services.ads)
    implementation(libs.unity.ads)
    implementation(libs.unity)

    implementation(libs.firebase.analytics)
    implementation(libs.firebase.messaging)
    implementation(libs.firebase.perf)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}
