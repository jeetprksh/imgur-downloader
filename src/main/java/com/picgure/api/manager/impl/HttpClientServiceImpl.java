package com.picgure.api.manager.impl;

import com.picgure.api.manager.HttpClientService;
import com.picgure.api.util.Constants;
import com.picgure.logging.PicgureLogger;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

/*
 * @author Jeet Prakash
 * */
public class HttpClientServiceImpl implements HttpClientService {

	private static Logger logger = PicgureLogger.getLogger(HttpClientServiceImpl.class);

	@Override
	public InputStream getInputStreamForResource(String url) throws Exception {
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		connection.setRequestMethod("GET");
		connection.setConnectTimeout(Constants.HTTP_CONNECTION_TIMEOUT);
		connection.setReadTimeout(Constants.HTTP_CONNECTION_READ_TIMEOUT);

		int responseCode = connection.getResponseCode();
		if (responseCode == 200) {
			return connection.getInputStream();
		} else {
			logger.severe("Status Code not OK for :: " + url);
			return null;
		}
	}
}
