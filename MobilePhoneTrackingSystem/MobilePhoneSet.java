//*************************** SAKSHAM JAIN ****** 2017MT10747 *********************************** //

import java.io.*;
import java.util.Scanner;

public class MobilePhoneSet
{  
	linkedlist ll;

	public MobilePhoneSet()
	{
		ll = new linkedlist();
	}
	
	public Boolean IsEmpty()
	{
		return ll.isEmpty();
	}
	public Boolean IsMember(Object o) 
	{
		
		if(ll.isMember(o)==1)
		{    return true;
		}
		else
		{
			return false;
		}
	}
	
	public void Insert(Object o)
	{ 
		 if(ll.isMember(o)==0)
		{
			ll.insertAtEnd(o);
		}
		
	}
	
	public void Delete1(Object o)
	{  
	
	Node curr12=new Node();
	Node curr13=new Node();
	curr12 = this.ll.start;
	curr13 = this.ll.start;
	curr13= curr13.link;
	
	if(((MobilePhone)curr12.data).num == ((MobilePhone)o).num)
	{
		this.ll.start = this.ll.start.link;
		
		return;
	}
	
	while(curr13!=null)
	{
		if(((MobilePhone)curr13.data).num ==(((MobilePhone)o).num) )
		{ 
			curr12.link = curr13.link;
			return;
			
			
		}
		curr12 = curr12.link;
		curr13 = curr13.link;
	}
	
		}
		public void Delete(Object o)
		{  
		
		Node curr12=new Node();
		curr12 = this.ll.start;
		while(curr12!=null)
		{
			if(((MobilePhone)curr12.data).num ==(((MobilePhone)o).num) )
			{  
			ll.ll_delete(o);
		}
		curr12 = curr12.link;
	}
	
		}
		public MobilePhoneSet Union(MobilePhoneSet a)
		{
			Node curr = a.ll.start;
			while(curr!=null)
			{   
				this.Insert(curr.data);
				curr=curr.link;
			}
			return this;
		}
		public MobilePhoneSet Intersection(MobilePhoneSet a)
		{
			Node curr = a.ll.start;
			MobilePhoneSet inter = new MobilePhoneSet();
			while(curr!=null)
			{
				if(this.ll.isMember(curr.data)==1)
				{
					inter.Insert(curr.data);
				}
				curr= curr.link;
			}
			return inter;
		}
	}