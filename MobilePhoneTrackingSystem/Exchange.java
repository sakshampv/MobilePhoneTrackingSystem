//*************************** SAKSHAM JAIN ****** 2017MT10747 *********************************** //

import java.io.*;
import java.util.Scanner;

public class Exchange
{  
	int UID;
	Exchange parent;
	MobilePhoneSet mset = new MobilePhoneSet();
	ExchangeList children = new ExchangeList();
	
	Exchange()
	{
		
		mset = new MobilePhoneSet();
		children = new ExchangeList();
		parent = null;
		this.UID = 0;
		
	}
	Exchange(int number)
	{   parent = new Exchange();
		mset = new MobilePhoneSet();
		parent = null;
		children = new ExchangeList();
		this.UID = number;
		
	}
	public int numChildren()
	{
		Node curr = this.children.ll.start;
		int childnum=0;
		while(curr!=null)
		{
			childnum++;
			curr=curr.link;
		}
		return childnum;
		
		
	}
	public Exchange child(int i)
	{      
		Node curr = this.children.ll.start;
		while((i--)!=0)
		{
			curr=curr.link;
		}
		return (Exchange) curr.data;
	}
	public Boolean isRoot()
	{
		if(this.parent == null)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public RoutingMapTree subtree(int i)
	{  
	   Exchange new_exc = new Exchange();
	   new_exc = this.child(i);
	   RoutingMapTree rmt = new RoutingMapTree();
	   rmt.root = new_exc;
		return rmt; 
	}
	public MobilePhoneSet residentSet()
	{
	 	return this.mset;
		
	}
	
}
