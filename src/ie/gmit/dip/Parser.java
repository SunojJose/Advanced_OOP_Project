package ie.gmit.dip;

/**
 * An abstract class, with a default behavior <b>parse</b> It is up to the
 * classes which inherit this method to determine how to do the parsing.
 * 
 * 
 * @author Sunoj Jose
 * @version 0.1
 * @since 1.8
 *
 */
public abstract class Parser {

	/**
	 * Creates a new <code>Parser</code> object.
	 */
	public Parser() {
		super();
	}

	/**
	 * parse the user input, differs the way according to the classes inherit the
	 * method.
	 * 
	 * @throws Exception
	 */
	public abstract void parse() throws Exception;

}
