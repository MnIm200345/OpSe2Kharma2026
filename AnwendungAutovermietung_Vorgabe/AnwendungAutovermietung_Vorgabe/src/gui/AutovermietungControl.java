package gui;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.*;
import javafx.stage.Stage;

public class AutovermietungControl {
	private AutovermietungModel autovermietungModel;
	private AutovermietungView autovermietungView;
	
	public AutovermietungControl(Stage primaryStage) {
		this.autovermietungModel = new AutovermietungModel();
		this.autovermietungView = new AutovermietungView(this, primaryStage, autovermietungModel);
	}
	
	public void nehmeAutoAuf(){
    	try{ 
    		Auto auto = new Auto(
    			autovermietungView.getTxtKennzeichen().getText(), 
   	            autovermietungView.getTxtTyp().getText(),
   	            autovermietungView.getTxtModell().getText(),
   	            Float.parseFloat(autovermietungView.getTxtTagespreis().getText()),
    		    autovermietungView.getTxtVermietetVonBis().getText().split(";"));
    		
    		autovermietungModel.setAuto(auto);
    		
    		autovermietungView.zeigeInformationsfensterAn("Das Auto wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		autovermietungView.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
	
	public void leseAusDatei(String typ){
    	try {
    		autovermietungModel.leseAusDatei(typ);
    		autovermietungView.zeigeInformationsfensterAn("Die Autos wurden gelesen");
		}
		catch(IOException exc){
			autovermietungView.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			autovermietungView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
	
	public void schreibeAutoInCsvDatei() {
		try {
			autovermietungModel.schreibeAutoInCsvDatei();
   			autovermietungView.zeigeInformationsfensterAn(
	   			"Die Autos wurden gespeichert!");
		}	
		catch(IOException exc){
			autovermietungView.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			autovermietungView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}
	
}
