package com.seda.payer.rtbatch.base.datalayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DaoFactory {

	private static String dbUrl;
	private static String username;
	private static String password;

	private Connection connection;

	private DaoFactory() {
		/* privato perché singleton */
	}

	private static final DaoFactory INSTANCE = new DaoFactory();

	public static DaoFactory getInstance() {
		return INSTANCE;
	}

	public static void configure(Properties properties) throws FactoryConfigurationException {
		String driverClassName = properties.getProperty("db.driver.class");
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new FactoryConfigurationException("Impossibile configurare la factory - classe driver non trovata", e);
		}

		dbUrl = properties.getProperty("db.url");
		username = properties.getProperty("db.username");
		password = properties.getProperty("db.password");

		// TODO testare la configurazione della factory creando e chiudendo un
		// oggetto connnection
	}

	public RtRepositoryDao createDao() throws DaoCreationException {
		try {
			SendRtDaoJdbcImpl dao = new SendRtDaoJdbcImpl();
			dao.connection = getConnection();
			return dao;
		} catch (SQLException e) {
			throw new DaoCreationException(
					"Errore durante la creazione del DAO: impossibile ottenere una connessione verso il db", e);
		}
	}

	public Connection getConnection() throws SQLException {
		if (connection == null) {
			connection = DriverManager.getConnection(dbUrl, username, password);
		}
		return connection;
	}

	public void cleanUp() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				/* ignorata */
			}
		}
	}

}
