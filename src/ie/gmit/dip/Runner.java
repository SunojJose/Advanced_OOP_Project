package ie.gmit.dip;

/**
 * The class with the <b>main</b> method, the application starts its execution,
 * when the main method invokes <b> show() method</b>of<b> Menu class</b>.
 * A dependency with Menu class.
 * 
 * @see Menu
 * 
 * @author Sunoj Jose
 * @version 0.1
 * @since 1.8
 */
public class Runner {
	/**
	 * Executes the entire application, by invoking show() method of Menu class.
	 *
	 * 
	 * @param args
	 * @throws Exception
	 */

	public static void main(String[] args) throws Exception {

		new Thread(() -> {

			try {
				new Menu().show();
			} catch (Exception e) {

				e.printStackTrace();
			}

		}).start();

	}

}