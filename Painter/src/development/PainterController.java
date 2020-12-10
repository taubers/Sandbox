package development;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class PainterController {

    private enum PenSize {
        SMALL(2),
        MEDIUM(4),
        LARGE(6);

        private final int radius;

        PenSize(int radius) {
            this.radius = radius;
        } // constructor

        public int getRadius() {
            return radius;
        }
    }


    // Color
    @FXML
    private RadioButton blackRadioButton;

    @FXML
    private RadioButton redRadioButton;

    @FXML
    private RadioButton greenRadioButton;

    @FXML
    private RadioButton blueRadioButton;

    @FXML
    private RadioButton smallRadioButton;

    //Toggle Groups
    @FXML
    private ToggleGroup colorToggleGroup;

    @FXML
    private ToggleGroup sizeToggleGroup;

    //Pen Size
    @FXML
    private RadioButton mediumRadioButton;

    @FXML
    private RadioButton largeRadioButton;

    //Buttons
    @FXML
    private Button undoButton;

    @FXML
    private Button clearButton;

    //Pane
    @FXML
    private Pane drawingAreaPane;

    //instance variables for managing Painter state
    private PenSize radius = PenSize.MEDIUM; //radius of circle
    private Paint brushColor = Color.BLACK; // drawing color

    // user data for radio buttons
    public void initialize() {
        blackRadioButton.setUserData(Color.BLACK);
        redRadioButton.setUserData(Color.RED);
        greenRadioButton.setUserData(Color.GREEN);
        blueRadioButton.setUserData(Color.BLUE);
        smallRadioButton.setUserData(PenSize.SMALL);
        mediumRadioButton.setUserData(PenSize.MEDIUM);
        largeRadioButton.setUserData(PenSize.LARGE);
    }

    //Action
    @FXML
    private void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(),
                event.getY(),
                radius.getRadius(),
                brushColor);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    private void colorRadioButtonsSelected(ActionEvent event) {
        brushColor = (Color) colorToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    private void sizeRadioButtonSelected(ActionEvent event) {
        radius = (PenSize) sizeToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    private void undoButtonPressed(ActionEvent event) {
        int count = drawingAreaPane.getChildren().size();

        if (count > 0) {
            drawingAreaPane.getChildren().remove(count - 1);
        }
    }

    @FXML
    private void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }


}
