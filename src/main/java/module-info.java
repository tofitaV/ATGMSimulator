module com.example.atgmsimulator {
    requires com.almasb.fxgl.all;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.atgmsimulator to javafx.fxml;
    exports com.example.atgmsimulator;
    exports com.example.atgmsimulator.components to com.almasb.fxgl.core;

}