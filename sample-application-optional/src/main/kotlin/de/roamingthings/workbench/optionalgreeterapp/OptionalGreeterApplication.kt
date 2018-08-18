package de.roamingthings.workbench.optionalgreeterapp

import de.roamingthings.greeter.Greeter
import de.roamingthings.optionalgreeter.OptionalGreeter
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean


@SpringBootApplication
class OptionalGreeterApplication {

    private val log = LoggerFactory.getLogger(OptionalGreeterApplication::class.java)

    @Bean
    fun init(
            greeter: Greeter,
            optionalGreeter: OptionalGreeter,
            applicationContext: ApplicationContext,
            applicationArguments: ApplicationArguments) = CommandLineRunner {

        val name = retrieveNameFrom(applicationArguments) ?: "Jon Doe"

        val greetingMessage = greeter.greet(name)
        val optionalGreeterMessage = optionalGreeter.wishNiceDay(name)

        log.info(greetingMessage)
        log.info(optionalGreeterMessage)
    }

    private fun retrieveNameFrom(applicationArguments: ApplicationArguments): String? =
            if (applicationArguments.sourceArgs.isNotEmpty()) applicationArguments.sourceArgs[0] else null

}

fun main(args: Array<String>) {
    runApplication<OptionalGreeterApplication>(*args)
}
