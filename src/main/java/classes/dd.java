package classes;

import java.io.IOException;
import java.util.ArrayList;

public class dd {
    public static void main(String[] args) throws IOException {
        Reader hh=new Reader();
        String proID="005056AB1EC01EDBBFD057AF0C4A4B8D";
        String path ="Stages.xls";
        String path2 ="Stages_Detailed.xls";
//        System.out.println(hh.readStages(path));
        ArrayList<Stage> nn=hh.readStages(path);
//        System.out.println(nn);
        System.out.println(hh.prjectStage(proID,nn));
//        hh.readStagesDetails(path2);
    }
}
