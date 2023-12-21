package view;


import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.DodatoPice;
import model.Dugme;
import model.Pice;
import utils.Database;

public class MainView extends BorderPane{
	private List<Dugme> dugmad = new ArrayList<>();
	private GridPane gp = new GridPane();
	private ListView<Pice> piceLv = new ListView<>();
	private TextField brojTf = new TextField();
	private Button plusBtn = new Button("+");
	private Button minusBtn = new Button("-");
	private Button dodajBtn = new Button("Dodaj");
	private ListView<DodatoPice> dodatoPiceLv = new ListView<>();
	private ObservableList<DodatoPice> dpOl = FXCollections.observableArrayList();
	private Button dodajNaAstalBtn = new Button("Dodaj na astal");
	private Label lblCijena = new Label("Ukupna cijena: ");
	private VBox vbox = new VBox(5);
	private ListView<DodatoPice> desnoLv = new ListView<>();
	private Label ukupnoLbl = new Label("Račun: 0.0");
	private Button stampajRacunBtn = new Button("Štampaj račun");
	public MainView() {
		initCentar();
		initLijevo();
		initDesno();
		actions();
	}
	private void initCentar() {
		for(int i=1; i<=18; i++) {
			dugmad.add(new Dugme(new Button()));
		}
		for(int i=0; i<=17; i++) {
			dugmad.get(i).getDugme().setPrefSize(50, 50);
		}
		for(int i=0; i<=17; i++) {
			final Button dugme = dugmad.get(i).getDugme();
			final int b = i;
			dugme.setOnAction(e->{
				dugme.setStyle("-fx-background-color: #4169e1");
				desnoLv.getItems().setAll(dugmad.get(b).getPice());
				double c=0;
				for(DodatoPice dp : dugmad.get(b).getPice()) {
					c+= dp.getPice().getCijena() * dp.getBroj();
				}
				ukupnoLbl.setText("Račun: " + c);
				for(int j=0; j<=17; j++) {
					final int a = j;
					if(!dugmad.get(a).getDugme().equals(dugme)) {
						dugmad.get(a).getDugme().setStyle(new Button().getStyle());
					}
				}
			});
		}
		gp.add(dugmad.get(0).getDugme(), 1, 0);
		gp.add(dugmad.get(1).getDugme(), 3, 0);
		gp.add(dugmad.get(2).getDugme(), 5, 0);
		gp.add(dugmad.get(3).getDugme(), 0, 1);
		gp.add(dugmad.get(4).getDugme(), 2, 1);
		gp.add(dugmad.get(5).getDugme(), 2, 3);
		gp.add(dugmad.get(6).getDugme(), 2, 4);
		gp.add(dugmad.get(7).getDugme(), 2, 5);
		gp.add(dugmad.get(8).getDugme(), 2, 6);
		gp.add(dugmad.get(9).getDugme(), 4, 6);
		gp.add(dugmad.get(10).getDugme(), 4, 4);
		gp.add(dugmad.get(11).getDugme(), 0, 8);
		gp.add(dugmad.get(12).getDugme(), 2, 8);
		gp.add(dugmad.get(13).getDugme(), 0, 10);
		gp.add(dugmad.get(14).getDugme(), 2, 10);
		gp.add(dugmad.get(15).getDugme(), 4, 10);
		gp.add(dugmad.get(16).getDugme(), 5, 2, 1,2);
		gp.add(dugmad.get(17).getDugme(), 3,8, 2,1);
		dugmad.get(16).getDugme().setPrefHeight(100);
		dugmad.get(17).getDugme().setPrefWidth(115);
		gp.setAlignment(Pos.CENTER);
		gp.setVgap(15);
		gp.setHgap(15);
		this.setCenter(gp);
	}
	private void initLijevo() {
		piceLv.getItems().setAll(Database.getInstance().getPica());
		HBox hbox1 = new HBox(5);
		brojTf.setEditable(false);
		brojTf.setText(1+"");
		hbox1.getChildren().addAll(minusBtn, brojTf, plusBtn);
		vbox.getChildren().addAll(piceLv, hbox1, dodajBtn, dodatoPiceLv, lblCijena, dodajNaAstalBtn);
		hbox1.setAlignment(Pos.CENTER);
		vbox.setSpacing(10);
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(0,10, 5,0));
		this.setLeft(vbox);
	}
	private void initDesno() {
		VBox vbox1 = new VBox(5);
		vbox1.getChildren().addAll(desnoLv, ukupnoLbl, stampajRacunBtn);
		vbox1.setAlignment(Pos.CENTER);
		this.setRight(vbox1);
	}
	private void actions() {
		plusBtn.setOnAction(e->{
			brojTf.setText(Integer.parseInt(brojTf.getText())+1+"");
		});
		minusBtn.setOnAction(e->{
			if(Integer.parseInt(brojTf.getText())>1) {
				brojTf.setText(Integer.parseInt(brojTf.getText())-1+"");
			}
		});
		dodajBtn.setOnAction(e->{
			if(piceLv.getSelectionModel().getSelectedItem()!= null) {
				DodatoPice dp = new DodatoPice(Integer.parseInt(brojTf.getText()), piceLv.getSelectionModel().getSelectedItem());
				if(!dpOl.contains(dp)) dpOl.add(dp);
				else {
					for(DodatoPice dod : dpOl) {
						if(dod.equals(dp)) {
							dod.setBroj(dod.getBroj()+dp.getBroj());
							break;
						}
					}
					
				}
				double b=0;
				for(DodatoPice dod : dpOl) {
					b+= dod.getPice().getCijena() * dod.getBroj();
				}
				lblCijena.setText("Ukupna cijena: " +b);
				dodatoPiceLv.getItems().setAll(dpOl);
			}
		});
		dodajNaAstalBtn.setOnAction(e->{
			for(int i=0; i<18; i++) {
				if(dugmad.get(i).getDugme().getStyle().equals("-fx-background-color: #4169e1")) {
					double b=0;
					for(DodatoPice dp : dodatoPiceLv.getItems()) {
						if(dugmad.get(i).getPice().contains(dp)) {
							dugmad.get(i).getPice().get(dugmad.get(i).getPice().indexOf(dp)).setBroj(dugmad.get(i).getPice().get(dugmad.get(i).getPice().indexOf(dp)).getBroj() + dp.getBroj());
						}
						else {
							dugmad.get(i).getPice().add(dp);
						}
						b+= dp.getPice().getCijena() * dp.getBroj();
					}
					ukupnoLbl.setText("Račun: " + b);
					dpOl.clear();
					desnoLv.getItems().setAll(dugmad.get(i).getPice());
					lblCijena.setText("Ukupna cijena: 0.0");
					dodatoPiceLv.getItems().clear();
				}
			}
		});
		stampajRacunBtn.setOnAction(e->{
			for(int i=0; i<18; i++) {
				if(dugmad.get(i).getDugme().getStyle().equals("-fx-background-color: #4169e1")) {
					dugmad.get(i).getPice().clear();
					desnoLv.getItems().setAll(dugmad.get(i).getPice());
					ukupnoLbl.setText("Račun: " + 0);
					dodatoPiceLv.getItems().clear();
				}
			}
		});
	}
}
