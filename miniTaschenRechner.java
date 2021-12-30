import java.math.BigInteger;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MiniTaschenrechner extends Application {
 private TextField t1 = new TextField();
 private TextField t2 = new TextField();
 private TextField t3 = new TextField();
 private HBox box = new HBox(10);
 private Button b1= new Button("+");
 private Button b2= new Button("-");
 private Button b3= new Button("*");
 private Button b4= new Button("/");
 private Label l1= new Label("Operand 1");
 private Label l2= new Label("Operand 2");
 private Label l3= new Label("Ergebnis");
 
	@Override
	public void start(Stage primaryStage) {
		//Scene erzeugen
		Scene s = createScene();
		s.getStylesheets().add(MiniTaschenrechner.class.getResource("Minitaschenrechner.css").toExternalForm());
		primaryStage.setScene(s);
		primaryStage.setTitle("miniTaschenrechner");
		action();
		primaryStage.show();
		//ereignis behandlungen
	
		
		
	}
	private void action() {
		b1.setOnAction((e)-> handle('+'));
		b2.setOnAction((e)->handle('-'));
		b3.setOnAction((e)->handle('*'));
		b4.setOnAction((e)->handle('/'));
	}
	private void handle(char op) {
		try {
		BigInteger a = new BigInteger(t1.getText());
		BigInteger b = new BigInteger(t2.getText());
		BigInteger c;
		switch(op) {
		case '+':
			c= a.add(b);t3.setText("Das Ergebnis ist:"+c);break;
		case '*':
			c= a.multiply(b);t3.setText("Das Ergebnis ist:"+c);break;
		case'-':
			c= a.subtract(b);t3.setText("Das Ergebnis ist:"+c);break;
			default:
				c= a.divide(b);t3.setText("Das Ergebnis ist:"+c);break;
		}
		}catch(Exception e) {
			Alert al = new Alert(AlertType.ERROR);
			al.setHeaderText("Fehler Eingabe Format");
			al.setContentText("Sie haben die Daten falsch eingegeben");
			al.show();
			t1.setText("");
			t2.setText("");
		}
		
	}

	private Scene createScene() {
		GridPane p=new GridPane();
		
		p.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		p.setHgap(5);
		p.setVgap(5);
		p.setPadding(new Insets(10));
		t1.setTooltip(new Tooltip("Geben Sie bitte eine BigInteger Zahl ein"));
		t2.setTooltip(new Tooltip("Geben Sie bitte eine BigInteger Zahl ein"));
		t3.setEditable(false);
		p.add(l1, 0, 0);
		p.add(t1, 1, 0);
		p.add(l2, 0, 1);
		p.add(t2, 1, 1);
		box.getChildren().addAll(b1,b2,b3,b4);
		p.add(box, 1,2,2,1);
		p.add(l3, 0, 3);
		p.add(t3, 1, 3);
		Scene s= new Scene(p);
		return s;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
