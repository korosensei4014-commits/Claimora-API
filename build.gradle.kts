plugins {
    `java-library`
    `maven-publish`
}

group = "com.korosensei.claimora"
// Matches the Claimora version this API belongs to. Bump it to publish a new release.
version = "0.8.6"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    // Provided by the server; never part of this artifact.
    compileOnly("io.papermc.paper:paper-api:26.3.build.+")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(25))
    withSourcesJar()
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

publishing {
    publications {
        create<MavenPublication>("api") {
            artifactId = "claimora-api"
            from(components["java"])
            pom {
                name.set("Claimora API")
                description.set("Public API of the Claimora land-claiming plugin for Paper.")
                url.set("https://github.com/korosensei4014-commits/Claimora-API")
            }
        }
    }
    repositories {
        // CI copies this folder to the `repo` branch, which is served as a Maven repository.
        maven {
            name = "local"
            url = uri(layout.buildDirectory.dir("repo"))
        }
    }
}
