package testUtility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataProvider {
	public static String firstname;
	public static String lastname;
	public static String zipcode;
	public static String message;
	public static JSONObject obj=null;
	public static JSONParser parser;
	public static JSONArray cusinfojsonarray;
	public static FileReader reader;
	public static String[] data ;
	
	public static void main(String args[]) {
		dataProvider();
	}
	
 public static Object[] dataProvider() {
	  parser = new JSONParser();
	 
	 try {
	   reader = new FileReader(System.getProperty("user.dir")+ "\\src\\test\\resources\\Data\\Data.json");
		obj = (JSONObject)parser.parse(reader);
	} catch (IOException | ParseException exception) {
		exception.printStackTrace();
	}
	 //Store jsonobject in jsonarray
	  cusinfojsonarray = (JSONArray)obj.get("Data");
	 data = new String[cusinfojsonarray.size()];
	 
	
	 
	 
	/* for (int i=0; i<cusinfojsonarray.size(); i++) {
		obj = (JSONObject)cusinfojsonarray.get(i);
		 firstname = (String)obj.get("firstName");
		 lastname = (String)obj.get("lastName");
		 zipcode = (String)obj.get("zipCode");
		 message = (String)obj.get("Message");
		
		data[i] = firstname + "," + lastname + "," + zipcode + "," +  message;
		System.out.println(data[i]); */
	 
	 
	// Object[] data = new Object[1]; 
	 return new Object[] {data};
	 
 	}
}


