package HarController.HarDashboardProject;

import HarController.HarDashboardProject.HarFilesRelocator.CaseCounter;
import HarController.HarDashboardProject.HarFilesRelocator.HarRelocator;
import HarController.HarDashboardProject.Resources.ResourcePaths;

/**
 * Har Dashboard entry point
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String scenerioKey = "g";
    	CaseCounter.keyGen(scenerioKey);
    	// Lists the files into PROPERTIES file
        //HarRelocator.getFolderNames();
        // Moves the file
       // HarRelocator.HarRelocators();
    	//GetValuesFromHar.getValueFromHar();
    }
    
    
}
