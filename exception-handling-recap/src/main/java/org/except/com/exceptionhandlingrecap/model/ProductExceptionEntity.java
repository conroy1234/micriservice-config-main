package org.except.com.exceptionhandlingrecap.model;

import java.time.LocalDate;

public class ProductExceptionEntity {
	private String message;
	private String massageStatus;
	private LocalDate now;
	private String description;

	public ProductExceptionEntity(String message, String massageStatus, LocalDate now, String description) {
		
		this.message = message;
		this.massageStatus = massageStatus;
		this.now = now;
		this.description = description;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getNow() {
		return now;
	}

	public void setNow(LocalDate now) {
		this.now = now;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMassageStatus() {
		return massageStatus;
	}

	public void setMassageStatus(String massageStatus) {
		this.massageStatus = massageStatus;
	}

	@Override
	public String toString() {
		return "ProductExceptionEntity [message=" + message + ", massageStatus=" + massageStatus + ", now=" + now
				+ ", description=" + description + "]";
	}

}
