package Excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class ExcelWork {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\Vados\\Documents\\Java\\Tables.xls");
        Workbook wb = new HSSFWorkbook(fis);
        Map<Integer, String> mapActivities = new HashMap<>();
        List<String> activities = new ArrayList<>();
        Integer id = 0;

        for (Row row : wb.getSheet("activity")) {
            if (row.getRowNum() == 0) continue;
            for (Cell cell :row) {
                if (cell.getColumnIndex() == 0) {
                    Object elem = getCellText(cell);
                    id = Double.valueOf(String.valueOf(elem)).intValue();
                } else if (cell.getColumnIndex() == 1) {
                    String activity = getCellText(cell).toString();
                    mapActivities.put(id, activity);
                    activities.add(activity);
                }
            }
        }
        fis.close();

    }

    private static Object getCellText(Cell cell) {
        Object o = null;
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                o =cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    o = cell.getDateCellValue();
                } else {
                    o = cell.getNumericCellValue();
                }
                break;
            default:

        }
        return o;
    }
}
