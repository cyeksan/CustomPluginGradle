plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.android.library)
    implementation(libs.kotlin.android)
}

gradlePlugin {
    plugins {
        register("androidLibrary") {
            id = "com.example.customplugingradle.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidLibraryCompose") {
            id = "com.example.customplugingradle.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
    }
}