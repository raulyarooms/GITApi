package org.yarooms.framework;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GINUtils {
	
	public static String apiURL;
	public static String apiKEY;
	
	@BeforeAll
	public static void setupAll()
	{
		apiURL = "https://api.ginplatform.io";
		apiKEY = "4a6ec4f0-ebed-11e8-b2fd-29ceec6f5586";
	}
	
}
