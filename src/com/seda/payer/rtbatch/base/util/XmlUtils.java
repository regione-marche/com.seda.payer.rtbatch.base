package com.seda.payer.rtbatch.base.util;


import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;



public class XmlUtils {
	
	private final XPath xpath;
	
	
	
	public XmlUtils() {
		xpath = XPathFactory.newInstance().newXPath();
	}
	
	
	
	private XPathExpression createXPathFor(String strXPath) {
		try {
			return xpath.compile(strXPath);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public NodeList searchInXml(Document doc, String strXPath) {
		XPathExpression xpathExpr = createXPathFor(strXPath);
		try {
			return (NodeList) xpathExpr.evaluate(doc, XPathConstants.NODESET);
		}
		// catch (XPathExpressionException e) {
		catch (Exception e) { /* per sicurezza la faccio più generica */
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	/**
	 * Converte la stringa in un documento xml.
	 *
	 * @return un {@link Document} ottenuto dalla stringa originale oppure <code>null</code> se la conversione fallisce,
	 */
	public Document convertToXmlDocument(String textContent) {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = builderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return null;
		}
		
		InputSource inputSource = new InputSource(new StringReader(textContent));
		
		try {
			return builder.parse(inputSource);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
