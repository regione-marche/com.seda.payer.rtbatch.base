package com.seda.payer.rtbatch.base.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {

	public static String getSha256Hash(String content) throws NoSuchAlgorithmException {
		MessageDigest digest = getMessageDigest("SHA-256");
		byte[] encodedhash = digest.digest(content.getBytes());
		String stringHash = bytesToHex(encodedhash);
		return stringHash;
	}

	private static String bytesToHex(byte[] hash) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}

	private static MessageDigest getMessageDigest(String algorithm) throws NoSuchAlgorithmException {
		return MessageDigest.getInstance(algorithm);
	}

}
