//*************************** SAKSHAM JAIN ****** 2017MT10747 *********************************** //

import java.io.*;
import java.util.Scanner;

public class linkedlist
{
	public Node start;
	public Node end ;
	public int size ;
	
	/*  Constructor  */
	public linkedlist()
	{   start = new Node();
		end = new Node();
		
		start = null;
		end = null;
		size = 0;
	}
	public int isMember(Object o)
	{  
		if(start == null)
		{
			return 0;
		}
		if(start.data.equals(o))
		{
			return 1;
		}
		Node curr = start;
		while(curr!=null)
		{
			if(curr.data.equals(o))
			{
				return 1;
			}
			curr = curr.link;
		}
		
		return 0;
		
	}
	/*  Function to check if list is empty  */
	public boolean isEmpty()
	{
		return start == null;
	}
	/*  Function to get size of list  */
	public int getSize()
	{
		return size;
	}    
	/*  Function to insert an element at begining  */
	public void insertAtStart(Object val)
	{
		Node nptr = new Node(val, null);    
		size++ ;    
		if(start == null) 
		{
			start = nptr;
			end = start;
		}
		else 
		{
			nptr.setLink(start);
			start = nptr;
		}
	}
	/*  Function to insert an element at end  */
	public void insertAtEnd(Object val)
	{
		Node nptr = new Node(val,null);    
		size++ ;    
		if(start == null) 
		{
			start = nptr;
			end = start;
		}
		else 
		{
			end.setLink(nptr);
			end = nptr;
		}
	}
	public int findpos(Object o)   // To find position of certain object (One-Based indexing)
	{
		
		if(start.data.equals(o))
		{
			return 0;
		}
		Node curr = start;
		int pos=0;     
		while(curr!=null)
		{
			if(curr.data.equals(o))
			{ 
				return pos;
			}
			else{
				curr=curr.link;
				pos++;
			}
			
		}
		return pos;
	}
	
	public void ll_delete(Object o)
	{ 
		int pos = findpos(o);
		deleteAtPos(pos);
		
	}
	
	/*  Function to delete an element at position  */
	public void deleteAtPos(int pos)
	{        
		if (pos == 1) 
		{
			start = start.getLink();
			size--; 
			return ;
		}
		if (pos == size) 
		{
			Node s = start;
			Node t = start;
			while (s != end)
			{
				t = s;
				s = s.getLink();
			}
			end = t;
			end.setLink(null);
			size --;
			return;
		}
		Node ptr = start;
		pos = pos - 1 ;
		for (int i = 1; i < size - 1; i++) 
		{
			if (i == pos) 
			{
				Node tmp = ptr.getLink();
				tmp = tmp.getLink();
				ptr.setLink(tmp);
				break;
			}
			ptr = ptr.getLink();
		}
		size-- ;
	}    
	
	
}
