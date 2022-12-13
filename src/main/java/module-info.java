module com.example.quiz {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.fasterxml.jackson.databind;

    opens me.wydryszek.quiz to javafx.fxml;
    exports me.wydryszek.quiz;

    opens me.wydryszek.controllers to javafx.fxml;
    exports me.wydryszek.controllers;
}