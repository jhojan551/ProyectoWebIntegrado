package avanceWI.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class AvanceControllerTest {

    @Autowired
    private AvanceController avanceController;

    private MockMvc mockMvc;

    @Test
    void testGetAvance() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(avanceController).build();

        String response = mockMvc.perform(get("/api/avance"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertThat(response).isEqualTo("¡Proyecto en progreso!");
    }
}
