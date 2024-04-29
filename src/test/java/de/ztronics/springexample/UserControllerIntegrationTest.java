package de.ztronics.springexample;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.ztronics.springexample.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest // Startet die gesamte Anwendung für den Test
@AutoConfigureMockMvc // konfiguriert MockMvc
class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc; // Mocked HTTP Requests

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser
    void testCreateUserAndVoucher() throws Exception {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user))
                        .with(SecurityMockMvcRequestPostProcessors.csrf())) // Weil Security eingeschaltet
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"))
                .andExpect(status().isOk());
    }
}
