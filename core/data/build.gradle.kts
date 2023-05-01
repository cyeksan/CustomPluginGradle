plugins {
    id("com.example.customplugingradle.android.library")
    id("kotlinx-serialization")
}

android {
    namespace = "com.example.customplugingradle.core.data"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.okhttp.logging)
    testImplementation(libs.junit4)
}