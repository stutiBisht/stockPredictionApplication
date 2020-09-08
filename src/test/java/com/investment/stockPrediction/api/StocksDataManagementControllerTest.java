package com.investment.stockPrediction.api;

import java.io.InputStream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.investment.stockPrediction.service.StocksDataManagementService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = StocksDataManagementController.class)
public class StocksDataManagementControllerTest {

	@InjectMocks
	StocksDataManagementController stocksDataManagementController = new StocksDataManagementController();

	@MockBean
	private StocksDataManagementService stocksDataManagementService;

	private InputStream inputStream;

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(stocksDataManagementController).build();
		MockitoAnnotations.openMocks(this);
		inputStream = stocksDataManagementController.getClass().getClassLoader().getResourceAsStream("test.txt");
	}

	@Test
	public void testUploadFile() throws Exception {
		MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "test.txt", "multipart/form-data",
				inputStream);

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.multipart("/uploadData").file(mockMultipartFile)
						.contentType(MediaType.TEXT_PLAIN))
				.andExpect(MockMvcResultMatchers.status().is(302)).andReturn();

		Assert.assertEquals(302, result.getResponse().getStatus());
		Assert.assertNotNull(result.getResponse().getContentAsString());
		Assert.assertEquals("http://localhost/login", result.getResponse().getRedirectedUrl());

	}

	@Test
	public void testAddStockRecord() throws Exception {
		String json = "{\"quarter\": 1,\"stock\": \"AA\",\"close_date\": \"2011-01-07T05:01:00.000+00:00\",\"open_price\": \"$15.82\", \"high\": \"$16.72\",\"low\": \"$15.78\",\"close_price\": \"$16.42\",\"volume\": \"239655616\",\"percent_change_price\": \"3.79267\",\"percent_change_volume_over_last_wk\": \"\",\"previous_weeks_volume\": \"\",\"next_weeks_open\": \"$16.71\", \"next_weeks_close\": \"$15.97\", \"percent_change_next_weeks_price\": \"-4.42849\", \"days_to_next_dividend\": \"26\",\"percent_return_next_dividend\": \"0.182704\"}";

		mockMvc.perform(
				MockMvcRequestBuilders.post("/addStockRecord").contentType(MediaType.APPLICATION_JSON).content(json))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
				.andReturn();
	}

	@Test
	public void testGetStockRecord() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/getStockRecords/{stockName}", "AA")
				.contentType(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
	}

}
