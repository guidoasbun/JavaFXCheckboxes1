package io.asbun.extracreditcheckboxes;

// Programmer: Guido Asbun

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SoftwareSelector extends Application {

    // Create Variables
    Stage window;
    Scene scene1, scene2;
    VBox layout2 = new VBox();
    ArrayList<String> selectedSoftware = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;
        window.setTitle("Software Selector");

        // Create grid for scene1
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(100, 0, 0, 300));
        grid.setVgap(50);
        grid.setHgap(50);

        // Name label
        Label softwareDevelopmentLabel = new Label("Software Development");
        GridPane.setConstraints(softwareDevelopmentLabel, 0, 0);

        Label internetBrowsersLabel = new Label("Internet Browsers");
        GridPane.setConstraints(internetBrowsersLabel, 1, 0);

        Label designSoftwareLabel = new Label("Design Label");
        GridPane.setConstraints(designSoftwareLabel, 2, 0);

        // Check boxes
        CheckBox blueJCheckBox = new CheckBox("BlueJ");
        GridPane.setConstraints(blueJCheckBox, 0, 1);

        CheckBox spyderCheckBox = new CheckBox("Spyder");
        GridPane.setConstraints(spyderCheckBox, 0, 3);

        CheckBox firefoxCheckbox = new CheckBox("Firefox");
        GridPane.setConstraints(firefoxCheckbox, 1, 2);

        CheckBox edgeCheckbox = new CheckBox("Edge");
        GridPane.setConstraints(edgeCheckbox, 1, 3);

        CheckBox fusion360Checkbox = new CheckBox("Fusion 360");
        GridPane.setConstraints(fusion360Checkbox, 2, 1);

        CheckBox photoShopCheckbox = new CheckBox("Photoshop");
        GridPane.setConstraints(photoShopCheckbox, 2, 2);

        CheckBox illustratorCheckbox = new CheckBox("Illustrator");
        GridPane.setConstraints(illustratorCheckbox, 2, 3);


        // Button
        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 1, 4);
        submit.setOnAction(e -> {
            handleSubmit(
                blueJCheckBox,
                spyderCheckBox,
                firefoxCheckbox,
                edgeCheckbox,
                fusion360Checkbox,
                photoShopCheckbox,
                illustratorCheckbox
            );
        });

        grid.getChildren().addAll(
                softwareDevelopmentLabel,
                internetBrowsersLabel,
                designSoftwareLabel,
                blueJCheckBox,
                spyderCheckBox,
                firefoxCheckbox,
                edgeCheckbox,
                fusion360Checkbox,
                photoShopCheckbox,
                illustratorCheckbox,
                submit
        );
        layout2.setPadding(new Insets(0, 0, 0, 50));
        layout2.setSpacing(50);

        layout2.setAlignment(Pos.CENTER);


        scene1 = new Scene(grid, 960, 540);
        scene2 = new Scene(layout2, 960, 540);

        window.setScene(scene1);
        window.show();
    }

    public void handleSubmit(
            CheckBox blueJ,
            CheckBox spyder,
            CheckBox firefox,
            CheckBox edge,
            CheckBox fusion360,
            CheckBox photoshop,
            CheckBox illustrator
    ) {
        if (blueJ.isSelected()) selectedSoftware.add("BlueJ");
        if (spyder.isSelected()) selectedSoftware.add("Spyder");
        if (firefox.isSelected()) selectedSoftware.add("Firefox");
        if (edge.isSelected()) selectedSoftware.add("Edge");
        if (fusion360.isSelected()) selectedSoftware.add("Fusion 360");
        if (photoshop.isSelected()) selectedSoftware.add("Photoshop");
        if (illustrator.isSelected()) selectedSoftware.add("Illustrator");

        if(selectedSoftware.size() > 0) {
            for (String software : selectedSoftware) {
                Label softwareLabel = new Label( software +" Selected ");
                layout2.getChildren().add(softwareLabel);
            }
        } else {
            Label noSoftwareLabel = new Label("No software selected");
            layout2.getChildren().add(noSoftwareLabel);
        }

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());
        layout2.getChildren().add(closeButton);
        window.setScene(scene2);
    }

    public static void main(String[] args) {
        launch();
    }
}



