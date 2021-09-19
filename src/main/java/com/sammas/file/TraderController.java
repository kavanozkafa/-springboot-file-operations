package com.sammas.file;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class TraderController {

	String fileName = "Trades";

	private Logger logger = LoggerFactory.getLogger(TraderController.class);

	@Autowired
	FileService  fileService;

	@Autowired
	private TraderRepository tradeRepository;


	@GetMapping("/downloadExcel")
	public ResponseEntity<Resource> getFile() {
		String excel = "tutorials.xlsx";
		InputStreamResource file = new InputStreamResource(fileService.loadExcel());

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName+excel)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
	}


	@GetMapping("/downloadCsv")
	public ResponseEntity<Resource> getCsvFile() {
		String csv = "tutorials.csv";
		InputStreamResource file = new InputStreamResource(fileService.loadCsv());

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName+csv)
				.contentType(MediaType.parseMediaType("application/csv"))
				.body(file);
	}


	@GetMapping("/trades")
	public ResponseEntity<Object> getAllTrades(){
		HashMap<String, Object> mTrade = new HashMap<String, Object>();

		try {			
			Iterable<Trader> trades = tradeRepository.findAll();			
			return new ResponseEntity<Object>(trades, HttpStatus.OK);

		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			mTrade.put("Response", "NOK");
			mTrade.put("error", ex);			
			return new ResponseEntity<Object>(mTrade,HttpStatus.BAD_REQUEST);
		}
	}




}
