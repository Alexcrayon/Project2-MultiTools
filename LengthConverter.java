package application;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;

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
