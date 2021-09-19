package com.sammas.file;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FileService {

	@Autowired
	TraderRepository repository;

	public ByteArrayInputStream loadCsv() {
		List<Trader> tutorials = (List<Trader>) repository.findAll();

		ByteArrayInputStream in = FileHelper.tutorialsToCSV(tutorials);
		return in;
	}

	public ByteArrayInputStream loadExcel() {
		List<Trader> tutorials = (List<Trader>) repository.findAll();

		ByteArrayInputStream in = FileHelper.tutorialsToExcel(tutorials);
		return in;
	}
}
