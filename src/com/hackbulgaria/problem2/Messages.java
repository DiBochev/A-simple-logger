package com.hackbulgaria.problem2;

public enum Messages {
	
	INFO(1),
	WARNING(2),
	PLSCHECKFFS(3);
	
	private final int message;

    private Messages(int message) {
        this.message = message;
    }

    public int getMessage() {
        return this.message;
    }
}
