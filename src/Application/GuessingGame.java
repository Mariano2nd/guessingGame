package Application;
import TreePackage.DecisionTreeInterface;
import TreePackage.DecisionTree;
/**
   A program that plays a guessing game by asking yes-or-no questions.
   This solution uses a decision tree.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class GuessingGame
{
   private DecisionTreeInterface<String> tree;
   
   @SuppressWarnings("unchecked")
public GuessingGame(String question, String noAnswer, String yesAnswer)
   {
      DecisionTree<String> no = new DecisionTree<>(noAnswer);
      DecisionTree<String> yes = new DecisionTree<>(yesAnswer);
      tree = new DecisionTree<>(question, no, yes);
   } // end default constructor

   public void play()
   {
      tree.resetCurrentNode(); // Initialize current node to root
      while (!tree.isAnswer())
      {
         // Ask current question
         System.out.println(tree.getCurrentData());
         if (Client.isUserResponseYes())
            tree.advanceToYes();
         else
            tree.advanceToNo();
      } // end while
      // Assertion: Leaf is reached 

      // Make guess
      System.out.println("My guess is " + tree.getCurrentData() +
                         ". Am I right?");
      if (Client.isUserResponseYes())
         System.out.println("I win.");
      else
         learn();
   } // end play
   
   // Responds to the user when this program makes a wrong guess and
   // extends the decision tree so that this guess is not made again.
   private void learn()
   {
      System.out.println("I give up; what are you thinking of? ");
      String correctAnswer = Client.getUserResponse();
      String currentAnswer = (String)tree.getCurrentData();
      
      System.out.println("Give me a question whose answer is yes for " +
                          correctAnswer + " but no for " + currentAnswer);
      String newQuestion = Client.getUserResponse();
      
      extendTree(newQuestion, currentAnswer, correctAnswer);
   } // end learn
   
   // Replaces the current node, which must be a leaf,
   // with a question and two answers.
   // Parameters:
   //     question  A question ending in '?'.
   //     noAnswer  The response when the answer to the question is 'no'.
   //     yesAnswer The response when the answer to the question is 'yes'.
   private void extendTree(String question, String noAnswer, String yesAnswer)
   {
      tree.setCurrentData(question);
      tree.setResponses(noAnswer, yesAnswer);
   } // end extendTree
} // end GuessingGame
