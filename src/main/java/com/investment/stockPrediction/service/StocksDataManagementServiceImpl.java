package com.investment.stockPrediction.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.investment.stockPrediction.common.ApplicationValidationException;
import com.investment.stockPrediction.common.StockeDataObjectMapper;
import com.investment.stockPrediction.model.DowJonesIndexCK;
import com.investment.stockPrediction.model.DowJonesIndexData;
import com.investment.stockPrediction.repository.DowJonesIndexDataRepository;

@Component
public class StocksDataManagementServiceImpl implements StocksDataManagementService {

	private final Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	private DowJonesIndexDataRepository jdiDataRepo;

	@Autowired
	private StockeDataObjectMapper objectMapper;

	@Override
	@Transactional
	public String uploadFileData(MultipartFile file) throws ApplicationValidationException {
		logger.info("inside uploadFileData for StocksDataManagementServiceImpl");

		List<DowJonesIndexData> dowJonesIndexDataList = objectMapper.mapToDJIndex(file);
		if (dowJonesIndexDataList.isEmpty()) {
			logger.error("No record found in File");
			return "No record found in File";
		} else {
			jdiDataRepo.saveAll(dowJonesIndexDataList);
			jdiDataRepo.flush();
			logger.info("Bulk data inserted into db successfully");
			return "File uploaded successfully";
		}
	}

	@Override
	@Transactional
	public String addNewStockRecord(DowJonesIndexData djIndexData) throws ApplicationValidationException {
		logger.info("inside uploadFileData for StocksDataManagementServiceImpl");

		if (jdiDataRepo.existsById(new DowJonesIndexCK(djIndexData.getStock(), djIndexData.getClose_date()))) {
			logger.error("Data already present for Stock-->" + djIndexData.getStock() + " and Date-->"
					+ djIndexData.getClose_date());
			throw new EntityNotFoundException("Data already present for Stock-->" + djIndexData.getStock()
					+ " and Date-->" + djIndexData.getClose_date());
		} else {
			jdiDataRepo.saveAndFlush(djIndexData);
			logger.info("Data inserted into db successfully");
			return "added succesfully";
		}

	}

	@Override
	public List<DowJonesIndexData> getStockRecords(String stock) throws ApplicationValidationException {
		logger.info("inside getStockRecords for StocksDataManagementServiceImpl");

		List<DowJonesIndexData> dowJonesIndexDataList = jdiDataRepo.findByStock(stock);
		logger.info("dowJonesIndexDataList returned from DB is -->" + dowJonesIndexDataList);

		if (dowJonesIndexDataList.isEmpty()) {
			logger.error("No record found for stock-->" + stock);
			throw new EntityNotFoundException("No record found for stock-->" + stock);
		}
		return dowJonesIndexDataList;
	}

}
