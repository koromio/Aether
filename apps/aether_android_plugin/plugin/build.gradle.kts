plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

val pluginName = "aether"
val pluginPackageName = "org.kireibox.aether"

android {
    namespace = pluginPackageName
    compileSdk = 36

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        minSdk = 26

        buildConfigField(
            "String",
            "GODOT_PLUGIN_NAME",
            "\"$pluginName\""
        )

        manifestPlaceholders["godotPluginName"] = pluginName
        manifestPlaceholders["godotPluginPackageName"] = pluginPackageName

        ndk {
            abiFilters.add("arm64-v8a")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        compilerOptions {
            jvmTarget.set(
                org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17
            )
        }
    }
}

dependencies {
    implementation("org.godotengine:godot:4.7.2.stable")
}
