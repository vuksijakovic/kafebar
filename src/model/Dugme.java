package model;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;

public class Dugme {
	private Button dugme;
	private List<DodatoPice> pice = new ArrayList<>();
	public Button getDugme() {
		return dugme;
	}
	public void setDugme(Button dugme) {
		this.dugme = dugme;
	}
	public List<DodatoPice> getPice() {
		return pice;
	}
	public void setPice(List<DodatoPice> pice) {
		this.pice = pice;
	}
	public Dugme(Button dugme) {
		super();
		this.dugme = dugme;
	}
	
}
