package com.picgure.command;

import com.picgure.api.manager.ObjectService;
import com.picgure.api.manager.SettingsService;
import com.picgure.api.util.Constants;
import com.picgure.entity.ImgurObjectAttrs;
import com.picgure.entity.ImgurSearchQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.logging.Logger;

public class ApplicationCommands {
	
	private static Logger logger = Logger.getLogger(ApplicationCommands.class.getName());
	
	@Autowired
	private ObjectService objectService;

	@Autowired
	private SettingsService settingsService;

    public void download(String redditName, String order) {

		ImgurSearchQuery imgurSearchQuery = new ImgurSearchQuery(redditName, order);
		logger.info("OBJECT :: " + imgurSearchQuery);
		
		List<ImgurObjectAttrs> allImgurObjectAttrs = objectService.getObjectsInSubreddit(imgurSearchQuery);

		logger.info("List size :: " + allImgurObjectAttrs.size());

		// Calculate overall size
		long size = 0;
		for (ImgurObjectAttrs imgurObject : allImgurObjectAttrs) {
			size += imgurObject.getSize();
		}
		logger.info("Overall Size :: " + size);

		objectService.poolDownloadObjects(allImgurObjectAttrs);
    }

    public void probe(String redditName) {
		ImgurSearchQuery imgurSearchQuery = new ImgurSearchQuery(redditName, Constants.SORT_ORDER_NEW);

		List<ImgurObjectAttrs> allImgurObjectAttrs = objectService.getObjectsInSubreddit(imgurSearchQuery);

		// Calculate overall size
		long size = 0;
		for (ImgurObjectAttrs imgurObject : allImgurObjectAttrs) {
			size += imgurObject.getSize();
		}
		logger.info("There are " + allImgurObjectAttrs.size() + " objects with overall size of " + size + " on " + redditName);
	}

	public void analysis(String reddit, String title) {
		logger.info(reddit + " " + title);
		List<ImgurObjectAttrs> attrs = objectService.searchObjectsByTitle(title, reddit);
		for (ImgurObjectAttrs attr : attrs) {
			logger.info(attr.toString());
		}
	}

	public void settings(String setting, String value) {
		if (!setting.equals(Constants.BLANK_STRING)) {
			settingsService.updateSetting(setting, value);
		} else {
			settingsService.printSettings();
		}
	}
	
}
