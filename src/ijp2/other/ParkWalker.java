package ijp2.other;

import java.io.IOException;
import java.net.URL;

import ijp2.controller.MainController;
import ijp2.view.MainView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

 
public class ParkWalker extends Application {
	
   
	public static Stage mainStage;
	
	
	public void start(Stage stage) {
		
		mainStage = stage;
		String viewFxml = Params.FXMLURL;
		URL fxmlURL = null;
		MainView view = null;

		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlURL = this.getClass().getResource(viewFxml);
			AnchorPane root = (AnchorPane) fxmlLoader
					.load(fxmlURL.openStream());
			Scene scene = new Scene(root);
			scene.getStylesheets().add(this.getClass().getResource("/style.css").toExternalForm());
			mainStage.setScene(scene);
			mainStage.setResizable(false);
			
			view = (MainView) fxmlLoader.getController(); //the view object that will handle the interface controls
		} catch (IOException ex) {
			System.err.println("[error] JavaFxView: can't load fxml file \""
					+ fxmlURL.toString() + "\"\n" + ex.toString());
			System.exit(1);
		}
		
		
		
		
		MainController controller = new MainController();
		controller.startWalk(view);			
	}
		

    public static void main(String args[]) {
     	launch(args);
     	System.exit(0);
    }
}