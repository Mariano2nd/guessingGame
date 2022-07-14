package Application;
import java.util.Scanner;

/**
   A driver for the class GuessingGameTree.

   @author Frank M. Carrano
   @author Timothy M. Henry
   @author Joseph Erickson
   @version 5.0
 */
public class Client2
{
	public static void main(String[] args)
	{
		GuessingGameTree gameTree = new GuessingGameTree("Does it have fur?", "iguana", "cat");
		String response;
		do
		{
			System.out.println("Think of an animal and I will guess it.");
			System.out.println("You can choose one of the following 10 animals, "
					+ "or one of your own:");
			System.out.println("\tAlligator; Bear; Cat; Dog; Elephant; "
					+ "Frog; Giraffe; Hippo; Iguana; Jackalope.");
			
			gameTree.play();
			System.out.print("Play again? ");
			response = getUserResponse();
		} while (response.toLowerCase().equals("yes"));
		System.out.println("Bye!");
	}  // end main

	public static String getUserResponse()
	{
		Scanner keyboard = new Scanner(System.in);
		String response = keyboard.nextLine();

		return response;
	} // endgetUserResponse

	public static boolean isUserResponseYes()
	{
		String answer = getUserResponse();
		if (answer.toLowerCase().equals("yes"))
			return true;
		else
			return false;
	} // end isUserResponseYes
} // end Client2

/*
 Think of an animal and I will guess it.
You can choose one of the following 10 animals, or one of your own:
	Alligator; Bear; Cat; Dog; Elephant; Frog; Giraffe; Hippo; Iguana; Jackalope.
Does it have fur?
yes
My guess is cat. Am I right?
yes
I win.
Play again? yes
Think of an animal and I will guess it.
You can choose one of the following 10 animals, or one of your own:
	Alligator; Bear; Cat; Dog; Elephant; Frog; Giraffe; Hippo; Iguana; Jackalope.
Does it have fur?
no
My guess is iguana. Am I right?
no
I give up; what are you thinking of? 
frog
Give me a question whose answer is yes for frog but no for iguana
Does it hop?
Play again? yes
Think of an animal and I will guess it.
You can choose one of the following 10 animals, or one of your own:
	Alligator; Bear; Cat; Dog; Elephant; Frog; Giraffe; Hippo; Iguana; Jackalope.
Does it have fur?
no
Does it hop?
yes
My guess is frog. Am I right?
yes
I win.
Play again? yes
Think of an animal and I will guess it.
You can choose one of the following 10 animals, or one of your own:
	Alligator; Bear; Cat; Dog; Elephant; Frog; Giraffe; Hippo; Iguana; Jackalope.
Does it have fur?
no
Does it hop?
no
My guess is iguana. Am I right?
no
I give up; what are you thinking of? 
alligator
Give me a question whose answer is yes for alligator but no for iguana
Does it have a powerful jaw?
Play again? yes
Think of an animal and I will guess it.
You can choose one of the following 10 animals, or one of your own:
	Alligator; Bear; Cat; Dog; Elephant; Frog; Giraffe; Hippo; Iguana; Jackalope.
Does it have fur?
no
Does it hop?
no
Does it have a powerful jaw?
yes
My guess is alligator. Am I right?
yes
I win.
Play again? no
Bye!

 */
