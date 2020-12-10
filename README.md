# Advanced_OOP_Project
A text simplifier API and application UI in Java that only allows the 1,000 most common words in English.

Introduction

This Java application swaps each word of text entered by the user to its synonym (if exists) in the google list of most common words in English.

Users of the API can be given a Menu with 4 options:

1. Enter the google-1000 words text file 
2. Enter the Moby Thesaurus 2 text file
3. Enter a text to swap words
4. Quit the application

The application functions only if the two text files are entered and words are mapped to its google value. 
If option 2 is chosen before option 1, users are prompted to enter the google words file. 
If option 3 is their first choice, then they are presented the menu again. 
If option 4 is selected the program terminates. 
 
Features 

The Runner is the executable class in the application. It invokes the show method of Menu class from the main method and fires a new thread of the application. 
It is implemented the Runnable Interface for handling threads using Lambda expression. The show method is the only public method in the Menu class.

Users are presented the menu described in the previous session. They are asked to enter the files and the text to swap or to quit the application. 
The console input is then read by using an instance of BufferedReader. 
The methods parseGoogleFile(), parseThesaurusFile(), and swapText() are invoked according to the user choice. 
It is also used BufferedReader to read the file information and text to swap inside these methods.
The mapping and swapping functions are encapsulated.
This class uses the enum ConsoleColour and utilize polymorphism for mapping the words and swapping text. 

The abstract class Parser has three subclasses GoogleWordsParser, ThesaurusWordsParser, and InputTextParser which inherit the default method parse.
 
When the user enters the google 1000 words file an object of Parser, the GoogleWordsParser is called to parse the file line by line and map each word 
to itself using  ConcurrentHashMap and store each word in a HashSet using BufferedReader.

If the user enters the Moby Thesaurus 2 file, the Parser object, ThesaurusParser reads the file line by line using BufferedReader 
and stores the lines in an array of Strings. This class reuses the map and set of GoogleWordsParser. 
It checks each words of a line to a matching google word by iterating through the array (use the contains method of Set). 
If a matching word is found break out of the loop and put each word of the line as key 
and the matching word as value to the map, (which already contains the mapping of the google words).

Once the above mentioned mapping is done the application is ready to swap words if the user enters a text. 
The Parser object, InputTextParser is called to do the swapping. 
The BufferedReader object is used to read the console input inside the swapText method of Menu class 
and stores the text in a String array and passed to the Parser object (InputTextParser). 
This class reuses the map formed by ThesaurusParser. Each word of the array passed is checked for 
a matching google value in the map using the containsKey method of Map. 
If a match is found it uses the get method of Map to obtain the google word, otherwise retain the original word. 
The output is then printed.

Running the Application

The application is packaged as ie.gmit.dip. The source code- the src folder and .jar file - simplifier.jar are included.

The application is launched from an IDE, navigate to the Ruuner class in the src folder and choosing Run as a Java application (or hitting the run button in the menu if any),

OR

From the command line by the following syntax: 

java -Xmx1G –cp ./simplifier.jar ie.gmit.dip.Runner

OR
 
From the command line, navigating to the src folder, then type the following:

javac ie/gmit/dip/*.java

and 

java ie.gmit.dip.Runner


