plugins {
    kotlin("jvm") version "1.9.0"
    application
    java
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks {
    compileKotlin {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }
}

allprojects {

    group = "com.ori"
    version = "1.0-SNAPSHOT"
    repositories {
        maven("https://maven.aliyun.com/repository/public")
    }

}

subprojects {

    apply {
        plugin("java")
        plugin("kotlin")
        plugin("application")
    }

    application {
        mainClass.set("com.ori.MainKt")
    }

    tasks.test {
        useJUnitPlatform()
    }

    dependencies {
        testImplementation(kotlin("test"))
        // https://mvnrepository.com/artifact/org.jetbrains.kotlinx/kotlinx-coroutines-core
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    }
}