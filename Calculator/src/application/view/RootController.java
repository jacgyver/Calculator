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
        .title("�ڹٿ� ������ ����")
        .masthead("About")
        .message("�̷������� ���ռ���Ʈ���� : 3��")
        .showInformation();
    }
}
