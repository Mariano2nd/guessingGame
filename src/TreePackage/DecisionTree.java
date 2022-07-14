package TreePackage;

import java.util.Iterator;

/**
   A class that implements a decision tree by extending BinaryTree.
  
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
/* Change the following code to implement the interface of DecisionTree */
public class DecisionTree<T> extends BinaryTree<T> implements DecisionTreeInterface<T>
{
	private BinaryNode<T> currentNode; // Tracks where we are in the tree
	
   public DecisionTree()
   {
      /* Add code to here to inherit parent class */
      super();
	  resetCurrentNode();
   } // end default constructor
   
   public DecisionTree(T rootData)
   {
      /* Add code to here to inherit parent class */
	   super(rootData);
      resetCurrentNode();
   } // end constructor

   /* Change the following code for DecisionTree as Binary Tree   */
   public DecisionTree(T rootData, DecisionTreeInterface<T> leftTree, DecisionTreeInterface<T> rightTree)
   {
      /* Add code to here to inherit parent class */
	   super(rootData, leftTree, rightTree);
      resetCurrentNode();
   } // end constructor


   public DecisionTree(T rootData, T responseForNo, T responseForYes)
   {
   /* Change the following code for DecisionTree as BinaryTree responseForNo and responseForYes */
   /* Add code */   DecisionTree<T> leftTree = (DecisionTree<T>) new BinaryTree<T>(responseForNo);
   /* Add code */   DecisionTree<T> rightTree = (DecisionTree<T>) new BinaryTree<T>(responseForYes);
   /* Add code */   setTree(rootData, leftTree, rightTree);
      resetCurrentNode();
   } // end constructor

	public T getCurrentData()
	{
		if (currentNode != null)
		 	return currentNode.getData();
		else
		 	return null;
	} // end getCurrentData
	
	public void setCurrentData(T newData)
	{
		if (currentNode != null)
         currentNode.setData(newData);
      else
         throw new NullPointerException();
	} // end setCurrentData
	
   public void setResponses(T responseForNo, T responseForYes)
	{
      if (currentNode == null)
         throw new NullPointerException();
		else if (currentNode.hasLeftChild())
		{
			/* Add code */ BinaryNode<T> leftChild = new BinaryNode<T>();
			leftChild.setData(responseForNo);
		}
		else
		{
			/* Add code */ BinaryNode<T> newLeftChild = new BinaryNode<T>(responseForNo);
			/* Add code */ currentNode.setLeftChild(newLeftChild);
		} // end if

		if (currentNode.hasRightChild())
		{
			/* Add code */ BinaryNode<T> rightChild = new BinaryNode<T>();
			rightChild.setData(responseForYes);
		}
		else
		{
			/* Add code */ BinaryNode<T> newRightChild = new BinaryNode<T>(responseForYes);
			currentNode.setRightChild(newRightChild);
		} // end if
	} // end setResponses

	public boolean isAnswer()
	{
		if (currentNode != null)
			return currentNode.isLeaf();
		else
		 	return false;
	} // end isAnswer

	public void advanceToNo()
	{
      if (currentNode == null)
         throw new NullPointerException();
      else
		   currentNode = currentNode.getLeftChild();
	} // end advanceToNo
	
	public void advanceToYes()
	{
      if (currentNode == null)
         throw new NullPointerException();
      else
		   currentNode = currentNode.getRightChild();
	} // end advanceToYes
	
	public void resetCurrentNode()
	{
		currentNode = getRootNode();
	} // end resetCurrentNode
	
	protected BinaryNode<T> getCurrentNode()
	{
		return currentNode;
	} // end getCurrentNode
} // end DecisionTree
