module com.caresomebody.gramediaautomation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.caresomebody.gramediaautomation to javafx.fxml;
    exports com.caresomebody.gramediaautomation;
}