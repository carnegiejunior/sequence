package com.alticci.sequence.dto;

public class ResponseDTO {
	
	private Long result;
	
	public ResponseDTO(Long result) {
		this.result = result;
	}

	public Long getResult() {
		return result;
	}
	
	public void setResult(Long result) {
		this.result = result;
	}

}
