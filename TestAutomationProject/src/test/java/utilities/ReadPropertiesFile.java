package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileReader fr = new FileReader(System.getProperty("user.dir")+"C:/Users/hp/eclipse-workspace/SeleniumAutomationFramework/TestAutomationProject/src/test/resources/Configfiles/config.properties");
		Properties P = new Properties();
		P .load(fr);
		
		System.out.println(P.getProperty("browser"));
	}

}
