package de.roamingthings.workbench.optionalgreeterapp;

import de.roamingthings.greeter.Greeter;
import de.roamingthings.optionalgreeter.OptionalGreeter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class OptionalGreeterApplication implements CommandLineRunner {
    private static Logger log = LoggerFactory
            .getLogger(OptionalGreeterApplication.class);

    private final Greeter greeter;
    private final OptionalGreeter optionalGreeter;

    @Autowired
    public OptionalGreeterApplication(Greeter greeter, OptionalGreeter optionalGreeter) {
        this.greeter = greeter;
        this.optionalGreeter = optionalGreeter;
    }

    public static void main(String[] args) {
        SpringApplication.run(OptionalGreeterApplication.class, args);
    }

    @Override
    public void run(String... args) {
        String name = retrieveNameFrom(args).orElse("Jon Doe");

        String greetingMessage = greeter.greet(name);
        String optionalGreeterMessage = optionalGreeter.wishNiceDay(name);

        log.info(greetingMessage);
        log.info(optionalGreeterMessage);
    }

    private Optional<String> retrieveNameFrom(String[] args) {
        String name = null;
        if (args.length > 0) {
            name = args[0];
        }
        return Optional.ofNullable(name);
    }
}
