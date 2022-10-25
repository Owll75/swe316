module com.example.swe316 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;


    opens com.example.swe316 to javafx.fxml;
    exports com.example.swe316;
}