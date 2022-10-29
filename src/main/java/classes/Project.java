package classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class Project {
    private String nodeID;
    private String CusProID;
    private int stages;
    private Date startDate;
    private Date endDate;
    private int customerNUM;
    private ArrayList<Stage> list_stage;
    private ArrayList<Date> datesList;

    Project(){
        list_stage = new ArrayList<Stage>();
    }

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

    public String getNodeID() {
        return nodeID;
    }

    public String getCusProID() {
        return CusProID;
    }

    public int getStages() {
        return stages;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getCustomerNUM() {
        return customerNUM;
    }

    public ArrayList<Stage> getList_stage() {
        return list_stage;
    }

    public ArrayList<Date> getDatesList() {

        ArrayList<Stage> stageArrayList = getList_stage();
        for (int i = 0; i < stageArrayList.size(); i++) {
            Date date = stageArrayList.get(i).getDate();

            datesList.add(date);

        }
        datesList.sort((o1, o2) -> o1.compareTo(o2));
        return (ArrayList<Date>) datesList.stream().distinct().collect(Collectors.toList());

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
