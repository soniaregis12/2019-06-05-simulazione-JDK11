package it.polito.tdp.crimes.model;

import com.javadocmd.simplelatlng.LatLng;

public class Distretto {

	private Integer distretto;
	private double longitudine;
	private double latitudine;
	private LatLng punto;
	
	public Distretto(Integer distretto, double longitudine, double latitudine) {
		this.distretto = distretto;
		this.longitudine = longitudine;
		this.latitudine = latitudine;
		this.punto = new LatLng(latitudine,longitudine);
	}

	public Integer getDistretto() {
		return distretto;
	}

	public void setDistretto(Integer distretto) {
		this.distretto = distretto;
	}

	public double getLongitudine() {
		return longitudine;
	}

	public void setLongitudine(double longitudine) {
		this.longitudine = longitudine;
	}

	public double getLatitudine() {
		return latitudine;
	}

	public void setLatitudine(double latitudine) {
		this.latitudine = latitudine;
	}

	@Override
	public String toString() {
		return "Distretto [distretto=" + distretto + ", longitudine=" + longitudine + ", latitudine=" + latitudine
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((distretto == null) ? 0 : distretto.hashCode());
		long temp;
		temp = Double.doubleToLongBits(latitudine);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitudine);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Distretto other = (Distretto) obj;
		if (distretto == null) {
			if (other.distretto != null)
				return false;
		} else if (!distretto.equals(other.distretto))
			return false;
		if (Double.doubleToLongBits(latitudine) != Double.doubleToLongBits(other.latitudine))
			return false;
		if (Double.doubleToLongBits(longitudine) != Double.doubleToLongBits(other.longitudine))
			return false;
		return true;
	}

	public LatLng getPunto() {
		return punto;
	}

	public void setPunto(LatLng punto) {
		this.punto = punto;
	}
	
}
