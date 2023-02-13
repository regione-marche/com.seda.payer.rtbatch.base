package com.seda.payer.rtbatch.base.commons;

/**
 * Informazioni sulla ricevuta telematica
 * <p>
 * I campi sono descritti nei getter
 */
public class RicevutaTelematicaDto {

	private String CRPTRT;
	private Long PRPTPKEY;
	// TODO temporaneo, va modificato con il nome del campo dato dalla SP
	private String sipVersamento;

	/**
	 * Forma testuale della ricevuta telematica
	 */
	public String getCRPTRT() {
		return CRPTRT;
	}

	public void setCRPTRT(String CRPTRT) {
		this.CRPTRT = CRPTRT;
	}

	/**
	 * campo ID
	 */
	public Long getPRPTPKEY() {
		return PRPTPKEY;
	}

	public void setPRPTPKEY(Long PRPTPKEY) {
		this.PRPTPKEY = PRPTPKEY;
	}


	/**
	 * SIP id come esito del versamento
	 */
	public String getSipVersamento() {
		return sipVersamento;
	}



	public void setSipVersamento(String sipVersamento) {
		this.sipVersamento = sipVersamento;
	}



	@Override
	public String toString() {
		return "RicevutaTelematicaDto{" +
				"CRPTRT='" + CRPTRT + '\'' +
				", PRPTPKEY=" + PRPTPKEY +
				", sipVersamento='" + sipVersamento + '\'' +
				'}';
	}

}
