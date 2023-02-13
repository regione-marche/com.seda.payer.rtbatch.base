package com.seda.payer.rtbatch.base.commons;

/**
 * Informazioni sull'ente
 * <p>
 * I campi sono descritti nei getter
 */
public class EnteDto {

	private String CCFTIDPA;
	private String CCFTUSER;
	private String CCFTPASW;
	private String CCFTURLI;
	private String CCFTEMAI;
	private String CCFTURLR;
	private String CCFTEMAR;

	// TODO sarà da sostituire con il campo che Pietro potrebbe rendere
	// disponibile dalla SP
	private String denominazioneEnte;

	/**
	 * codice IPA
	 */
	public String getCCFTIDPA() {
		return CCFTIDPA;
	}

	public void setCCFTIDPA(String CCFTIDPA) {
		this.CCFTIDPA = CCFTIDPA;
	}

	/**
	 * utente per l'accesso al web service
	 */
	public String getCCFTUSER() {
		return CCFTUSER;
	}

	public void setCCFTUSER(String CCFTUSER) {
		this.CCFTUSER = CCFTUSER;
	}

	/**
	 * password per l'accesso al web service
	 */
	public String getCCFTPASW() {
		return CCFTPASW;
	}

	public void setCCFTPASW(String CCFTPASW) {
		this.CCFTPASW = CCFTPASW;
	}

	/**
	 * url del web service di invio della RT
	 */
	public String getCCFTURLI() {
		return CCFTURLI;
	}

	public void setCCFTURLI(String CCFTURLI) {
		this.CCFTURLI = CCFTURLI;
	}

	/**
	 * email per invio resoconti sull'invio
	 */
	public String getCCFTEMAI() {
		return CCFTEMAI;
	}

	public void setCCFTEMAI(String CCFTEMAI) {
		this.CCFTEMAI = CCFTEMAI;
	}

	/**
	 * url per il controllo dell'esito dei versamenti
	 */
	public String getCCFTURLR() {
		return CCFTURLR;
	}

	public void setCCFTURLR(String CCFTURLR) {
		this.CCFTURLR = CCFTURLR;
	}

	/**
	 * email per invio resoconti sui controlli d'esito
	 */
	public String getCCFTEMAR() {
		return CCFTEMAR;
	}

	public void setCCFTEMAR(String CCFTEMAR) {
		this.CCFTEMAR = CCFTEMAR;
	}

	public String getDenominazioneEnte() {
		return denominazioneEnte;
	}

	public void setDenominazioneEnte(String denominazioneEnte) {
		this.denominazioneEnte = denominazioneEnte;
	}

	@Override
	public String toString() {
		return "EnteDto{" + "CCFTIDPA='" + CCFTIDPA + '\'' + ", CCFTUSER='" + CCFTUSER + '\'' + ", CCFTPASW='" + CCFTPASW + '\''
				+ ", CCFTURLI='" + CCFTURLI + '\'' + ", CCFTEMAI='" + CCFTEMAI + '\'' + ", CCFTURLR='" + CCFTURLR + '\''
				+ ", CCFTEMAR='" + CCFTEMAR + '\'' + ", denominazioneEnte='" + denominazioneEnte + '\'' + '}';
	}

}
