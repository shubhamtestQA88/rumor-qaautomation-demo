package com.utility;

import java.io.FileInputStream;


import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

    public String readExcelFile(String sheetName, int rowNumber, int columnNumber) throws IOException, EncryptedDocumentException {
        // Path relative to the project or execution directory
        String relativePath = "target/SSITestData.xlsx";
        FileInputStream fis = new FileInputStream(relativePath);
        
        Workbook workbook = WorkbookFactory.create(fis);  
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNumber);
        Cell cell = row.getCell(columnNumber, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

        // Use DataFormatter to handle both numeric and string values
        DataFormatter dataFormatter = new DataFormatter();
        return dataFormatter.formatCellValue(cell);
    }

}

