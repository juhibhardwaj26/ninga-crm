package fileUtility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class FileUtility {
	
	public static String getDataFromJsonFile(String key) throws IOException, ParseException {
		FileReader fr= new FileReader("./src/test/resources/cd.json");
		JSONParser parser = new JSONParser();
		Object obj= parser.parse(fr);
		JSONObject jobj= (JSONObject) obj;
		String value = jobj.get(key).toString();
		return value;
		
	}
	public static String getDataFromExcelFile(String sheetName , int rowIndex , int columnInex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/tsd.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowIndex).getCell(columnInex).getStringCellValue();
		return value;
	}
}
