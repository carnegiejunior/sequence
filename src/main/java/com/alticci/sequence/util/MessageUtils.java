package com.alticci.sequence.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class MessageUtils {

	private static ResourceBundle bundle = ResourceBundle.getBundle("messages");

	private MessageUtils() {
	}

	public static String getMessage(String key) {
		String message = null;
		try {
			message = bundle.getString(key);
		} catch (MissingResourceException e) {
			message = key;
		}
		return message;
	}
}
