package wall.daniel.quesadillaclicker.backend;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import wall.daniel.quesadillaclicker.sprites.building;

public class fileUtils {

	public static String FILENAME = "quesadillaclicker_save.json";
	private static double cookies;

	public static void saveFile(ArrayList<building> buildings, double cookies) {
		JSONArray jsonArr = new JSONArray();

		// Add building stuff
		for (building b : buildings) {
			JSONObject json = new JSONObject();

			json.put("name", (b.name));
			json.put("amount", Integer.toString(b.getQuantity()));

			jsonArr.add(json);
		}

		// Add cookies
		JSONObject json = new JSONObject();
		json.put("cookies", cookies);
		jsonArr.add(json);

		// System.out.print(jsonArr);

		// Attempt to save to file
		try {
			FileWriter file = new FileWriter(FILENAME);
			file.write(jsonArr.toJSONString());
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<building> readBuildings(ArrayList<building> buildings) {
		JSONParser parse = new JSONParser();

		// Attempt to read file
		try {
			Object obj = parse.parse(new FileReader(FILENAME));
			JSONArray jsonArr = (JSONArray) obj;

			for (int i = 0; i < jsonArr.size(); i++) {
				JSONObject json = (JSONObject) jsonArr.get(i);

				// Make sure not cookie object
				if (!json.containsKey("cookies")) {
					// Get index by searching for it
					int index = 0;
					for (int x = 0; x < buildings.size(); x++) {
						if (buildings.get(x).name.equals(json.get("name"))) {
							index = x;
							break;
						}
					}

					// Set building stuff to saved stuff
					buildings.get(index).quantity = Integer.parseInt((String) json.get("amount"));
				} else {
					cookies = (Double) json.get("cookies");
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassCastException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return buildings;
	}
	
	public static double readCookies() {
		return cookies;
	}
}
