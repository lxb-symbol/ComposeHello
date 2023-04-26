//enableFeaturePreview("VERSION_CATALOGS")
//enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android") {
                useModule("com.android.tools.build:gradle:8.0.0")
            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()

    }
    versionCatalogs {
        create("libs") {
            from(files("${rootDir.path}/dependencies-common.toml"))
        }
    }
}
rootProject.name = "ComposeHello"
include(":app")
include(":mylibrary")
include(":widget")

