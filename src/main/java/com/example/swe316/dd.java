package com.example.swe316;

import classes.Stage;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class dd {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream(new File("Stages.xls"));
        HSSFWorkbook wb=new HSSFWorkbook(fis);
        HSSFSheet sheet=wb.getSheetAt(0);
        FormulaEvaluator formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator();
        //iteration over row using for each loop
        ArrayList aee = new ArrayList();
        ArrayList arrayList= new ArrayList();
        int count=0;
        int count2=0;
        ArrayList<Stage> objects= new ArrayList<Stage>();
        for(Row row: sheet){
            //iteration over cell using for each loop
            for(Cell cell: row) {
                aee.add(cell);
                count++;
            }
            objects.add(count2,new Stage());
//            for (int i = 0; i < aee.size(); i++){
//                 if(i==0)
//                    objects.get(count2).setObjValue(String.valueOf(aee.get(i)));
//                 else if(i==1)
//                         objects.get(count2).setDocNumber(String.valueOf(aee.get(i)));
//                 else if(i==5)
//                     objects.get(count2).setNewValue(String.valueOf(aee.get(i)));
//                 else if(i==6)
//                     objects.get(count2).setOldValue(String.valueOf(aee.get(i)));
//            }
            count2++;
//            arrayList.add(aee);
//            System.out.println(2);
//            System.out.println(arrayList);
//            System.out.println(3);
            aee.clear();
            System.out.println("yyy");
//            System.out.println(count2);
        }
        System.out.println(objects.get(1).toString());
        System.out.println(objects.get(5).toString());
        System.out.println(objects.get(4).toString());
        System.out.println(objects.get(6).toString());
        System.out.println(objects);
        wb.close();

    }
}

