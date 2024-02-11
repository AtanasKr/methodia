import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

public class ExcelReader {
    public static void main(String[] args) {
        String excelFilePath = "C:\\Users\\Atanas\\Downloads\\methodia\\src\\Test.xlsx";

        try (FileInputStream inputStream = new FileInputStream(excelFilePath)) {
            Workbook excelFile = WorkbookFactory.create(inputStream);
            Sheet sheetHolder = excelFile.getSheetAt(0);
            FormulaEvaluator formulaEvaluator = excelFile.getCreationHelper().createFormulaEvaluator();

            for (Row row : sheetHolder) {
                for (Cell cell : row) {
                    switch (formulaEvaluator.evaluateInCell(cell).getCellTypeEnum()) {
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                System.out.print(cell.getDateCellValue() + "\t");
                            } else {
                                System.out.print(cell.getNumericCellValue() + "\t");
                            }
                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        case FORMULA:
                            System.out.print(cell.getCellFormula() + "\t");
                            break;
                        default:
                            System.out.print("\t");
                    }
                }
                System.out.println();
            }
            excelFile.close();
        } catch (IOException | EncryptedDocumentException | InvalidFormatException ex) {
            ex.printStackTrace();
        }
    }
}
