module org.example.localization_process {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.localization_process to javafx.fxml;
    exports org.example.localization_process;
}