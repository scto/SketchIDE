plugins {
  id("com.android.application")
  id("kotlin-android")
  id("androidx.navigation.safeargs.kotlin")
}

android {
  namespace = "com.rajendra.sketchide"

  defaultConfig {
    applicationId = "com.rajendra.sketchide"

    vectorDrawables.useSupportLibrary = true
    multiDexEnabled = true
    
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles("proguard-rules.pro")
    }
    debug {
      isMinifyEnabled = false
      proguardFiles("proguard-rules.pro")
    }
  }

  packaging {
        resources {
            excludes.addAll(
                listOf(
                    "META-INF/INDEX.LIST",
                    "META-INF/eclipse.inf",
                    "META-INF/CHANGES",
                    "META-INF/README.md",
                    "META-INF/DEPENDENCIES",
                    "about_files/LICENSE-2.0.txt",
                    "META-INF/AL2.0",
                    "META-INF/LGPL2.1",
                    "plugin.xml",
                    "plugin.properties",
                    "about.mappings",
                    "about.properties",
                    "about.ini",
                    "src/*",
                )
            )

            pickFirsts.addAll(
                listOf(
                    "OSGI-INF/l10n/plugin.properties"
                )
            )
        }
        jniLibs { useLegacyPackaging = true }
    }

  lint { abortOnError = false }
  
  buildFeatures {
    viewBinding = true
    buildConfig = true
  }

  flavorDimensions += "environment"

    productFlavors {
        create("dev") {
            dimension = "environment"
            isDefault = true
        }
        create("prod") {
            dimension = "environment"
        }
    }

    splits {
        abi {
            isEnable = true
            isUniversalApk = true
        }
    }
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
