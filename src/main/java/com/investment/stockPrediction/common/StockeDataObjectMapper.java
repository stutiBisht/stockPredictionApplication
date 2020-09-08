package com.investment.stockPrediction.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.investment.stockPrediction.model.DowJonesIndexData;

@Component
public class StockeDataObjectMapper {

	private final Logger logger = LogManager.getLogger(this.getClass());

	@Async
	public List<DowJonesIndexData> mapToDJIndex(MultipartFile file) {
		List<DowJonesIndexData> djIndexDataList = new ArrayList<DowJonesIndexData>();
		DowJonesIndexData djIndexData = null;
		logger.info("inside mapToDJIndex for StockeDataObjectMapper");

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
			reader.readLine();
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] fields = line.split("\\,");
				try {
					djIndexData = new DowJonesIndexData(fields);

					djIndexDataList.add(djIndexData);
				} catch (ParseException e) {
					logger.error("Error occured while parsing data from file to object" + e.getCause());
					e.printStackTrace();
				}

			}
			logger.info("djIndexDataList inside mapToDJIndex method-->" + djIndexDataList);
		} catch (IOException e) {
			logger.error("Error occured while reading file-->" + e.getCause());
			throw new RuntimeException(e);
		}
		return djIndexDataList;
	}

}
