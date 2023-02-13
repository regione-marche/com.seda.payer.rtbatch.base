package com.seda.payer.rtbatch.base.commons;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;


public class MailClient {

	private final Logger log;

	private final String envCfgLocation;



	public MailClient(String envCfgLocation, String loggerCategory) {
		this.envCfgLocation = envCfgLocation;
		log = Logger.getLogger(loggerCategory);
	}



	public void sendMail(String destinationEmail, String subject, String textMailContent) {
		String optionsFileLocation = System.getenv(envCfgLocation);
		FileInputStream fileIn = null;
		Properties props = new Properties();
		try {
			fileIn = new FileInputStream(optionsFileLocation);
			props.load(fileIn);
		} catch (IOException e) {
			log.error("errore nel caricamento delle impostazioni per l'invio mail", e);
			return;
		} catch (Exception e) {
			log.error("errore nel caricamento delle impostazioni per l'invio mail", e);
			return;
		} finally {
			if (fileIn != null) {
				try {
					fileIn.close();
				} catch (Exception e) {}
			}
		}

		final String fromEmail = props.getProperty("mail.auth.fromEmail");
		final String password = props.getProperty("mail.auth.password");

		Authenticator authenticator = new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, authenticator);

		sendEmail(session, fromEmail, destinationEmail, subject, textMailContent);

	}



	private void sendEmail(Session session, String sourceAddress, String destinationAddress, String subject,
			String textMailContent) {
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/plain; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress(sourceAddress, "NoReply-JD"));

			msg.setReplyTo(InternetAddress.parse(sourceAddress, false));

			msg.setSubject(subject, "UTF-8");

			msg.setText(textMailContent, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinationAddress, false));
			Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("errore nell'invio della email riepilogativa", e);
		}
	}
}