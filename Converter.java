package application;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Yifei Cao
 *
 *The main menu of the program
 */
public class Converter {
	String appName;
	ComboBox<String> convertOption1;
	ComboBox<String> convertOption2;

	// create the converter GUI
	public GridPane scene() {

		setTitle();
		Label name = new Label(appName);
		Text text1 = new Text("=");
		TextField input = new TextField();
		TextField output = new TextField();

		HBox buttons = new HBox();
		buttons.setSpacing(10.0);

		Button button1 = new Button();
		Button button2 = new Button();
		Button button3 = new Button();

		button1.setText("Convert");
		button2.setText("Clear");
		button3.setText("Back");

		button1.setMinWidth(50);
		button2.setMinWidth(60);
		buttons.getChildren().addAll(button1, button2);

		// create two drop-box menus
		createMenu();
		// converter layout
		GridPane layout = new GridPane();
		layout.setMinSize(400, 300);

		// padding
		layout.setPadding(new Insets(10, 10, 10, 10));

		// vertical and horizontal gaps
		layout.setVgap(5);
		layout.setHgap(5);

		// setting the grid alignment
		layout.setAlignment(Pos.CENTER);

		// adding elements to the panel
		layout.add(name, 0, 0);
		layout.add(input, 0, 1);
		layout.add(text1, 1, 1);
		layout.add(output, 2, 1);
		layout.add(convertOption1, 0, 2);
		layout.add(convertOption2, 2, 2);
		layout.add(buttons, 2, 3, 2, 2);
		layout.add(button3, 3, 5);

		// action for Convert button
		button1.setOnAction(e -> {
			// check if input is empty
			if (input.getText() == null || input.getText().trim().isEmpty()) {

			} else {

				Double value1 = Double.valueOf(input.getText());
				String unit1 = convertOption1.getValue();
				String unit2 = convertOption2.getValue();
				output.setText(convert(unit1, unit2, value1).toString());
			}
		});
		// action for Clear button
		button2.setOnAction(e -> {
			input.clear();
			output.clear();

		});
		// action for Back button
		button3.setOnAction(e -> {
			// return to the main screen
			MainScreen.window.setScene(MainScreen.scene1);

		});

		return layout;
	}

	public void setTitle() {
		this.appName = "Temperature Converter";
	}

	// creating the drop-box menu
	public void createMenu() {
		String tempUnit[] = { "Celsius", "Fahrenheit", "Kelvin" };
		convertOption1 = new ComboBox<String>(FXCollections.observableArrayList(tempUnit));
		convertOption2 = new ComboBox<String>(FXCollections.observableArrayList(tempUnit));
	}

	// the conversion process
	public Double convert(String unit1, String unit2, Double input) {
		double result = 0;
		if (unit1 == "Celsius" & unit2 == "Fahrenheit") {
			result = input * 9 / 5 + 32;
		}
		if (unit1 == "Celsius" & unit2 == "Kelvin") {
			result = input + 273.15;
		}
		if (unit1 == "Fahrenheit" & unit2 == "Celsius") {
			result = (input - 32) * 5 / 9;
		}
		if (unit1 == "Fahrenheit" & unit2 == "Kelvin") {
			result = (input - 32) * 5 / 9 + 273.15;
		}
		if (unit1 == "Kelvin" & unit2 == "Celsius") {
			result = input - 273.15;
		}
		if (unit1 == "Kelvin" & unit2 == "Fahrenheit") {
			result = (input - 273.15) * 9 / 5 + 32;
		}
		if (unit1 == unit2) {
			result = input;
		}
		return Math.round(result * 100.0) / 100.0;
	}
}
