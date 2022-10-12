module io.asbun.extracreditcheckboxes {
    requires javafx.controls;
    requires javafx.fxml;


    opens io.asbun.extracreditcheckboxes to javafx.fxml;
    exports io.asbun.extracreditcheckboxes;
}