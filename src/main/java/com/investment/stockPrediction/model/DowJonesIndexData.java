package com.investment.stockPrediction.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@IdClass(DowJonesIndexCK.class)
@Table(name = "DOW_JONES_INDEX_DATA")
public class DowJonesIndexData implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("mm/dd/yyyy"); 
	
	 @Version
	 private Integer version;
	 
	 @NotNull(message = "Please enter stock")
	@Column(name = "quarter")
	private int quarter;
	
	@Id
	@NotEmpty(message = "Please enter stock")
	@Column(name = "stock")
	private String stock;
	
	@Id
	@NotNull(message = "Please enter close_date")
	@Column(name = "close_date")
	private Date close_date;
	
	@NotEmpty(message = "Please enter open_price")
	@Column(name = "open_price")
	private String open_price;
	
	@NotEmpty(message = "Please enter high")
	@Column(name = "high")
	private String high;
	
	@NotEmpty(message = "Please enter low")
	@Column(name = "low")
	private String low;
	
	@NotEmpty(message = "Please enter close_price")
	@Column(name = "close_price")
	private String close_price;
	
	@NotEmpty(message = "Please enter volume")
	@Column(name = "volume")
	private String volume;
	
	@NotEmpty(message = "Please enter percent_change_price")
	@Column(name = "percent_change_price")
	private String percent_change_price;
	
	
	@Column(name = "percent_change_volume_over_last_wk")
	private String percent_change_volume_over_last_wk;
	
	@Column(name = "previous_weeks_volume")
	private String previous_weeks_volume;
	
	@NotEmpty(message = "Please enter next_weeks_open")
	@Column(name = "next_weeks_open")
	private String next_weeks_open;
	
	@NotEmpty(message = "Please enter next_weeks_close")
	@Column(name = "next_weeks_close")
	private String next_weeks_close;
	
	@NotEmpty(message = "Please enter percent_change_next_weeks_price")
	@Column(name = "percent_change_next_weeks_price")
	private String percent_change_next_weeks_price;
	
	@NotEmpty(message = "Please enter days_to_next_dividend")
	@Column(name = "days_to_next_dividend")
	private String days_to_next_dividend;
	
	@NotEmpty(message = "Please enter percent_return_next_dividend")
	@Column(name = "percent_return_next_dividend")
	private String percent_return_next_dividend;
	

	public DowJonesIndexData() {
	}


	public DowJonesIndexData(String[] fields) throws ParseException {
		quarter = Integer.parseInt(fields[0]);;
		stock = fields[1];
		close_date = DATE_FORMAT.parse(fields[2]);
		open_price = fields[3];
		high = fields[4];
		low = fields[5];
		close_price = fields[6];
		volume = fields[7];
		percent_change_price = fields[8];
		percent_change_volume_over_last_wk = fields[9];
		previous_weeks_volume = fields[10];
		next_weeks_open = fields[11];
		next_weeks_close = fields[12];
		percent_change_next_weeks_price = fields[13];
		days_to_next_dividend = fields[14];
		percent_return_next_dividend = fields[15];
	}
	
	
	@Override
	public String toString() {
		return "DowJonesIndexData [quarter=" + quarter + ", stock=" + stock + ", close_date=" + close_date
				+ ", open_price=" + open_price + ", high=" + high + ", low=" + low + ", close_price=" + close_price
				+ ", volume=" + volume + ", percent_change_price=" + percent_change_price
				+ ", percent_change_volume_over_last_wk=" + percent_change_volume_over_last_wk
				+ ", previous_weeks_volume=" + previous_weeks_volume + ", next_weeks_open=" + next_weeks_open
				+ ", next_weeks_close=" + next_weeks_close + ", percent_change_next_weeks_price="
				+ percent_change_next_weeks_price + ", days_to_next_dividend=" + days_to_next_dividend
				+ ", percent_return_next_dividend=" + percent_return_next_dividend + "]";
	}


	public int getQuarter() {
		return quarter;
	}
	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	
	public Date getClose_date() {
		return close_date;
	}
	public void setClose_date(Date close_date) {
		this.close_date = close_date;
	}
	public String getOpen_price() {
		return open_price;
	}
	public void setOpen_price(String open_price) {
		this.open_price = open_price;
	}
	public String getClose_price() {
		return close_price;
	}
	public void setClose_price(String close_price) {
		this.close_price = close_price;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getPercent_change_price() {
		return percent_change_price;
	}
	public void setPercent_change_price(String percent_change_price) {
		this.percent_change_price = percent_change_price;
	}
	public String getPercent_change_volume_over_last_wk() {
		return percent_change_volume_over_last_wk;
	}
	public void setPercent_change_volume_over_last_wk(String percent_change_volume_over_last_wk) {
		this.percent_change_volume_over_last_wk = percent_change_volume_over_last_wk;
	}
	public String getPrevious_weeks_volume() {
		return previous_weeks_volume;
	}
	public void setPrevious_weeks_volume(String previous_weeks_volume) {
		this.previous_weeks_volume = previous_weeks_volume;
	}
	public String getNext_weeks_open() {
		return next_weeks_open;
	}
	public void setNext_weeks_open(String next_weeks_open) {
		this.next_weeks_open = next_weeks_open;
	}
	public String getNext_weeks_close() {
		return next_weeks_close;
	}
	public void setNext_weeks_close(String next_weeks_close) {
		this.next_weeks_close = next_weeks_close;
	}
	public String getPercent_change_next_weeks_price() {
		return percent_change_next_weeks_price;
	}
	public void setPercent_change_next_weeks_price(String percent_change_next_weeks_price) {
		this.percent_change_next_weeks_price = percent_change_next_weeks_price;
	}
	public String getDays_to_next_dividend() {
		return days_to_next_dividend;
	}
	public void setDays_to_next_dividend(String days_to_next_dividend) {
		this.days_to_next_dividend = days_to_next_dividend;
	}
	public String getPercent_return_next_dividend() {
		return percent_return_next_dividend;
	}
	public void setPercent_return_next_dividend(String percent_return_next_dividend) {
		this.percent_return_next_dividend = percent_return_next_dividend;
	}
    
    

}
