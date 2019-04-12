plugins {
    id("org.springframework.boot") version "2.1.3.RELEASE"
    id("org.jetbrains.kotlin.jvm") version "1.3.21" // == kotlin("jvm") version "1.3.21"
    id("org.jetbrains.kotlin.plugin.spring") version "1.3.21" // kotlin("pluugin.spring") version "1.3.21"
    id("org.jetbrains.kotlin.kapt") version "1.3.21" // == kotlin("kapt") version "1.3.21"
}

apply {
    kotlin
    plugin("io.spring.dependency-management")
    plugin("kotlin-kapt")
}


group = "io.honeymon.study"
version = "0.0.1-SNAPSHOT"

repositories {
    maven {
        setUrl("http://nexus.woowa.in/content/groups/public")
    }
    mavenCentral()
}

dependencies {
    compile("org.springframework.boot:spring-boot-starter-web")

    compile("org.jetbrains.kotlin:kotlin-reflect")
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin")
    // 자동완성기능 다시 봐야겠다.


    kapt("org.springframework.boot:spring-boot-configuration-processor")
}

tasks {
    compileKotlin {
        kotlinOptions {
            freeCompilerArgs = mutableListOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
        dependsOn(processResources)
    }
    compileTestKotlin {
        kotlinOptions {
            freeCompilerArgs = mutableListOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }
}