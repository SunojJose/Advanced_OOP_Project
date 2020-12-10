package ie.gmit.dip;

import java.io.*;

/**
 * Provides a <b>menu</b> to the user, where the user can choose an option, and
 * press enter to continue. Based on the selection, other methods are invoked.
 * Uses(Dependency) the enum ConsoleColor and Parser objects(Polymorphism).
 * 
 * @author Sunoj Jose
 * @version 0.1
 * @since 1.8
 *
 */
public class Menu {
	private boolean keepRunning = true;
	private boolean googleParsed;
	private boolean thesaurusParsed;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Invoked from main method of Runner class, displays the menu options to the
	 * user, until the user enter the <i>option-4<i>.
	 * 
	 * @throws Exception
	 */
	public void show() throws Exception {

		while (keepRunning) {
			options();
			int selected = Integer.parseInt(br.readLine());
			if (selected == 1) {
				parseGoogleFile();
			} else if (selected == 2) {
				parseThesaurusFile();
			} else if (selected == 3) {
				swapText();
			} else if (selected == 4) {
				System.out.println("Bye Bye...");
				keepRunning = false;
			} else {
				System.out.println("Invalid choice.");
			}
		}

	}

	/**
	 * Contains the description and menu options,The description is extracted from
	 * the code stubs for the assignment.Uses enum ConcoleColour.
	 */
	private void options() {

		System.out.println(ConsoleColour.BLUE_BRIGHT);
		System.out.println("***************************************************");
		System.out.println("* GMIT - Dept. Computer Science & Applied Physics *");
		System.out.println("*                                                 *");
		System.out.println("*             Text Simplifier V0.1                *");
		System.out.println("*       (AKA Orwellian Language Compliance)       *");
		System.out.println("*                                                 *");
		System.out.println("***************************************************");
		System.out.println("(1) Enter File Google-1000.");
		System.out.println("(2) Enter File Moby Thesaurus-2.");
		System.out.println("(3) Enter Text to Swap Words.");
		System.out.println("(4) Quit.");
		System.out.print("Select an option [1-4]:");
	}

	/**
	 * Invoked according to the user choice, user will be asked to enter the
	 * <b>google-1000 words</b> file details. The details are read from console
	 * using <b>BufferedReader</b> and transfer it to <b>GoogleWordsParser</b> which
	 * then parse the file and do the rest. Uses the concept of<b> polymorphism</b>.
	 * 
	 * @throws Exception
	 */
	private void parseGoogleFile() throws Exception {

		System.out.print("Please enter the google-1000 file name/path: ");
		String file = br.readLine();
		Parser parser = new GoogleWordsParser(file);
		try {
			parser.parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
		googleParsed = true;

	}

	/**
	 * Invoked according to user choice, it uses the concept of<b> polymorphism </b>
	 * to parse the<b> Thesaurus file</b>. Prompts user to enter the google-1000
	 * file, if it is not their first choice.
	 * 
	 * @throws Exception
	 */
	private void parseThesaurusFile() throws Exception {
		if (googleParsed) {

			System.out.print("Please enter the Moby Thesaurus-2 file name/path:");
			String file = br.readLine();
			Parser parser = new ThesaurusParser(file);
			try {
				parser.parse();
			} catch (Exception e) {
				e.printStackTrace();
			}
			thesaurusParsed = true;

		} else {
			System.out.println("Can't proceed without google-1000.");
			parseGoogleFile();
		}
	}

	/**
	 * Invoked if the user opt for choice 3, it also uses <b>polymorphism</b>, to
	 * parse the text entered by the user and shows <b>swapped text </b> if it is
	 * done, otherwise the <b>original</b>. Displays the menu again if the files
	 * were not entered yet.
	 * 
	 * @throws Exception
	 */
	private void swapText() throws Exception {
		if (googleParsed && thesaurusParsed) {

			System.out.print("Please Enter the text to swap:");
			System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);

			String[] words = br.readLine().split(" ");
			Parser parser = new InputTextParser(words);
			parser.parse();

			System.out.println(ConsoleColour.RESET);

		} else {
			System.out.println("Can't do swap without parsing files.");
			options();
		}
	}
}
