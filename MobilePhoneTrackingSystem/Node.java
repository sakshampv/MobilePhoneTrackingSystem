//*************************** SAKSHAM JAIN ****** 2017MT10747 *********************************** //

import java.io.*;
import java.util.Scanner;
/*  Class Node  */
public class Node
{
	public Object data;
	public Node link;
	
	/*  Constructor  */
	public Node()
	{  data = new Object();
		link = null;
		data = 0;
	}    
	/*  Constructor  */
	public Node(Object d,Node n)
	{    data = new Object();
		data = d;
		link = n;
	}    
	/*  Function to set link to next Node  */
	public void setLink(Node n)
	{
		link = n;
	}    
	/*  Function to set data to current Node  */
	public void setData(Object d)
	{
		data = d;
	}    
	/*  Function to get link to next node  */
	public Node getLink()
	{
		return link;
	}    
	/*  Function to get data from current Node  */
	public Object getData()
	{
		return data;
	}
}