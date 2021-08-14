plugins {
    kotlin("multiplatform") version "1.5.21"
    id("org.jetbrains.compose") version "1.0.0-alpha1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

kotlin {
    /* Targets configuration omitted. 
    *  To find out how to configure the targets, please follow the link:
    *  https://kotlinlang.org/docs/reference/building-mpp-with-gradle.html#setting-up-targets */

    sourceSets {
        js(IR) {
            browser()
            binaries.executable()
        }
        sourceSets {
            val jsMain by getting {
                dependencies {
                    implementation(npm("highlight.js", "10.7.2"))
                    implementation(compose.web.core)
                    implementation(compose.runtime)
                }
            }
        }
    }
}