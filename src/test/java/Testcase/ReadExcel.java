package Testcase;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {
        XSSFWorkbook workBook;
        XSSFSheet sheetSingle;
        public ReadExcel(String excelpath)
        {
            try {
                File src = new File(excelpath);
                FileInputStream kekafile1 = new FileInputStream(src);

                workBook = new XSSFWorkbook(kekafile1);


            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        public String getData(int sheetNumber,int row,int column){
            sheetSingle = workBook.getSheetAt(0);
            String data = sheetSingle.getRow(row).getCell(column).getStringCellValue();
            return data;
        }

    }
