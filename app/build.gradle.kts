plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    namespace = "${Versions.applicationId}"
    //namespace = "com.rajendra.sketchide"

    defaultConfig {
        applicationId = "${Versions.applicationId}"
        
        vectorDrawables.useSupportLibrary = true
        //testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        //multiDexEnabled = true
    }
    
    buildTypes {
            /*
            getByName("release") {
                // Enables code shrinking, obfuscation, and optimization for only
                // your project's release build type. Make sure to use a build
                // variant with `isDebuggable=false`.
                isMinifyEnabled = true
                
                // Enables png crunching, which is performed by the
                // Android Gradle plugin.
                isCrunchPngs = true

                // Enables resource shrinking, which is performed by the
                // Android Gradle plugin.
                isShrinkResources = true

                proguardFiles(
                    // Includes the default ProGuard rules files that are packaged with
                    // the Android Gradle plugin. To learn more, go to the section about
                    // R8 configuration files.
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    // Includes a local, custom Proguard rules file
                    "proguard-rules.pro"
                )
            }
            */
            getByName("debug") {
                // Disables code shrinking, obfuscation, and optimization for only
                // your project's debug build type. Make sure to use a build
                // variant with `isDebuggable=false`.
                isMinifyEnabled = false
                
                // Disables png crunching, which is performed by the
                // Android Gradle plugin.
                isCrunchPngs = false

                // Disables resource shrinking, which is performed by the
                // Android Gradle plugin.
                isShrinkResources = false

                proguardFiles(
                    // Includes the default ProGuard rules files that are packaged with
                    // the Android Gradle plugin. To learn more, go to the section about
                    // R8 configuration files.
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    // Includes a local, custom Proguard rules file
                    "proguard-rules.pro"
                )
            }
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
    
    lint { abortOnError = false }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.core:core-ktx:1.12.0")

    implementation("androidx.navigation:navigation-ui:2.7.7")
    implementation("androidx.navigation:navigation-fragment:2.7.7")
    implementation("com.github.androidbulb:CircleImageViewLibrary:1.0")
    implementation("com.blankj:utilcodex:1.31.1")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("org.apache.commons:commons-text:1.11.0")
    
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.testng:testng:6.9.6")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}