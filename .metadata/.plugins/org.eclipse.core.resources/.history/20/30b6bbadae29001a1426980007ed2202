package HarController.HarDashboardProject.HarValuesExtractor;

import java.io.File;
import java.util.List;

import edu.umass.cs.benchlab.har.HarEntries;
import edu.umass.cs.benchlab.har.HarHeader;
import edu.umass.cs.benchlab.har.HarHeaders;
import edu.umass.cs.benchlab.har.HarLog;
import edu.umass.cs.benchlab.har.tools.HarFileReader;


public class GetValuesFromHar {

	public static void getValueFromHar() {


		try {
//			har = harReader.readFromFile(new File("E:\\HAR_Project\\HarOperationExecution\\Source\\g\\TXT_2019_12_27_HarExecutor_harResourecePath.har"));
			File f = new File("E:\\HAR_Project\\HarOperationExecution\\Source\\g\\TXT_2019_12_27_HarExecutor_harResourecePath.har");
		    HarFileReader r = new HarFileReader();
		    HarLog log = r.readHarFile(f);
		    HarEntries entries = log.getEntries();
		    HarHeaders s =  entries.getEntries().get(1).getResponse().getHeaders();
			List<HarHeader> ss = s.getHeaders();
//			for (HarHeader harHeader : ss) {
//				System.out.println(harHeader.getValue());
//			}
			System.out.println(ss.get(5).getName() +"="+ss.get(5).getValue());
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
