package HarController.HarDashboardProject.HarFilesRelocator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import HarController.HarDashboardProject.Resources.ResourcePaths;

/*
 * Get all file names in a property file using [foldername=filepath] format
 * 
 * */

public class HarRelocator {

	public static Map <String, String> hm = new HashMap<String, String>();
	public static Properties properties = new Properties();
	public static File filefolderMapper = new File(ResourcePaths.folder_file_mapperFilelocation);

	// Relocates from source to target
	public static void HarRelocators() {

		String srcDir = ResourcePaths.srcDir;
		String destDir = ResourcePaths.destDir;
		File srcFile = new File(srcDir);
		File destFile = new File(destDir);

		// Relocation of Har files
		try {
			FileUtils.copyDirectoryToDirectory(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// lists the folder names into properties file
	public static void getFolderNames() {

		File[] directoryNames = getListOfDirectories(ResourcePaths.srcDir);
		File[] filesInsideDirectory;

		for (File file : directoryNames) {
			// Get the folder names
			String prepareKey = file.getName();
			// Get the files inside the folder
			filesInsideDirectory = getListOfFiles(ResourcePaths.srcDir+"\\"+prepareKey);

			for (int i = 0; i < filesInsideDirectory.length; i++) {
				String mapperkeyGeneration = prepareKey+"_"+(i+1);
				prepareFolderFileMaqpper(mapperkeyGeneration, filesInsideDirectory[i].getAbsolutePath().toString());
				listElementsToPropertiesFile(mapperkeyGeneration, filesInsideDirectory[i].getAbsolutePath().toString().replace("\\", "/"));
			}		

		}

		for (Map.Entry<String,String> entry : hm.entrySet())  
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
	}

	// Returns the list of DIRECTORIES
	public static File[] getListOfDirectories(String ResourcePath) {
		File[] directoryNames = new File(ResourcePath).listFiles(File::isDirectory);
		return directoryNames;
	}

	// Returns the list of Files
	public static File[] getListOfFiles(String ResourcePath) {
		File[] directoryNames = new File(ResourcePath).listFiles(File::isFile);
		return directoryNames;
	}

	public static void prepareFolderFileMaqpper(String key, String value) {
		hm.put(key, value);
	}
	
	public static void listElementsToPropertiesFile(String key, String value) {
		FileOutputStream fileOutputStream;
		try {
			properties.setProperty(key, value);
			fileOutputStream = new FileOutputStream(filefolderMapper);
			properties.store(fileOutputStream, "Columns from the excel sheet");
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
