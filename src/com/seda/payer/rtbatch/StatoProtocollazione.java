package com.seda.payer.rtbatch;

public enum StatoProtocollazione {

	PROTOCOLLATO("PROTOCOLLATO"), NON_PROTOCOLLATO("NON PROTOCOLLATO");

	private final String asString;

	private StatoProtocollazione(String asString) {
		this.asString = asString;
	}

	public String getAsString() {
		return asString;
	}
	
}
