package HarController.HarDashboardProject.HarFilesRelocator;

import java.io.FileInputStream;
import java.util.Properties;

import HarController.HarDashboardProject.Resources.ResourcePaths;

public class CaseCounter {
	
	public static String fl = ResourcePaths.folder_file_mapperFilelocation;

	// Returns HAR file path according with scenerio provided by user
	public static void keyGen(String scenerioKey) {
		String counterpath = ResourcePaths.srcDir+"\\"+scenerioKey;
		int noOfFiles = HarRelocator.getListOfFiles(counterpath).length;
		for (int i = 1; i <= noOfFiles; i++) {
			String genkey = scenerioKey+"_"+i;
			try {
				//System.out.println(harPath(genkey));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Read The property file
	public static String harPath(String key) throws Exception {
		FileInputStream file = new FileInputStream(fl);
		Properties rpop = new Properties();
		rpop.load(file);
		String data = rpop.getProperty(key);
		return data;
	}
}
