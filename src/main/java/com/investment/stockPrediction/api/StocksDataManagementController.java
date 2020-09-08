package com.investment.stockPrediction.api;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.investment.stockPrediction.common.ApplicationValidationException;
import com.investment.stockPrediction.model.DowJonesIndexData;
import com.investment.stockPrediction.service.StocksDataManagementService;

@Controller
public class StocksDataManagementController {

	private final Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	StocksDataManagementService stocksDataManagementService;

	@RequestMapping("/")
	public String defaultPage(ModelMap model) throws ApplicationValidationException {
		logger.info("Inside defaultPage method of StocksDataManagementController");
		return "uploadData";
	}

	@GetMapping("/getUploadData")
	public String fileUploadLanding(ModelMap model) throws ApplicationValidationException {
		logger.info("Inside FileUploadLanding method of StocksDataManagementController");
		return "uploadData";
	}

	@PostMapping("/uploadData")
	public String uploadData(@RequestParam("file") MultipartFile file, ModelMap model)
			throws ApplicationValidationException, MethodArgumentNotValidException {
		logger.info("Inside uploadData method of StocksDataManagementController");

		if (file.isEmpty()) {
			logger.error("File is empty");
			model.put("error", "Please select a file to upload");
			return "uploadData";
		} else {

			String fileName = file.getOriginalFilename();
			logger.info("FileName inside uploadData-->" + fileName);
			String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
			logger.info("FileExtension inside uploadData-->" + ext);

			if (!"txt".equalsIgnoreCase(ext)) {
				logger.error("FileExtension is invalid");
				model.put("error", "Please upload .txt file only");
				return "uploadData";
			} else {
				String message = stocksDataManagementService.uploadFileData(file);
				logger.info("uploadData reurned with message as" + message);
				model.put("message", message);
				return "uploadStatus";

			}
		}

	}

	@PostMapping(path = "/addStockRecord", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> addStockRecord(@Valid @RequestBody DowJonesIndexData djIndexData)
			throws ApplicationValidationException {
		logger.info("Inside addStockRecord method of StocksDataManagementController");
		logger.info("calling addStockRecord method of stocksDataManagementService for requestBody-->" + djIndexData);

		String message = stocksDataManagementService.addNewStockRecord(djIndexData);
		logger.info("addStockRecord reurned with message as" + message);

		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@GetMapping(path = "/getStockRecords/{stockName}", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<DowJonesIndexData>> getStockRecords(@PathVariable String stockName)
			throws ApplicationValidationException {
		logger.info("Inside getStockRecords method of StocksDataManagementController");
		logger.info("calling getStockRecords method of stocksDataManagementService for stockName-->" + stockName);
		List<DowJonesIndexData> dowJonesIndexDataList = stocksDataManagementService.getStockRecords(stockName);

		return new ResponseEntity<List<DowJonesIndexData>>(dowJonesIndexDataList, HttpStatus.OK);
	}
}
