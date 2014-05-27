package net.astorian.exc.core.config;

import java.io.File;

public class ConfigurationHandler {

	public static void init(String configPath) {
		ClientConfiguration.init(new File(configPath + "ProjectExc.cfg"));
	}

}
