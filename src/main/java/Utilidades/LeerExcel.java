package Utilidades;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

public class LeerExcel {

public static String rutaExel = System.getProperty("user.dir") + "/src/test/resources/Data/Data_Mock.xlsx";
   // private static final Logger LOG = Logger.getLogger(this.getClass().getName());
private static final Logger LOG = Logger.getLogger(LeerExcel.class.getName());

    public static String leerDato(String archivoExcel, int fila, int columna) throws IOException {
        try (FileInputStream fis = new FileInputStream(archivoExcel)) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0); // Obtener la primera hoja

            if (fila >= 1 && fila <= sheet.getLastRowNum() && columna >= 1 && columna <= sheet.getRow(0).getLastCellNum()) {
                Row row = sheet.getRow(fila);
                Cell cell = row.getCell(columna);
                if (cell != null) {
                    return cell.getStringCellValue();
                }
            }
        }
        return "No se encontró el dato";
    }

    public  static void main(String[] args) throws IOException {
        String archivoExcel = "ruta_del_archivo.xlsx";
        int fila = 1;
        int columna = 1;
        String dato = leerDato(rutaExel, fila, columna);
       // System.out.println(dato);
        LOG.info(dato);
//Logger.getLogger(LeerExcel.class.getName()).info(dato);
    }

    //  funcion en java para una cadena de caracteres
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}