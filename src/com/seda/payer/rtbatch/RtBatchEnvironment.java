package com.seda.payer.rtbatch;

public interface RtBatchEnvironment {

	String LOGGER_CATEGORY_INVIO = "com.seda.payer.rtbatch.invio";

	String LOGGER_CATEGORY_CONTROLLO = "com.seda.payer.rtbatch.controllo";

	String ARG_SIGLA_PROVINCIA = "--sigla-provincia";

	String ARG_DRY_RUN = "--dry-run";

	/**
	 * nome della variabile di ambiente che contiene il percorso completo del
	 * file di configurazione
	 */
	String ENV_CONTROLLO_CFG_FILE_LOCATION = "PYRTCCFG";

	/**
	 * nome dellavariabile di ambiente che contiene il percorso completo del
	 * file di configurazione
	 */
	String ENV_INVIO_CFG_FILE_LOCATION = "PYRTICFG";
}
