package configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData {

public ArrayList<String> getData(String testclass,String testcasename) throws IOException {
		
              ArrayList<String> a= new ArrayList<String>();

              FileInputStream fis= new FileInputStream("C://ExcelData//CONSENSUS2.0//dataCONSENSUS2vf.xlsx");
              @SuppressWarnings("resource")
              XSSFWorkbook workbook= new XSSFWorkbook(fis);		
		
		int sheets = workbook.getNumberOfSheets();
		
		for(int i=0; i<sheets;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase(testclass)) {
				XSSFSheet sheet= workbook.getSheetAt(i);
				Iterator<Row> rows= sheet.iterator();
				Row firstRow= rows.next();
				Iterator<Cell> ce= firstRow.cellIterator();
				int k=0;
				int column=0;
				while(ce.hasNext()) {
					Cell value= ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						column=k;
					}
					k++;
				}
				
				int m=0;								
				int numRows= sheet.getPhysicalNumberOfRows()-1;
				
				while(m<numRows) {
					
					Row r= rows.next();
																				
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename)) {
						Iterator<Cell> cv= r.cellIterator();
						while(cv.hasNext()) {							
							Cell c= cv.next();
							String data="";
							CellType celltype= c.getCellType();
							if(celltype == CellType.STRING) {
								data= c.getStringCellValue();
							}else if (celltype == CellType.NUMERIC){
								data= String.valueOf(c.getNumericCellValue());
								if(data.endsWith(".0")) {									
									data= data.substring(0, data.length()-2);
								}
							}								
							if(!data.equalsIgnoreCase("x")) {
								a.add(data);
							}														
						}						
					}					
					m++;
				}
				
			}
		}
		return a;

	}
	
}



		//fileInputStream argument
		//FileInputStream fis= new FileInputStream("C://ExcelData//BFM//dataBFM.xlsx");
