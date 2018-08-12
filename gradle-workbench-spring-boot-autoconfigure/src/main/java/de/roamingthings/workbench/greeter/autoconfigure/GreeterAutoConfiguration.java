package de.roamingthings.workbench.greeter.autoconfigure;

import de.roamingthings.greeter.Greeter;
import de.roamingthings.optionalgreeter.OptionalGreeter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreeterAutoConfiguration {
    private static final String OPTIONAL_GREETER_CLASS = "de.roamingthings.optionalgreeter.OptionalGreeter";

    @Bean
    @ConditionalOnMissingBean
    public Greeter greeter() {
        return new Greeter();
    }

    @Configuration
    @ConditionalOnClass(name = OPTIONAL_GREETER_CLASS)
    static class OptionalGreeterConfiguration {
        @Bean
        @ConditionalOnMissingBean
        public OptionalGreeter optionalGreeter() {
            return new OptionalGreeter();
        }
    }
}
