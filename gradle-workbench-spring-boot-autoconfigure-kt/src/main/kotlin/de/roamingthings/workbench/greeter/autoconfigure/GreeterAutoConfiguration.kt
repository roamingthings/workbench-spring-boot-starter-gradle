package de.roamingthings.workbench.greeter.autoconfigure

import de.roamingthings.greeter.Greeter
import de.roamingthings.optionalgreeter.OptionalGreeter
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GreeterAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    fun greeter(): Greeter = Greeter()

    @Configuration
    @ConditionalOnClass(name = [OPTIONAL_GREETER_CLASS])
    internal class OptionalGreeterConfiguration {

        @Bean
        @ConditionalOnMissingBean
        fun optionalGreeter(): OptionalGreeter = OptionalGreeter()

    }

    companion object {
        private const val OPTIONAL_GREETER_CLASS = "de.roamingthings.optionalgreeter.OptionalGreeter"
    }
}
