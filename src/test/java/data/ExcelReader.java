package data;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    static FileInputStream fiss = null;

    public FileInputStream getFileInputStream(){

        String filePath = System.getProperty("user.dir")+"/src/test/java/data/ImagePaths.xlsx";
        File srcFile = new File(filePath);
        try {
            fiss = new FileInputStream(srcFile);
        }catch (FileNotFoundException e){
            System.out.println("File not Found: "+ e.getMessage());
            System.exit(0);
        }

        return fiss;
    }

    public Object[][] getImageData() throws IOException {

        fiss = getFileInputStream();

        XSSFWorkbook wb = new XSSFWorkbook(fiss);
        XSSFSheet sheet = wb.getSheetAt(0);

        int TotalNumberOfRows = (sheet.getLastRowNum()+1);
        int TotalNumberOfColumns = 1;

        String [][]arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfColumns];

        for (int i=0; i<TotalNumberOfRows; i++){

            for (int j=0; j<TotalNumberOfColumns; j++){

                XSSFRow row = sheet.getRow(i);
                arrayExcelData[i][j] = row.getCell(j).toString();
            }
        }

        wb.close();
        return arrayExcelData;
    }

}
