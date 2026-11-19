package gui;

import business.AutovermietungModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class AutovermietungView {
	 //---Anfang Attribute der grafischen Oberflaeche---
    private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private Label lblKennzeichen 			= new Label("Kennzeichen:");
    private Label lblTyp   		 			= new Label("Typ:");
    private Label lblModell  	 			= new Label("Modell:");
    private Label lblTagespreis   			= new Label("Tagespreis:");
    private Label lblVermietetVonBis  		= new Label("Vermietet von-bis:");
    private TextField txtKennzeichen 	 	= new TextField();
    private TextField txtTyp				= new TextField();
    private TextField txtModell				= new TextField();
    private TextField txtTagespreis			= new TextField();
    private TextField txtVermietetVonBis		= new TextField();
    private TextArea txtAnzeige  			= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");    
    //-------Ende Attribute der grafischen Oberflaeche-------
    
    private AutovermietungControl autovermietungControl;
    private AutovermietungModel autovermietungModel;
    
    
    
	public AutovermietungView(AutovermietungControl autovermietungControl, Stage primaryStage,AutovermietungModel autovermietungModel) {
		
		this.autovermietungControl = autovermietungControl;
		this.autovermietungModel = autovermietungModel;
		
		Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung einer Autovermietung");
    	primaryStage.show();
    	this.initKomponenten();
		this.initListener();
	}
    
	public void initKomponenten(){
       	// Labels
    	lblEingabe.setLayoutX(20);
    	lblEingabe.setLayoutY(40);
    	Font font = new Font("Arial", 24); 
    	lblEingabe.setFont(font);
    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
    	lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
       	lblKennzeichen.setLayoutX(20);
    	lblKennzeichen.setLayoutY(90);
    	lblTyp.setLayoutX(20);
    	lblTyp.setLayoutY(130);
    	lblModell.setLayoutX(20);
    	lblModell.setLayoutY(170);
    	lblTagespreis.setLayoutX(20);
    	lblTagespreis.setLayoutY(210);
    	lblVermietetVonBis.setLayoutX(20);
    	lblVermietetVonBis.setLayoutY(250);    	
       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
       		lblKennzeichen, lblTyp, lblModell,
       		lblTagespreis, lblVermietetVonBis);
    
    	// Textfelder
     	txtKennzeichen.setLayoutX(170);
    	txtKennzeichen.setLayoutY(90);
    	txtKennzeichen.setPrefWidth(200);
    	txtTyp.setLayoutX(170);
    	txtTyp.setLayoutY(130);
    	txtTyp.setPrefWidth(200);
    	txtModell.setLayoutX(170);
    	txtModell.setLayoutY(170);
    	txtModell.setPrefWidth(200);
      	txtTagespreis.setLayoutX(170);
    	txtTagespreis.setLayoutY(210);
    	txtTagespreis.setPrefWidth(200);
    	txtVermietetVonBis.setLayoutX(170);
    	txtVermietetVonBis.setLayoutY(250);
    	txtVermietetVonBis.setPrefWidth(200);
      	pane.getChildren().addAll( 
     		txtKennzeichen, txtTyp, txtModell,
     		txtTagespreis, txtVermietetVonBis);
     	
        // Textbereich	
        txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(400);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(270);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige); 
       	
        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
        
 		// Menue
  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
  	    this.mnDatei.getItems().add(mnItmCsvImport);
  	    this.mnDatei.getItems().add(mnItmTxtImport);
  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
  	    this.mnDatei.getItems().add(mnItmCsvExport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
   
   public void initListener() {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        	    autovermietungControl.nehmeAutoAuf();
            }
	    });
	    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	           zeigeAutosAn();
	        } 
   	    });
	    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	       	 	autovermietungControl.leseAusDatei("csv");
	    	}
	    });
	    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		     	autovermietungControl.leseAusDatei("txt");
		    }
    	});
	    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				autovermietungControl.schreibeAutoInCsvDatei();
			}	
	    });
    }
    
   public void zeigeAutosAn(){
   	if(autovermietungModel.getAuto() != null){
   		txtAnzeige.setText(
   			autovermietungModel.getAuto().gibAutoZurueck(' '));
   	}
   	else{
   		zeigeInformationsfensterAn("Bisher wurde kein Auto aufgenommen!");
   	}
   }    
    
   public void zeigeInformationsfensterAn(String meldung){
   	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
   		"Information", meldung).zeigeMeldungsfensterAn();
   }	
   
   void zeigeFehlermeldungsfensterAn(String meldung){
      	new MeldungsfensterAnzeiger(AlertType.ERROR,
       	"Fehler", meldung).zeigeMeldungsfensterAn();
   }

   public TextField getTxtKennzeichen() {
	return txtKennzeichen;
   }

   public void setTxtKennzeichen(TextField txtKennzeichen) {
	this.txtKennzeichen = txtKennzeichen;
   }

   public TextField getTxtTyp() {
	return txtTyp;
   }

   public void setTxtTyp(TextField txtTyp) {
	this.txtTyp = txtTyp;
   }

   public TextField getTxtModell() {
	return txtModell;
   }

   public void setTxtModell(TextField txtModell) {
	this.txtModell = txtModell;
   }

   public TextField getTxtTagespreis() {
	return txtTagespreis;
   }

   public void setTxtTagespreis(TextField txtTagespreis) {
	this.txtTagespreis = txtTagespreis;
   }

   public TextField getTxtVermietetVonBis() {
	return txtVermietetVonBis;
   }

   public void setTxtVermietetVonBis(TextField txtVermietetVonBis) {
	this.txtVermietetVonBis = txtVermietetVonBis;
   }

   public TextArea getTxtAnzeige() {
	return txtAnzeige;
   }

   public void setTxtAnzeige(TextArea txtAnzeige) {
	this.txtAnzeige = txtAnzeige;
   } 
   
   
   
    
}
