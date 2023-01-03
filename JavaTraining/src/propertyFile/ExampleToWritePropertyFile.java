package propertyFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ExampleToWritePropertyFile {

	public static void main(String[] args) throws IOException {
		/*
		 * first get file location -
		 * 	Absolute path: F:\Online Class\Training Syllabus-20210816T050832Z-001\Training Syllabus\CoreJavaSessions\JavaTraining\Property\DummyFile.properties
		 *  Relative path: .\Property\DummyFile.properties
		 */
		//Create an instance of FileInputStream class a by passing file location to its constructor
		FileInputStream fis=new FileInputStream(".\\Property\\DummyFile.properties");
		//Create an instance of Properties class
		Properties prop=new Properties();
		//using Properties class instance ref call load() and pass FileInputStream class instance as parameter
		prop.load(fis);
		//to get a value from property file call getProperty(key) by using specific key
		String url=prop.getProperty("applicationUrl");
		System.out.println("App URL: "+url);
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		System.out.println(prop.getProperty("mobile"));
		//added new entry in property file
		prop.setProperty("address", "Deccan Pune");
		//to save file 
		FileOutputStream fos=new FileOutputStream(".\\Property\\DummyFile.properties");
		prop.store(fos, "Added new address for emp");
		//flush all the content into the file and close the connection
		fos.flush();
		fos.close();
		System.out.println("Updated");
	}

}
