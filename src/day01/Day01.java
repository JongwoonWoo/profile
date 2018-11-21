package day01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class Day01 {
 
    public static void main(String[] args) {
        
        try {
            // ��������
            File file = new File("test.xlsx");
 
            // ���� ���� ����
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
            
            Cell cell = null;
            
            // ù���� sheet ���� �б�
            for (Row row : wb.getSheetAt(0)) { 
                // ��°�ٺ���..
                if (row.getRowNum() < 2) {
                    continue;
                }
                
                // �ι�° ���� ��������� for���� �����.
                if(row.getCell(1) == null){
                    break;
                }
                
                // �ܼ� ���
                System.out.println("[row] �̸� : " + row.getCell(1) + ", ����: " + row.getCell(2)
                                + ", ����: " + row.getCell(3) + ", ���: " + row.getCell(4));
                
                // 4��° �� ���� ����
                cell = row.createCell(4);
                cell.setCellValue("Ȯ��");
            }
            
            // ���� ���� ����
            FileOutputStream fileOut = new FileOutputStream(file);
            wb.write(fileOut);
        } catch (FileNotFoundException fe) {
            System.out.println("FileNotFoundException >> " + fe.toString());
        } catch (IOException ie) {
            System.out.println("IOException >> " + ie.toString());
        }
    }
}


