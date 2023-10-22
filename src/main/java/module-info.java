module com.untar.uts_java {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.untar.uts_java to javafx.fxml;
    exports com.untar.uts_java;
}