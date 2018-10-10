package com.rv.code.SpringWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.rv.code.SrpingWeb.Service.FileReaderService;

/**
 * Rest service to parse the given file.
 * 
 * @author Arvind Terati
 *
 */
@RestController
@RequestMapping(value = "/parseFile")
@EnableAutoConfiguration
public class SpringFileController {

	FileReaderService fileReaderService;

	@Autowired
	public void setFileReaderService(FileReaderService fileReaderService) {
		this.fileReaderService = fileReaderService;
	}

	/**
	 * This service will parse the file at the given filePath using stringToken and
	 * return a list of string tokens.
	 * 
	 * If stringToken is not provided file extension will be used by default to
	 * parse the file.
	 * 
	 * 
	 * @param filePath
	 * @param stringTokenizer
	 * @return
	 */
	@RequestMapping(value = "/file", method = RequestMethod.POST)
	public ResponseEntity parseFile(@RequestParam("filePath") String filePath,
			@RequestParam(value="stringToken", required=false) String stringTokenizer) {

		List<List<String>> parsedList = fileReaderService.parserFile(filePath, stringTokenizer);

		if (parsedList != null && !parsedList.isEmpty()) {
			return new ResponseEntity<List<List<String>>>(parsedList, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Bad Request", HttpStatus.BAD_REQUEST);
		}

	}

}
