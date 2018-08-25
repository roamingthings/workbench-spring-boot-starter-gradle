package de.roamingthings.workbench.greeter.autoconfigure

import de.roamingthings.optionalgreeter.OptionalGreeter
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = arrayOf(GreetingsEndpointIT.TestApplication::class))
internal class GreetingsEndpointIT {

    @Autowired(required = false)
    private val optionalGreeter: OptionalGreeter? = null

    @Test
    @DisplayName("Bean Context should contain OptionalGreeter")
    @Throws(Exception::class)
    fun shouldContainOptionalGreeter() {
        // given

        // when

        // then
        assertThat(optionalGreeter).isNotNull
    }

    @SpringBootApplication
    class TestApplication
}
