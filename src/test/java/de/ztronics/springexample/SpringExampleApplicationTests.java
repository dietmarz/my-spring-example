package de.ztronics.springexample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SpringExampleApplicationTests {

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private ApplicationContext context;

        @Test
    void contextLoads() {
        assertNotNull(context);
    }

    @Test
    void testImportantBeanLoaded() {
        assertTrue(context.containsBean("userRepository"));
    }

    @Test
    void testPropertySet() {
        assertEquals("my-spring-example", applicationName);
    }
}
