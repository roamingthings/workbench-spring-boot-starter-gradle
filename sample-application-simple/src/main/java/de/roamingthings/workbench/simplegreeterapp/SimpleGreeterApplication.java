package de.roamingthings.workbench.simplegreeterapp;

import de.roamingthings.greeter.Greeter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SimpleGreeterApplication implements CommandLineRunner {
    private static Logger log = LoggerFactory
            .getLogger(SimpleGreeterApplication.class);

    private final Greeter greeter;

    private final ApplicationContext applicationContext;

    @Autowired
    public SimpleGreeterApplication(Greeter greeter, ApplicationContext applicationContext) {
        this.greeter = greeter;
        this.applicationContext = applicationContext;
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleGreeterApplication.class, args);
    }

    @Override
    public void run(String... args) {
        String name = retrieveNameFrom(args).orElse("Jon Doe");

        String greetingMessage = greeter.greet(name);

        log.info(greetingMessage);

        boolean optionalGreeterExists = applicationContext.containsBean("optionalGreeter");
        log.info("Optional greeter bean exists in context: {}", optionalGreeterExists);
    }

    private Optional<String> retrieveNameFrom(String[] args) {
        String name = null;
        if (args.length > 0) {
            name = args[0];
        }
        return Optional.ofNullable(name);
    }
}
