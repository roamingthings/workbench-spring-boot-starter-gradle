plugins {
    `java-library`
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.kotlin.plugin.spring")
}

// Only reference dependencies as compileOnly since the starter will be responsible for defining all required
// transitive dependencies
val springBootVersion: String by extra
dependencies {
    // This is the mandatory library supported by this Starter and handled by the auto configuration.
    // It will be a transitive dependency and will be automatically included by the consumer.
    // However the starter will define this as a required transitive dependency
    api(project(":greet-library"))

    // This is the optional library supported by this Starter and handled by the auto configuration.
    // It will not be a transitive dependency but has to be declared as a dependency by the consumer
    compileOnly(project(":greet-opt-library"))

    // Here the dependencies will be available as transitive dependencies to your final application.
    // However you may want to make these dependencies implementation and add them to the starter artifact.
    // If you are targeting a Kotlin-Only application you may even want to not have these as transient dependency.
    api("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    api("org.jetbrains.kotlin:kotlin-reflect")

    compileOnly("org.springframework.boot:spring-boot-starter:$springBootVersion")
    annotationProcessor ("org.springframework.boot:spring-boot-autoconfigure-processor:$springBootVersion")
    annotationProcessor ("org.springframework.boot:spring-boot-configuration-processor:$springBootVersion")
}
