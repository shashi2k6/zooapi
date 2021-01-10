package com.zoo.api.zooapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ZooapiApplicationTests {

	@Autowired
	private ZooService zooService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	/**
	 * Add the animal to the zoo.
	 * @throws Exception
	 */

	@Test
	@Order(1)
	void test_addAnimal() throws Exception {
		Animal animal = new Animal("Tiger","Walking","unhappy");
		Zoo zoo = new Zoo();
		zoo.setAnimal(animal);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/zoo")
				.content(objectMapper.writeValueAsString(zoo))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("$.id").exists());
	}

	/**
	 * Test to get all the animals
	 * @throws Exception
	 */
	@Test
	@Order(2)
	void test_getAllAnimals() throws Exception {
		Animal animal = new Animal("Tiger","Walking","unhappy");
		Zoo zoo = new Zoo();
		zoo.setAnimal(animal);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/zoo")).andExpect(status().isOk())
				.andExpect(jsonPath("$.*", hasSize(1)));
	}
}
