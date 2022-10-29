package classes;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FactoryRead read = new FactoryRead("Projects.xls","Stages.xls","Stages_Detailed.xls");

//        for (Project x : read.readProject("Projects.xls",read.readStages("Stages.xls"))){
//            System.out.println(x);
//        }

        for (Stage x: read.getStages_list()){
            System.out.println(x);
        }


    }
}