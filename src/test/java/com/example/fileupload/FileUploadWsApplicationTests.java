package com.example.fileupload;


import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class FileUploadWsApplicationTests {
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Test
	void contextLoads() throws Exception {
	    MockMultipartFile jsonFile = new MockMultipartFile("file", "", "application/json", "{\"json\": \"someValue\"}".getBytes());
	    MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	    mockMvc.perform(MockMvcRequestBuilders.fileUpload("/uploadFile")
	            .file(jsonFile))
	          .andExpect(status().is(200));
	}

}
