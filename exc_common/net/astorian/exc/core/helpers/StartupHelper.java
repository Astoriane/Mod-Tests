package net.astorian.exc.core.helpers;

import net.astorian.exc.lib.Reference;
import net.astorian.exc.util.ExcLogger;
import net.astorian.exc.util.Version;

public class StartupHelper {

	public static void checkVersion() {
		Version.checkServerVersion();
	}

	public static void logVersion() {
		ExcLogger.info("Current local version: " + Reference.MOD_VERSION + " "
				+ Version.getVersionTag(Reference.MOD_VERSION));
		ExcLogger.info("Current server version: " + Version.getServerVersion()
				+ " " + Version.getVersionTag(Version.getServerVersion()));
		ExcLogger.info("Is Exc Outdated: "
				+ String.valueOf(Version.isOutdated()));
	}

}
