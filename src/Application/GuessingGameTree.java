package Application;
import TreePackage.DecisionTreeInterface;
import TreePackage.DecisionTree;
/**
   A class of game trees.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class GuessingGameTree extends DecisionTree<String>
{
   public GuessingGameTree(String question, String noAnswer, String yesAnswer)
   {
      super(question, noAnswer, yesAnswer);
   } // end default constructor

   public void play()
   {
      super.resetCurrentNode(); // Initialize current node to root
      while (!super.isAnswer())
      {
         // Ask current question
         System.out.println(super.getCurrentData());
         if (Client2.isUserResponseYes())
            super.advanceToYes();
         else
            super.advanceToNo();
      } // end while
      
      // Assertion: Leaf is reached

      // Make guess
      System.out.println("My guess is " + super.getCurrentData() + ". Am I right?");
      
      if (Client2.isUserResponseYes())
         System.out.println("I win.");
      else
         learn();
   } // end play
   
   // Responds to the user when this program makes a wrong guess and
   // extends the decision tree so that this guess is not made again.
   private void learn()
   {
      System.out.println("I give up; what are you thinking of? ");
      String correctAnswer = Client2.getUserResponse();
      String currentAnswer = (String)super.getCurrentData();
      
      System.out.println("Give me a question whose answer is yes for " +
                          correctAnswer + " but no for " + currentAnswer);
      String newQuestion = Client2.getUserResponse();
      
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
      super.setCurrentData(question);
      super.setResponses(noAnswer, yesAnswer);
   } // end extendTree
} // end GuessingGame
