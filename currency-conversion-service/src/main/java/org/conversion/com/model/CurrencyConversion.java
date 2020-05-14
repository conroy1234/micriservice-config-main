package org.conversion.com.model;

import java.math.BigDecimal;

public class CurrencyConversion {
	private int id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal calculatedValus;
	private int port;

	public CurrencyConversion() {

	}
	
	public CurrencyConversion(String from, String to) {
	
		this.from = from;
		this.to = to;
	}

	public CurrencyConversion(int id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
			BigDecimal calculatedValus, int port) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.calculatedValus = calculatedValus;
		this.port = port;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getCalculatedValus() {
		return calculatedValus;
	}

	public void setCalculatedValus(BigDecimal calculatedValus) {
		this.calculatedValus = calculatedValus;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "CurrencyConversion [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ conversionMultiple + ", quantity=" + quantity + ", calculatedValus=" + calculatedValus + ", port="
				+ port + "]";
	}

}
