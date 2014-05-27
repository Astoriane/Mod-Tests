package net.astorian.exc.core.config;

import java.io.File;

import net.astorian.exc.lib.Categories;
import net.astorian.exc.util.ExcLogger;
import net.minecraftforge.common.config.Configuration;

public class ClientConfiguration {

	private static Configuration configuration;

	protected static void init(File configFile) {

		configuration = new Configuration(configFile);

		try {
			configuration.load();

			configuration.addCustomCategoryComment(Categories.CATEGORY_UPDATE,
					Categories.CATEGORY_UPDATE_DESC);
			ConfigurationSettings.enableVersionCheck = configuration.get(
					Categories.CATEGORY_UPDATE,
					ConfigurationSettings.enableVersionCheck_Name,
					ConfigurationSettings.enableVersionCheck_Default)
					.getBoolean(
							ConfigurationSettings.enableVersionCheck_Default);

		} catch (Exception e) {
			ExcLogger.error("Problem Loading configuration file.");
		} finally {
			configuration.save();
		}

	}
}
