package com.seda.payer.rtbatch.base.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.commons.codec.binary.Base64;

public class StringUtils {

	public static String listAsString(ArrayList<String> l) {
		int listSize = l.size();
		if (listSize == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int listIndex = 0;

		while (listIndex < listSize) {
			sb.append(l.get(listIndex++));
			sb.append(listIndex < listSize ? " | " : "");
		}
		return sb.toString();
	}

	public static String getStringContent(Reader in) throws IOException {
		BufferedReader rd = new BufferedReader(in);

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		return result.toString();
	}

	public static String base64Decode(String strEncoded) {
		byte[] decodedBytes = Base64.decodeBase64(strEncoded);
		String decodedString = new String(decodedBytes);
		return decodedString;
	}
}
