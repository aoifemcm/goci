package uk.ac.ebi.spot.goci.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNull;
import static uk.ac.ebi.spot.goci.utils.SheetCellProcessingService.processFloatValues;
import static uk.ac.ebi.spot.goci.utils.SheetCellProcessingService.processIntValues;
import static uk.ac.ebi.spot.goci.utils.SheetCellProcessingService.processStringValue;

/**
 * Created by emma on 14/04/2016.
 *
 * @author emma
 *         <p>
 *         Test for SheetCellProcessingService
 */
@RunWith(MockitoJUnitRunner.class)
public class SheetCellProcessingServiceTest {

    XSSFCell cellWithString;

    XSSFCell cellWithInteger;

    XSSFCell cellWithFloat;

    XSSFCell blankCell;

    XSSFCell cellWithNumericString;

    @Before
    public void setUp() throws Exception {
        // Create spreadsheet for testing
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("test");
        XSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("this is a string");
        row.createCell(1).setCellValue(12);
        row.createCell(2).setCellValue(1.22);
        row.createCell(3);
        row.createCell(4).setCellValue("1.22");

        cellWithString = row.getCell(0);
        cellWithInteger = row.getCell(1);
        cellWithFloat = row.getCell(2);
        blankCell = row.getCell(3, row.RETURN_BLANK_AS_NULL);
        cellWithNumericString = row.getCell(4);
    }

    @Test
    public void testProcessIntValues() throws Exception {
        assertNull(processIntValues(cellWithString));
        assertNull(processIntValues(blankCell));
        assertEquals(Integer.valueOf(12), processIntValues(cellWithInteger));
    }

    @Test
    public void testProcessFloatValues() throws Exception {
        assertNull(processFloatValues(cellWithString));
        assertNull(processFloatValues(blankCell));
        assertEquals(Float.valueOf(String.valueOf(1.22)), processFloatValues(cellWithFloat));
    }

    @Test
    public void testProcessStringValue() throws Exception {
        assertNull(processStringValue(blankCell));
        assertEquals("1.22", processStringValue(cellWithNumericString));
        assertEquals("1.22", processStringValue(cellWithFloat));
    }
}