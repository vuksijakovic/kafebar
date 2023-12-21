package model;

import java.util.Objects;

public class DodatoPice {
	private int broj;
	private Pice pice;
	public DodatoPice(int broj, Pice pice) {
		super();
		this.broj = broj;
		this.pice = pice;
	}
	public int getBroj() {
		return broj;
	}
	public void setBroj(int broj) {
		this.broj = broj;
	}
	public Pice getPice() {
		return pice;
	}
	public void setPice(Pice pice) {
		this.pice = pice;
	}
	@Override
	public int hashCode() {
		return Objects.hash(pice);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DodatoPice other = (DodatoPice) obj;
		return Objects.equals(pice, other.pice);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return pice.getNaziv() + " x" + broj;
	}
}
