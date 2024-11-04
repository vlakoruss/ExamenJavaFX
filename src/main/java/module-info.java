module org.example.examenjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;


    opens org.example.examenjavafx to javafx.fxml;
    exports org.example.examenjavafx;
}