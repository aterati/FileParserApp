package com.rv.code.SrpingWeb.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * This service reads the input file line by line, parses each line using the
 * given stringToken 
 * 
 * Or assumes file extension is the stringToken if no stringToken is provided.
 * 
 * 
 * @author Arvind Terati
 *
 */

@Service
public class FileReaderService {

	public List<List<String>> parserFile(String filePath, String stringToken) {

		if (!StringUtils.isEmpty(filePath)) {

			File file = new File(filePath);
			List<List<String>> mainList = new ArrayList<>();

			if (StringUtils.isEmpty(stringToken)) {
				String fileExt = filePath.substring(filePath.lastIndexOf(".")+1);
				//If the file extension is .t custom code to look for \t and not <t>
				stringToken = (fileExt.equalsIgnoreCase("t"))? ("\t"): ("<" +fileExt + ">");
			}

			try {
				@SuppressWarnings("resource")
				BufferedReader fileInReader = new BufferedReader(new FileReader(file));
				String tempStr;

				// Code to read the file line by line and parse using stringToken.
				while ((tempStr = fileInReader.readLine()) != null) {
					List<String> tempStrList = Arrays.asList(tempStr.split(stringToken));
					mainList.add(tempStrList);
				}

			} catch (FileNotFoundException ex) {
				System.out.println("File not found" + ex.getMessage());
				return null;
			} catch (IOException ex) {
				System.out.println("IO exception while parsing the file" + ex.getMessage());
				return null;
			}

			return mainList;

		} else {
			return null;
		}
	}

}
