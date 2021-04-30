package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Yifei Cao
 *
 */
public class LengthConverter extends Converter {

	@Override
	public void setTitle() {
		this.appName = "Length Converter";
	}

	@Override
	public void createMenu() {
		String lengthUnit[] = { "Kilometer", "Meter", "Centimeter", "Milimeter", "Mile", "Foot", "Inch" };
		convertOption1 = new ComboBox<String>(FXCollections.observableArrayList(lengthUnit));
		convertOption2 = new ComboBox<String>(FXCollections.observableArrayList(lengthUnit));
	}

	@Override
	public Double convert(String unit1, String unit2, Double input) {
		// to do
		//
		return 0.0;

	}

}
