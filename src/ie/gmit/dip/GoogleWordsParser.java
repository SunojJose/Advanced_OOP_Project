package ie.gmit.dip;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.io.*;

/**
 * Overrides the <b>parse method </b> of abstract class Parser. Reads the file
 * google-1000 words line by line using BufferedReader (dependency) and put each
 * words to the map as key-value pairs and add each words to the set.
 * 
 * @author Sunoj Jose
 * @version 0.1
 * @since 1.8
 */
public class GoogleWordsParser extends Parser {

	private static String file;
	private static Map<String, String> map = new ConcurrentHashMap<>();
	private static Set<String> set = new HashSet<>();

	/**
	 * Creates a new<code> GoogleWordsParser</code> object
	 */
	public GoogleWordsParser() {
		super();
	}

	/**
	 * Creates a new <code> GoogleWordsParser</code> object, invokes the <b>setFile
	 * method </b>
	 * 
	 * @param file The google-1000 words text file.
	 */
	public GoogleWordsParser(String file) {
		super();
		setFile(file);

	}

	/**
	 * Sets the value of the static variable file.
	 * 
	 * @param file The google-1000 words text file.
	 */
	protected void setFile(String file) {
		GoogleWordsParser.file = file;
	}

	/**
	 * Reads the google-1000 words text file line by line, put the words to the
	 * ConcurrentHasMap as key-value pair and adds each words to the HashSet. It has
	 * O(1) time complexity in average (amortize) case and O(n) in worst case to put
	 * the key-value pair to the map, and O(1),O(n) for average (amortize) and worst
	 * case time complexity, respectively for add to the HashSet.
	 */
	public void parse() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file))));
		String line = null;

		while ((line = br.readLine()) != null) {

			map.put(line, line);
			set.add(line);
		}

		br.close();

	}

	/**
	 * accessor of the Map to other classes.
	 * 
	 * @return The <code>map</code> contains the google words key-value pairs.
	 */
	public Map<String, String> getMap() {
		return GoogleWordsParser.map;
	}

	/**
	 * accessor of the Set to other classes.
	 * 
	 * @return The <code>set </code>contains the google words.
	 */
	public Set<String> getSet() {
		return GoogleWordsParser.set;
	}

}
