import com.android.build.gradle.BaseExtension
//import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

plugins {
    id("build-logic.root-project")
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
}

fun Project.configureBaseExtension() {
    extensions.findByType(BaseExtension::class)?.run {
        compileSdkVersion(Versions.compileSdkVersion)
        buildToolsVersion = Versions.buildToolsVersion

        defaultConfig {
            minSdk = Versions.minSdk
            targetSdk = Versions.targetSdk
            versionCode = Versions.versionCode
            versionName = Versions.versionName
        }
        
        compileOptions {
            sourceCompatibility = Versions.javaVersion
            targetCompatibility = Versions.javaVersion
        }
    }
}

/*
fun Project.configureKotlinExtension() {
    extensions.findByType(KotlinAndroidProjectExtension::class)?.run {
        jvmToolchain(Versions.jvmToolchainVersion)
    }
}
*/
subprojects {
    plugins.withId("com.android.application") {
        configureBaseExtension()
    }
    plugins.withId("com.android.library") {
        configureBaseExtension()
    }
    plugins.withId("org.jetbrains.kotlin.android") {
        configureBaseExtension()
        //configureKotlinExtension()
    }
}

allprojects {
    tasks.withType<JavaCompile> {
        val compilerArgs = options.compilerArgs
        compilerArgs.add("-Xlint:unchecked")
        compilerArgs.add("-Xlint:deprecation")
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.freeCompilerArgs = listOf(
            "-opt-in=kotlin.RequiresOptIn"
        )
    }
}

tasks.register<Delete>("clean") { delete(rootProject.buildDir) }
