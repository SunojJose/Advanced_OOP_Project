package ie.gmit.dip;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Overrides the <b>parse method</b>. Reads the text input using BufferedReader
 * and accesses the Map from ThesaurusParser (dependency), Checks if each word
 * of the text for matching google word as synonym and swap if true, retain
 * otherwise, Prints the resultant text.
 * 
 * @author Sunoj Jose
 * @version 0.1
 * @since 1.8
 *
 */
public class InputTextParser extends Parser {

	private String[] words;

	/**
	 * Creates a new <code>InputTextParser</code> object.
	 * 
	 * @param words The text input for swapping
	 */
	public InputTextParser(String[] words) {
		super();
		this.words = words;
	}

	/**
	 * Uses the ThesaurusParser to access the map that stores each word and its
	 * google value, checks each word of the text for a google value and swap if
	 * found one, otherwise retain the word and prints the result. The
	 * <b>putAll</b>, <b>containsKey</b> and <b>get </b> methods have a time
	 * complexity of O(1) in average (amortize) case, but O(n) in worst case.
	 */
	public void parse() throws Exception {
		Map<String, String> map = new ConcurrentHashMap<>();
		new ThesaurusParser().parse();
		map.putAll(new ThesaurusParser().getMap());

		for (String word : words) {

			if (map.containsKey(word)) {

				System.out.print(map.get(word) + " ");

			} else {
				System.out.print(word + " ");

			}

		}

	}

}
