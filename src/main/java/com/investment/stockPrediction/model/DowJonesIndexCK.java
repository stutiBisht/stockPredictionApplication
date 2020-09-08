package com.investment.stockPrediction.model;

import java.io.Serializable;
import java.util.Date;

public class DowJonesIndexCK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String stock;

	private Date close_date;

	public DowJonesIndexCK() {
	}

	public DowJonesIndexCK(String stock, Date close_date) {
		this.stock = stock;
		this.close_date = close_date;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public Date getClose_date() {
		return close_date;
	}

	public void setClose_date(Date close_date) {
		this.close_date = close_date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((close_date == null) ? 0 : close_date.hashCode());
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
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
		DowJonesIndexCK other = (DowJonesIndexCK) obj;
		if (close_date == null) {
			if (other.close_date != null)
				return false;
		} else if (!close_date.equals(other.close_date))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		return true;
	}

}
