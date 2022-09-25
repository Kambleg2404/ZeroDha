package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static String getData(String sheetName,int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("E:\\AARU\\Aarush.xlsx");
	String value = WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
	return value;
	}
}
