# FileParserApp
This is a Rest Service developed using Spring boot to read and parse a file.

## The service accepts two parameters, filePath and stringToken. 

- Using the filepath the service reads the file line by line
- Parses each line using the string token into a list of tokens
- If string token is not given, service uses file extension as string tokenizer


## Technical Details:

	This application is a Spring based REST service developed and build using Spring Boot and Maven.
	
## To run the application:

	In order to run the application, clone the project and run the SpringWebApplication.java class. 
	This is will run the spring boot application and deploy it on the embedded tomcat server on port 8090. 
	
	Running this class will scan the applicatoin using component scan configuration and will expose the 
	REST endpoint.

## Test Results:

https://github.com/aterati/FileParserApp/issues/1#issue-368459280
