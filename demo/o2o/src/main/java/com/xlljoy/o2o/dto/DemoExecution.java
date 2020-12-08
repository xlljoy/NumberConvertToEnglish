package com.xlljoy.o2o.dto;

import com.xlljoy.o2o.enums.ConversionResultEnum;

public class DemoExecution {
	// result status
	private int state;
	// status information
	private String stateInfo;
	
	private String EnglishResult;
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}


	public DemoExecution() {}
	
	public DemoExecution(ConversionResultEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	public String getEnglishResult() {
		return EnglishResult;
	}

	public void setEnglishResult(String englishResult) {
		EnglishResult = englishResult;
	}


}
