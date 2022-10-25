package classes;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
    Reader(){

    }
//    public ArrayList<Stage> readStages(String filePath) throws IOException {
//        FileInputStream fis=new FileInputStream(new File(filePath));
//        HSSFWorkbook wb=new HSSFWorkbook(fis);
//        HSSFSheet sheet=wb.getSheetAt(0);
//        FormulaEvaluator formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator();
//        //iteration over row using for each loop
//        ArrayList aee = new ArrayList();
//        ArrayList arrayList= new ArrayList();
//        int count=0;
//        int count2=0;
//        ArrayList<Stage> objects= new ArrayList<Stage>();
//        for(Row row: sheet){
//            //iteration over cell using for each loop
//            for(Cell cell: row) {
//                aee.add(cell);
//                count++;
//            }
//            objects.add(count2,new Stage());
//            for (int i = 0; i < aee.size(); i++){
//                if(i==0)
//                    objects.get(count2).setObjValue(String.valueOf(aee.get(i)));
//                else if(i==1)
//                    objects.get(count2).setDocNumber(String.valueOf(aee.get(i)));
//                else if(i==5)
//                    objects.get(count2).setNewValue(String.valueOf(aee.get(i)));
//                else if(i==6)
//                    objects.get(count2).setOldValue(String.valueOf(aee.get(i)));
//            }
//            count2++;
////            arrayList.add(aee);
////            System.out.println(2);
////            System.out.println(arrayList);
////            System.out.println(3);
//            aee.clear();
////            System.out.println(count2);
//        }
//        objects.remove(0);
////        System.out.println(objects.get(1).toString());
////        System.out.println(objects.get(5).toString());
////        System.out.println(objects.get(4).toString());
////        System.out.println(objects.get(6).toString());
////        System.out.println(objects);
//        wb.close();
//        return objects;
//    }
public ArrayList<Stage> readStages(String filePath) throws IOException {
    FileInputStream fis = new FileInputStream(new File(filePath));
    HSSFWorkbook wb = new HSSFWorkbook(fis);
    HSSFSheet sheet = wb.getSheetAt(0);
//    ArrayList list = new ArrayList<>();
    ArrayList<Stage> stage_list = new ArrayList<Stage>();

    ArrayList<String> objectV = new ArrayList<String>();
    ArrayList<Integer> ducN = new ArrayList<Integer>();
    ArrayList<String> FieldN = new ArrayList<String>();
    ArrayList<String> indicator = new ArrayList<String>();
    ArrayList<Integer> textF = new ArrayList<Integer>();
    ArrayList<Number> newV = new ArrayList<Number>();
    ArrayList<Integer> oldV = new ArrayList<Integer>();

    int index = 0;
    for(Row row: sheet){
        if (row.getRowNum() !=0){
            //iteration over cell using for each loop
            if (row.getPhysicalNumberOfCells()==7){
                for(Cell cell: row) {
                    if (index == 0){
                        objectV.add(cell.getStringCellValue());
                        index++;
                    } else if (index ==1) {
                        ducN.add((int) cell.getNumericCellValue());
                        index++;
                    }else if (index ==2) {
                        FieldN.add(cell.getStringCellValue());
                        index++;
                    }else if (index ==3) {
                        indicator.add(cell.getStringCellValue());
                        index++;
                    }else if (index ==4) {
                        textF.add((int) cell.getNumericCellValue());
                        index++;
                    }else if (index ==5){
                        newV.add((int) cell.getNumericCellValue());
                        index++;
                    }else if (index ==6) {
                        oldV.add((int) cell.getNumericCellValue());
                        index = 0;
                    }

                }
            }else {
                for(Cell cell: row) {
                    if (index == 0){
                        objectV.add(cell.getStringCellValue());
                        index++;
                    } else if (index ==1) {
                        ducN.add((int) cell.getNumericCellValue());
                        index++;
                    }else if (index ==2) {
                        FieldN.add(cell.getStringCellValue());
                        index++;
                    }else if (index ==3) {
                        indicator.add(cell.getStringCellValue());
                        index++;
                    }else if (index ==4) {
                        textF.add((int) cell.getNumericCellValue());
                        index++;
                    }else if (index ==5) {
                        newV.add((int) cell.getNumericCellValue());
                        oldV.add(0);
                        index =0;
                    }
                }
            }
            stage_list.add(new Stage());
            stage_list.get(stage_list.size()-1).setObjValue(objectV.get(0));
            stage_list.get(stage_list.size()-1).setDocNumber(ducN.get(0));
            stage_list.get(stage_list.size()-1).setNewValue((Integer) newV.get(0));
            stage_list.get((stage_list.size())-1).setOldValue((Integer) oldV.get(0));

            objectV.clear();
            ducN.clear();
            oldV.clear();
            newV.clear();

        }
    }
    return stage_list;
}
    public ArrayList<Stage> prjectStage(String prject,ArrayList<Stage> stages){
        ArrayList<Stage> prjctStage =new ArrayList<Stage>();
        for (Stage s: stages) {
            if(s.getObjValue().equals(prject)){
                prjctStage.add(s);
            }
        }
        return prjctStage;
    }

    public ArrayList<Stage> readStagesDetails(String filePath) throws IOException {
        FileInputStream fis=new FileInputStream(new File(filePath));
        HSSFWorkbook wb=new HSSFWorkbook(fis);
        HSSFSheet sheet=wb.getSheetAt(0);
        ArrayList aee = new ArrayList();
        int count=0;
        int kk;
        int count2=0;
        ArrayList<Stage> objects= new ArrayList<Stage>();
        for(Row row: sheet){
            for(Cell cell: row) {
                aee.add(cell);
                count++;
            }
            objects.add(count2,new Stage());
            for (int i = 0; i < aee.size(); i++){
                if(i==2)
                    System.out.println(String.valueOf(aee.get(i)));
            }
            count2++;
            aee.clear();
        }
        objects.remove(0);
        wb.close();
        return objects;
    }
}
