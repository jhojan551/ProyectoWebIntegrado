package avanceWI;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import avanceWI.controller.AvanceController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
class AvanceControllerTest {

	@Autowired
	private AvanceController avanceController;

	private MockMvc mockMvc;

	@Test
	void testGetAvance() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(avanceController).build();

		mockMvc.perform(get("/api/avance"))
				.andExpect(status().isOk())
				.andExpect(content().string("¡Proyecto en progreso!"));
	}
}