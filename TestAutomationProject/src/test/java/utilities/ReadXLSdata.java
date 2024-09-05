package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLSdata {

	@DataProvider (name = "Devlogindata")
	public static String[][] main(Method m) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		String excelsheetname = m.getName();
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Testdata\\testdata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelsheetname);
		
		int totalrows = sheetName.getLastRowNum();
		Row rowcells = sheetName.getRow(0);
		int totalcols = rowcells.getLastCellNum();
		
		DataFormatter format = new DataFormatter();
		
		String testdata[][]= new String [totalrows][totalcols];
		
		for (int i =1; i<=totalrows;i++) {
			for(int j=0; j<totalcols;j++) {
				testdata[i-1][j]= format.formatCellValue(sheetName.getRow(i).getCell(j));
			}
		}	 
        return testdata;
	}

}
