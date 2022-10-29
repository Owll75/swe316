package classes;

import java.io.IOException;
import java.util.ArrayList;

public class FactoryRead {
    private ArrayList<Project> projects_list;
    private ArrayList<Stage> stages_list;

    private FactoryRead(){}

    public FactoryRead(String projectPath, String stagesPath, String detailsPath) throws IOException {
        Reader read = new Reader();
        ArrayList<Stage> temp = read.readStages(stagesPath);
        stages_list = read.readStagesDetails(detailsPath,temp);
        projects_list = read.readProject(projectPath, stages_list);
    }

    public ArrayList<Project> getProjects_list() {
        return projects_list;
    }

    public ArrayList<Stage> getStages_list() {
        return stages_list;
    }
}
