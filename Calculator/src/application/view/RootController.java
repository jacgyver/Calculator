package application.view;



import org.controlsfx.dialog.Dialogs;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.Scene;

public class RootController extends Main{
	private Scene scene;
	
	@FXML
	public void handleCSSDefault() {
		System.out.println("menu default");
	}

	@FXML
	public void handleCSSBlackPastel() {
		scene = getScene();
		scene.getStylesheets().add(getClass().getResource("DarkTheme.css").toExternalForm());

	}

	@FXML
	public void handleClose() {
		System.exit(0);
	}
    @FXML
    private void handleAbout() {
    	Dialogs.create()
        .title("자바용 윈도우 계산기")
        .masthead("About")
        .message("미래교육원 융합소프트웨어 : 3조")
        .showInformation();
    }
}
