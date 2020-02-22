plugins {
    `java-library`
}

// Define all transitive (mandatory) dependency for consumer projects
dependencies {
    api(project(":gradle-workbench-spring-boot-autoconfigure"))
    api(project(":greet-library"))
}
