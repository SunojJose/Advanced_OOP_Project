package ie.gmit.dip;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.io.*;

/**
 * Overrides the <b>parse method </b>.Forms the mapping of Thesaurus words to
 * google words by accessing the map and set from GoogleWordsParser
 * (dependency).
 * 
 * @author Sunoj Jose
 * @version 0.1
 * @since 1.8
 *
 */
public class ThesaurusParser extends Parser {
	private static String file;
	private static Map<String, String> map = new ConcurrentHashMap<>();
	private static Set<String> set = new HashSet<>();

	/**
	 * Creates a new<code> ThesaurusParser</code> object
	 */
	public ThesaurusParser() {
		super();
	}

	/**
	 * Creates a new<code> ThesaurusParser</code> object. Invokes<b> setFile
	 * method</b>.
	 * 
	 * @param file The moby thesaurus-2 file
	 */
	public ThesaurusParser(String file) {
		super();
		setFile(file);

	}

	/**
	 * Sets the value of the static variable file.
	 * 
	 * @param file The moby thesaurus-2 file
	 */
	protected void setFile(String file) {
		ThesaurusParser.file = file;
	}

	/**
	 * accessor to the map to other classes.
	 * 
	 * @return The <code>map</code> contains the all words with key-value pairs.
	 */
	public Map<String, String> getMap() {

		return map;
	}

	/**
	 * Reuses the GoogleWordsParser for its map and set. Reads the Thesaurus file
	 * line by line using BufferedReader and stores in an<i> Array of Strings</i>.
	 * iterates over the array and checks the set for a matching word, if found
	 * assign it to the variable <i>value</i>, break out of the loop, map each word
	 * of the line to that value if it is not null. The time complexity of
	 * putIfAbsent is same as put method, O(1) and O(n) for average(amortize) and
	 * worst cases respectively.The looking up of a word in the set also has the
	 * same time complexities.
	 * 
	 */
	public void parse() throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file))));
		new GoogleWordsParser().parse();
		map.putAll(new GoogleWordsParser().getMap());
		set = new GoogleWordsParser().getSet();

		String line = null;

		while ((line = br.readLine()) != null) {
			String[] words = line.toLowerCase().split(",");
			String value = null;

			for (String word : words) {
				if (set.contains(word)) {
					value = word;
					break;
				}

			}

			if (value != null) {
				for (String word : words) {
					map.putIfAbsent(word, value);
				}
			}

		}
		br.close();
	}

}
