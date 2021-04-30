package application;

import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * @author Yifei Cao
 *
 */

public class MainScreen extends Application {

	String title;
	static Stage window;
	static Scene scene1;
	Scene scene2;
	Scene scene3;

	@Override
	public void start(Stage primaryStage) {
		try {

			window = primaryStage;

			createTitle();
			window.setTitle(title);

			// creating menu button
			Button calculator = new Button("Calculator");
			Button converter1 = new Button("Temperature Converter");
			Button converter2 = new Button("Length Converter");
			VBox menuButtons = new VBox();
			menuButtons.setSpacing(10.0);

			calculator.setMinWidth(150);
			converter1.setMinWidth(150);
			converter2.setMinWidth(150);

			menuButtons.getChildren().addAll(calculator, converter1, converter2);

			// press the button to switch to temperature converter screen
			Converter t = new Converter();
			scene2 = new Scene(t.scene());
			converter1.setOnAction(e -> window.setScene(scene2));

			// press the button to switch to length converter screen
			LengthConverter l = new LengthConverter();
			scene3 = new Scene(l.scene());
			converter2.setOnAction(e -> window.setScene(scene3));

			// creating layout for the main menu
			GridPane layout = new GridPane();

			layout.setPadding(new Insets(10, 10, 10, 10));

			layout.setAlignment(Pos.CENTER);

			layout.getChildren().add(menuButtons);

			scene1 = new Scene(layout, 400, 300);
			window.setScene(scene1);
			window.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// set the title of the program window
	public void createTitle() {
		this.title = "Multi Tools";
	}

	public static void main(String[] args) {
		launch(args);
	}
}
