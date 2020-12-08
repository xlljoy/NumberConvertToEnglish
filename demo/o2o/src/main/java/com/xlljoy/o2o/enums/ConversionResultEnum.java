package com.xlljoy.o2o.enums;

public enum ConversionResultEnum {
    OUTOFRANGE(-1, "Input is out of range"), 
    SUCCESS(1, "succeed"), 
    INNER_ERROR(-1001, "Operation failed"),
    ILLEGAL_INPUT(-1001, "Please input a number");

    private int state;

    private String stateInfo;

    private ConversionResultEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static ConversionResultEnum stateOf(int index) {
        for (ConversionResultEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}

