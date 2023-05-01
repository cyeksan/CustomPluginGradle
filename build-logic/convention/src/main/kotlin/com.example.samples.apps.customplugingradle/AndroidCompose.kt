package com.example.samples.apps.customplugingradle

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *>,
) {
    val libs: VersionCatalog = the<VersionCatalogsExtension>().named("libs")
    val bom = libs.findLibrary("androidx-compose-bom").get()

    commonExtension.apply {

        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion =
                libs.findVersion("androidxComposeCompiler").get().toString()        }

        dependencies {
            add("implementation", platform(bom))
            add("implementation", libs.findLibrary("androidx.lifecycle.runtime.ktx").get())
            add("implementation", libs.findBundle("androidx.compose.ui").get())
            add("androidTestImplementation", libs.findBundle("androidx.tests").get())
            add("debugImplementation", libs.findBundle("androidx.compose.ui.tests").get())
            add("androidTestImplementation", platform(bom))
        }
    }
}