package net.astorian.exc.util;

import java.net.URI;

import net.astorian.exc.lib.Reference;

import org.json.JSONObject;
import org.json.JSONTokener;

public class Version {

	private static String serverVersion;
	private static boolean checkSuccessFlag;

	public static void checkServerVersion() {
		try {
			URI uri = new URI(Reference.VERSION_JSON);
			JSONTokener tokener = new JSONTokener(uri.toURL().openStream());
			JSONObject root = new JSONObject(tokener);

			serverVersion = root.getString("version");
			checkSuccessFlag = true;

		} catch (Exception e) {
			checkSuccessFlag = false;
		}
	}

	private static String[] processVersion(String version) {
		int versionLength = version.length();
		String[] breakdown = new String[versionLength];

		for (int i = 0; i < versionLength; i++) {
			breakdown[i] = Character.toString(version.charAt(i));
		}

		return breakdown;
	}

	public static double getLocalVersionNumber() {
		String versionNumber = Reference.MOD_VERSION.substring(0,
				processVersion(Reference.MOD_VERSION).length - 1);
		return Double.valueOf(versionNumber);
	}

	public static double getServerVersionNumber() {
		String versionNumber = serverVersion.substring(0,
				processVersion(serverVersion).length - 1);
		return Double.valueOf(versionNumber);
	}

	public static String getVersionTag(String version) {
		String index = processVersion(version)[getLetterIndex()];

		if (index.equals("a"))
			return "Alpha";
		else if (index.equals("b"))
			return "Beta";
		else
			return "Stable";

	}

	public static boolean isVersionAlpha() {
		if (processVersion(serverVersion)[getLetterIndex()].equals("a"))
			return true;
		else
			return false;

	}

	private static int getLetterIndex() {
		return processVersion(serverVersion).length - 1;
	}

	public static String getServerVersion() {
		return serverVersion;
	}

	public static boolean isOutdated() {
		if (getLocalVersionNumber() < getServerVersionNumber())
			return true;
		else
			return false;
	}

	public static boolean isVersionCheckSuccessful() {
		return checkSuccessFlag;
	}

}
