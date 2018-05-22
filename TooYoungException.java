import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TooYoungException extends Exception {

	public TooYoungException() {
		System.out.print("Error : YoungChildren Cannot Make Friends");	
	}

}

