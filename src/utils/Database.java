package utils;

import java.util.ArrayList;
import java.util.List;

import model.Pice;

public class Database {
	private static Database instance = new Database();
	private List<Pice> pica = new ArrayList<>();
	private Database() {
	}
	public static Database getInstance() {
		return instance;
	}
	public List<Pice> getPica() {
		return pica;
	}
	public void setPica(List<Pice> pica) {
		this.pica = pica;
	}
	
}
