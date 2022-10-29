package classes;
import java.util.ArrayList;
import java.util.Date;

public class Project {
    private String nodeID;
    private String CusProID;
    private int stages;
    private Date startDate;
    private Date endDate;
    private int customerNUM;
    private ArrayList<Stage> list_stage;

    Project(){ }

    public void setNodeID(String nodeID) {
        this.nodeID = nodeID;
    }

    public void setCusProID(String cusProID) {
        CusProID = cusProID;
    }

    public void setStages(int stages) {
        this.stages = stages;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setCustomerNUM(int customerNUM) {
        this.customerNUM = customerNUM;
    }

    public void addStage(Stage list){
        list_stage.add(list);
    }

    @Override
    public String toString() {
        return "Project{" +
                "NodeID='" + nodeID + '\'' +
                ", Customer Project ID='" + CusProID + '\'' +
                ", Stages=" + stages +
                ", Star tDate=" + startDate +
                ", End Date=" + endDate +
                ", Customer =" + customerNUM +
                '}';
    }
}
