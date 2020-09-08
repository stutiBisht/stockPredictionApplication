package com.investment.stockPrediction.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.investment.stockPrediction.common.ApplicationValidationException;
import com.investment.stockPrediction.model.DowJonesIndexData;

@Component
public interface StocksDataManagementService {

	String uploadFileData(MultipartFile file) throws ApplicationValidationException;

	String addNewStockRecord(DowJonesIndexData jdiData) throws ApplicationValidationException;

	List<DowJonesIndexData> getStockRecords(String stockName) throws ApplicationValidationException;


}
