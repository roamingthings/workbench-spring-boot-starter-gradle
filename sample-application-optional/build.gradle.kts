import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.2.4.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    kotlin("jvm") version "1.3.61"
    kotlin("plugin.spring") version "1.3.61"
    id("idea")
}

repositories {
    mavenLocal()
    mavenCentral()
}

java.sourceCompatibility = JavaVersion.VERSION_1_8
java.targetCompatibility = JavaVersion.VERSION_1_8

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // Only use the starter which does not include the optional library
    // implementation("de.roamingthings.workbench:gradle-workbench-spring-boot-starter:1.0.0-SNAPSHOT")
    implementation("de.roamingthings.workbench:gradle-workbench-spring-boot-starter-kt:1.0.0-SNAPSHOT")
    // Use the optional library
    implementation("de.roamingthings.workbench:greet-opt-library:1.0.0-SNAPSHOT")
}
