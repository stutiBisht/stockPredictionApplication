package com.investment.stockPrediction;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.builder.SpringApplicationBuilder;

@RunWith(MockitoJUnitRunner.class)
class StockPredictionApplicationTests {

	@Mock
	SpringApplicationBuilder mockSpringApplicationBuilder; 
	@InjectMocks
	StockPredictionApplication stockPredictionApplication; 
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testMain() {
		StockPredictionApplication.main(new String[] {"abc","xyz"});
	}

}
