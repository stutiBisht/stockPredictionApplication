package com.investment.stockPrediction.util;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.investment.stockPrediction.model.DowJonesIndexData;

public class TestUtils {
	
static ObjectMapper objectMapper = new ObjectMapper();
	
	public  static <T> T jsonToObject(String json, Class<T> classof) throws JsonMappingException, JsonProcessingException {
		return objectMapper.readValue(json, classof);
		}


	public static DowJonesIndexData getdjIData() throws JsonMappingException, JsonProcessingException {
		DowJonesIndexData dowJonesIndexData = new DowJonesIndexData();
		String json= "{\"quarter\": 1,\"stock\": \"AA\",\"close_date\": \"2011-01-07T05:01:00.000+00:00\",\"open_price\": \"$15.82\", \"high\": \"$16.72\",\"low\": \"$15.78\",\"close_price\": \"$16.42\",\"volume\": \"239655616\",\"percent_change_price\": \"3.79267\",\"percent_change_volume_over_last_wk\": \"\",\"previous_weeks_volume\": \"\",\"next_weeks_open\": \"$16.71\", \"next_weeks_close\": \"$15.97\", \"percent_change_next_weeks_price\": \"-4.42849\", \"days_to_next_dividend\": \"26\",\"percent_return_next_dividend\": \"0.182704\"}";
		dowJonesIndexData = jsonToObject(json,DowJonesIndexData.class);
		return dowJonesIndexData;
		}
	
	public static List<DowJonesIndexData> getdjIDataList() throws JsonMappingException, JsonProcessingException {
		List<DowJonesIndexData> dowJonesIndexDataList = new ArrayList <DowJonesIndexData>();
		DowJonesIndexData dowJonesIndexData = new DowJonesIndexData();
		String json= "{\"quarter\": 1,\"stock\": \"AA\",\"close_date\": \"2011-01-07T05:01:00.000+00:00\",\"open_price\": \"$15.82\", \"high\": \"$16.72\",\"low\": \"$15.78\",\"close_price\": \"$16.42\",\"volume\": \"239655616\",\"percent_change_price\": \"3.79267\",\"percent_change_volume_over_last_wk\": \"\",\"previous_weeks_volume\": \"\",\"next_weeks_open\": \"$16.71\", \"next_weeks_close\": \"$15.97\", \"percent_change_next_weeks_price\": \"-4.42849\", \"days_to_next_dividend\": \"26\",\"percent_return_next_dividend\": \"0.182704\"}";
		dowJonesIndexData = jsonToObject(json,DowJonesIndexData.class);
		dowJonesIndexDataList.add(dowJonesIndexData);
		dowJonesIndexDataList.add(dowJonesIndexData);
		return dowJonesIndexDataList;
		}

}
