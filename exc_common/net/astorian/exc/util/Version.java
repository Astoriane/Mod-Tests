package net.astorian.exc.util;

import java.net.URI;

import net.astorian.exc.ExtraneousCraft;
import net.astorian.exc.lib.Reference;

import org.json.JSONObject;
import org.json.JSONTokener;

public class Version {
	
	private static String serverVersion;
	
	public static void checkServerVersion() {
		try {
			URI uri = new URI(Reference.VERSION_JSON);
			JSONTokener tokener = new JSONTokener(uri.toURL().openStream());
			JSONObject root = new JSONObject(tokener);
			
			serverVersion = root.getString("version");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String[] processVersion(String version) {
		int versionLength = version.length();
		String[] breakdown = new String[versionLength];
		
		for(int i = 0; i < versionLength; i++) {
			breakdown[i] = Character.toString(version.charAt(i));
		}
		
		return breakdown;
	}
	
	public static double getVersionNumber() {
		String versionNumber = serverVersion.substring(0, processVersion(serverVersion).length - 1);
		return Double.valueOf(versionNumber);
	}
	
	public static boolean isVersionAlpha() {
		if(processVersion(serverVersion)[processVersion(serverVersion).length - 1] == "a") 
			return true;
		else
			return false;
		
	}
	
	public static boolean isVersionBeta() {
		if(processVersion(serverVersion)[processVersion(serverVersion).length - 1] == "b") 
			return true;
		else
			return false;
		
	}
	
	public static boolean isVersionStable() {
		if(processVersion(serverVersion)[processVersion(serverVersion).length - 1] == "s" ) 
			return true;
		else
			return false;
		
	}
	
	public static String getServerVersion() {
		return serverVersion;
	}
	
	public static boolean isOutdated() {
		if(Reference.MOD_VERSION == getServerVersion()) {
			return false;
		} else
			return true;
	}

}
