module org.example.localization_process {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.localization_process to javafx.fxml;
    exports org.example.localization_process;
}