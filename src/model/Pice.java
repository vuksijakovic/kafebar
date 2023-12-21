package model;

import java.util.Objects;

public class Pice {
	private String naziv;
	private double cijena;
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public double getCijena() {
		return cijena;
	}
	public void setCijena(double cijena) {
		this.cijena = cijena;
	}
	public Pice(String naziv, double cijena) {
		super();
		this.naziv = naziv;
		this.cijena = cijena;
	}
	@Override
	public String toString() {
		return naziv;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cijena, naziv);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pice other = (Pice) obj;
		return Double.doubleToLongBits(cijena) == Double.doubleToLongBits(other.cijena)
				&& Objects.equals(naziv, other.naziv);
	}
}
