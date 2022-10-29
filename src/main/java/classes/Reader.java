package classes;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Reader {


    Reader() {
    }

    public ArrayList<Stage> readStages(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filePath));
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sheet = wb.getSheetAt(0);

        ArrayList<Stage> stage_list = new ArrayList<Stage>();
        ArrayList<String> objectV = new ArrayList<String>();
        ArrayList<Integer> ducN = new ArrayList<Integer>();
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
                            index++;
                        }else if (index ==3) {
                            index++;
                        }else if (index ==4) {
                            index++;
                        }else if (index ==5) {
                            newV.add((int) cell.getNumericCellValue());
                            index++;
                        }else if (index ==6) {
                            oldV.add((int) cell.getNumericCellValue());
                            index=0;
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
                            index++;
                        }else if (index ==3) {
                            index++;
                        }else if (index ==4) {
                            index++;
                        }else if (index ==5) {
                            newV.add((int) cell.getNumericCellValue());
                            oldV.add(0);
                            index =0;
                        }
                    }
                }

                stage_list.add(new Stage());
                stage_list.get(stage_list.size()-1).setObjValue(objectV.get(objectV.size()-1));
                stage_list.get(stage_list.size()-1).setDocNumber(ducN.get(ducN.size()-1));
                stage_list.get(stage_list.size()-1).setNewValue((Integer) newV.get(newV.size()-1));
                stage_list.get((stage_list.size())-1).setOldValue((Integer) oldV.get(oldV.size()-1));

            }
        }
        return stage_list;

    }


    public ArrayList<Project> readProject(String path, ArrayList<Stage> list) throws IOException {
        FileInputStream file = new FileInputStream(new File(path));
        HSSFWorkbook wb = new HSSFWorkbook(file);
        HSSFSheet sheet = wb.getSheetAt(0);

        ArrayList<Stage> stages_list = list;
        ArrayList<Project> project_list = new ArrayList<Project>();

        for (Row row : sheet) {
            if (row.getRowNum() != 0) {
                if (row.getPhysicalNumberOfCells() == 9) {
                    project_list.add(new Project());
                    for (Cell cell : row) {
                        CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                        if ('A' == (cellRef.formatAsString().charAt(0))) {
                            project_list.get(project_list.size() -1).setNodeID(cell.getRichStringCellValue().getString());
                        }
                        else if ('B' == (cellRef.formatAsString().charAt(0))) {
                            project_list.get(project_list.size() -1).setCusProID(cell.getRichStringCellValue().getString());
                        }
                        else if ('C' == (cellRef.formatAsString().charAt(0))) {
                            project_list.get(project_list.size() -1).setStages((int) cell.getNumericCellValue());
                        }
                        else if ('D' == (cellRef.formatAsString().charAt(0))) {
                            project_list.get(project_list.size()-1).setStartDate(cell.getDateCellValue());
                        }
                        else if ('E' == (cellRef.formatAsString().charAt(0))) {
                            project_list.get(project_list.size()-1).setEndDate(cell.getDateCellValue());
                        }
                        else if ('F' == (cellRef.formatAsString().charAt(0))) {
                            project_list.get(project_list.size()-1).setCustomerNUM((int) cell.getNumericCellValue());
                        }
                        else if ('G' == (cellRef.formatAsString().charAt(0))){}
                        else if ('H' == (cellRef.formatAsString().charAt(0))) {}
                        else if ('I' == (cellRef.formatAsString().charAt(0))) {}
                    }

                    for (Stage x: stages_list){
                        if (x.getObjValue().equals(project_list.get(project_list.size()-1).getNodeID())){
                            project_list.get(project_list.size()-1).addStage(x);
                        }
                    }

                }
            }
        }
        return project_list;
    }

    public ArrayList<Stage> readStagesDetails(String Path, ArrayList<Stage> stageList) throws IOException {
        FileInputStream fis = new FileInputStream(new File(Path));
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sheet = wb.getSheetAt(0);

        ArrayList<Integer> DucNum = new ArrayList<Integer>();
        ArrayList<Date> date = new ArrayList<Date>();

        ArrayList<Stage> list = stageList;

        for (Row row : sheet) {
            if (row.getRowNum() != 0) {
                for (Cell cell : row) {
                    CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                    if ('B' == (cellRef.formatAsString().charAt(0))) {
                        DucNum.add((int) cell.getNumericCellValue());
                    } else if ('C' == (cellRef.formatAsString().charAt(0))) {
                        date.add(cell.getDateCellValue());
                    } else {
                    }
                }
            }
        }

        for(int i = 0; i < list.size();i++){
            for (Stage x : list){
                if (DucNum.get(i).equals(x.getDocNumber())){
                    x.setDate(date.get(i));
                }
            }
        }

        return list;
    }

}

