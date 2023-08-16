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
//        mavenLocal()
//        maven("https://maven.aliyun.com/repository/public")
        mavenLocal()
        maven ("https://maven.aliyun.com/repository/public")
        maven ("https://maven.aliyun.com/repository/jcenter")
        maven ("https://maven.aliyun.com/repository/spring")
        maven ("https://maven.aliyun.com/repository/spring-plugin")
        maven ("https://maven.aliyun.com/repository/gradle-plugin")
        maven("https://maven.aliyun.com/repository/google")
        maven("https://maven.aliyun.com/repository/grails-core")
        maven ("https://maven.aliyun.com/repository/apache-snapshots")
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

    tasks {
        test {
            useJUnitPlatform()
        }

        jar {
            manifest {
                attributes["Main-Class"] = "com.ori.MainKt"
            }
            duplicatesStrategy = DuplicatesStrategy.EXCLUDE
            from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
        }
    }


    dependencies {
        testImplementation(kotlin("test"))
        // https://mvnrepository.com/artifact/org.jetbrains.kotlinx/kotlinx-coroutines-core
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    }
}