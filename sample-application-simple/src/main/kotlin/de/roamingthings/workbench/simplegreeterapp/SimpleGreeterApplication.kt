package de.roamingthings.workbench.simplegreeterapp

import de.roamingthings.greeter.Greeter
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean


@SpringBootApplication
class SimpleGreeterApplication {

    private val log = LoggerFactory.getLogger(SimpleGreeterApplication::class.java)

    @Bean
    fun init(
            greeter: Greeter,
            applicationContext: ApplicationContext,
            applicationArguments: ApplicationArguments) = CommandLineRunner {

        val name = retrieveNameFrom(applicationArguments) ?: "Jon Doe"

        val greetingMessage = greeter.greet(name)

        log.info(greetingMessage)

        val optionalGreeterExists = applicationContext.containsBean("optionalGreeter")
        log.info("Optional greeter bean exists in context: {}", optionalGreeterExists)
    }

    private fun retrieveNameFrom(applicationArguments: ApplicationArguments): String? =
            if (applicationArguments.sourceArgs.isNotEmpty()) applicationArguments.sourceArgs[0] else null

}

fun main(args: Array<String>) {
    runApplication<SimpleGreeterApplication>(*args)
}
