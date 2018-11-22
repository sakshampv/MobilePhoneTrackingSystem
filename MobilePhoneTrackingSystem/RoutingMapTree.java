import java.io.*;
import java.util.Scanner;

public class RoutingMapTree
{
	Exchange root;
	public RoutingMapTree()
	{
		root = new Exchange(0);
		root.parent = null;
		this.root.UID = 0;
	}
	
	Boolean containsNode(Exchange a)
	{
		int pp = postorder(this.root,a);
		if(pp!=0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	int postorder(Exchange a,Exchange searched)
	{  int flag =0;
		if(!(a.children.isEmpty()!=0))
		{
			Node curr = a.children.ll.start;
			while(curr!=null)
			{
				flag += postorder(((Exchange) curr.data),searched);
			}
		}
		if(a.UID==(searched).UID || (flag!=0))
		{
			return 1;
		}
		return 0;
	}
 
		
	
	public void switchOn(MobilePhone a, Exchange b) throws Exception
	{
		
			if(a.switchedOn == 1 || findMobileWithNumber(a.num)==null)
			{
				throw new Exception("Mobile either already switched on or not found");
				
			}
			int numm = a.num;
			MobilePhone new_mobile = new MobilePhone(numm);
			new_mobile.location = b;
			new_mobile.switchOn();
			b.mset.Delete(a);
			b.mset.Insert(new_mobile);
			b=b.parent;
			while(b!=null)
			{
				
				b.mset.Delete(a);
				b.mset.Insert(new_mobile);
				b=b.parent;
				
			}
			root.mset.Insert(new_mobile);
		}

		public void switchOnwithoutexception(MobilePhone a, Exchange b)
	{
			int numm = a.num;
			MobilePhone new_mobile = new MobilePhone(numm);
			new_mobile.location = b;
			new_mobile.switchOn();
			b.mset.Delete(a);
			b.mset.Insert(new_mobile);
			b=b.parent;
			while(b!=null)
			{
				
				b.mset.Delete(a);
				b.mset.Insert(new_mobile);
				b=b.parent;
				
			}
			root.mset.Insert(new_mobile);
		}
		
		
			public void switchOff(MobilePhone a) throws Exception
			{ 
				int numm = a.num;
				if(a.switchedOn == 0 || findMobileWithNumber(a.num)==null)
				{
					throw new Exception("Mobile either already switched off or not found");
					

				}
				this.root.mset.Delete1(a);
				Exchange new_location = new Exchange();
				new_location = a.location;
				MobilePhone new_mobile = new MobilePhone(numm);
				new_mobile.switchedOn = 0;
				new_mobile.location = new_location;
				this.root.mset.Insert(new_mobile);
				Exchange curr = new Exchange();
				curr = root;
				while(curr!=null)
				{
					Node curr2 = curr.children.ll.start;
					while(curr2!=null)
					{
						if(((Exchange)curr2.data).mset.IsMember(a))
						{
							((Exchange)curr2.data).mset.Delete1(a);
							((Exchange)curr2.data).mset.Insert(new_mobile);
							
						}
						curr2 = curr2.link;
					}
					if(curr2 != null)
					{
						curr=(Exchange)curr2.data;
					}
					if(curr2==null)
					{
						curr= null;
					}
				}
				
				
			}
			String output_string = new String();
		//	output_string = " ";
			
			public String performAction(String actionMessage)
			{    String msg="";
				  try {
				
				Scanner s=new Scanner (actionMessage);
				String a="",b="";
				
				msg=actionMessage;
				int a1,b1;
				String input_query="";
				if(s.hasNext())
				{input_query=s.next();}
				if(input_query.equals("addExchange"))
				{   
					if(s.hasNext())
					{a=s.next();}
					if(s.hasNext())
					{b=s.next();}
					a1 = Integer.parseInt(a);  
					b1 = Integer.parseInt(b);
					int par = a1;
					int chil = b1;
					Exchange new_child = new Exchange(chil);
					new_child.parent=(findExchangewithUID(this.root,par));
					(findExchangewithUID(this.root,par)).children.ll.insertAtEnd(new_child);
					return "";
					
					//this.root.children.ll.insertAtEnd(new_child);
					
				}
				if(input_query.equals("switchOnMobile"))
				{  
					
					if(s.hasNext())
					{a=s.next();}
					if(s.hasNext())
					{b=s.next();}
					a1 = Integer.parseInt(a);  
					b1 = Integer.parseInt(b);
					int mob = a1;
					int exc = b1;
					Exchange target_exchange = findExchangewithUID(this.root,exc);
					MobilePhone mp = new MobilePhone(0);
					mp = findMobileWithNumber(mob);
					if(mp==null)
					{
						mp = new MobilePhone(mob);
						mp.switchedOn =1;
						mp.location = target_exchange;
					}
					 if(target_exchange == null)
					 {
						 throw new Exception("Exchange not found");
						 }
						this.switchOnwithoutexception(mp,target_exchange);
					
						return "";
					}
					
					if(input_query.equals("switchOffMobile"))
					{
						
						if(s.hasNext())
						{a=s.next();}
						
						a1 = Integer.parseInt(a);  
						
						int mob = a1;
						
						MobilePhone mp = findMobileWithNumber(mob);
						 if(mp == null)
						 {
							throw new Exception("Mobile Phone not found");
						 }
						this.switchOff(mp);
						// MobilePhone new_mob = new MobilePhone(mob);
						// new_mob.location = mp.location;
						// new_mob.switchedOn = 0;

						// this.root.mset.Insert(new_mob);
						
						return "";
					}
					
					
					if(input_query.equals("queryNthChild"))
					{   
						if(s.hasNext())
						{a=s.next();}
						if(s.hasNext())
						{b=s.next();}
						a1 = Integer.parseInt(a);  
						b1 = Integer.parseInt(b);
						output_string = actionMessage;
				        output_string+= ": ";
						int parent_exchange = a1;
						int child_number = b1;
						Exchange parent_Exch = findExchangewithUID(this.root,parent_exchange);
						if(child_number >= parent_Exch.numChildren())
						{
							throw new Exception("Invalid child number");
						}
						Node curr = parent_Exch.children.ll.start;
						while((child_number--)!=0)
						{
							curr=curr.link;
						}
						//System.out.println(((Exchange)curr.data).UID);
						output_string +=String.valueOf( ((Exchange)curr.data).UID);
						return output_string;
					}
					
					if(input_query.equals("queryMobilePhoneSet"))
					{   
						if(s.hasNext())
						{a=s.next();}
						//	if(s.hasNext())
						//	{b=s.next();}
						a1 = Integer.parseInt(a);  
						//	b1 = Integer.parseInt(b);
						int exchange_identifier = a1;
						output_string = actionMessage;
				        output_string+= ": ";
						Exchange target_exchange = findExchangewithUID(this.root,exchange_identifier);
						 if(target_exchange == null)
						 {
							throw new Exception("Target exchange not found");
						 }
						Node curr = target_exchange.mset.ll.start;
						if(curr == null)
						{
							throw new Exception("Exchange has no mobiles");
						}
						output_string += String.valueOf(((MobilePhone)curr.data).num);
						curr = curr.link;
						while(curr!=null)
						{   if(((MobilePhone)curr.data).switchedOn == 1)
							{
							
                            output_string += ", ";
							output_string += String.valueOf(((MobilePhone)curr.data).num);
							}
							curr = curr.link;
						}
					    return output_string;
					} 
					   
					


					if(input_query.equals("findPhone"))
					{
						if(s.hasNext())
						{a=s.next();}
						
						a1 = Integer.parseInt(a);  
						int mob = a1;
				
						output_string = "queryFindPhone ";
						output_string +=a1;
						output_string +=": ";
						// System.out.print("Yaha pe aaya");
						 if(findMobileWithNumber(mob)==null || findMobileWithNumber(mob).switchedOn==0)
						 {
							 throw new Exception("No mobile phone with identifier "+mob+" found in the network");
						 }
						 // System.out.println(findPhone(findMobileWithNumber(mob))==null);
						if(findPhone(findMobileWithNumber(mob))==null)
						{   //System.out.println("Yaha pe aaya");
							throw new Exception("Mobile not found");
						}
						output_string+= "" + (findPhone(findMobileWithNumber(mob)).UID);
						return output_string;
					}
						
					if(input_query.equals("lowestRouter"))
					{
                        if(s.hasNext())
						{a=s.next();}
						if(s.hasNext())
						{b=s.next();}
						a1 = Integer.parseInt(a);  
						b1 = Integer.parseInt(b);
						output_string = "queryLowestRouter ";
						output_string += a1;
						output_string += " ";
						output_string += b1;
					
						output_string +=": ";
						//System.out.println(lowestRouter(findExchangewithUID(this.root, a1),findExchangewithUID(this.root, b1)).UID);
						//output_string = "";
						output_string+= "" + ( lowestRouter(  findExchangewithUID(this.root, a1)  ,  findExchangewithUID(this.root, b1)  )).UID;
						return output_string;
					}
					
					if(input_query.equals("findCallPath"))
					{
						if(s.hasNext())
						{a=s.next();}
						if(s.hasNext())
						{b=s.next();}
						a1 = Integer.parseInt(a);  
						b1 = Integer.parseInt(b);
						output_string = "queryFindCallPath ";
						output_string += a1;
						output_string += " ";
						output_string += b1;
						output_string +=": ";
						//System.out.println((findMobileWithNumber(b1)==null));
						ExchangeList el = new ExchangeList();
						if(findMobileWithNumber(a1)==null)
						{
							throw new Exception("No mobile phone with identifier "+a1+" found in the network");
						}
						if(findMobileWithNumber(a1).switchedOn==0)
						{
							throw new Exception("Mobile phone with identifier "+a1+" is currently switched off");
						}
						if(findMobileWithNumber(b1)==null)
						{
							throw new Exception("Mobile phone with identifier "+b1+" is currently switched off");
						}
						if(findMobileWithNumber(b1).switchedOn==0)
						{
							throw new Exception("Mobile phone with identifier "+b1+" is currently switched off");
						}
						el = routeCall(findMobileWithNumber(a1),findMobileWithNumber(b1));
						Node curr = new Node();
						curr = el.ll.start;
						if(curr==null)
						{
							throw new Exception("Route call empty");
						}
						output_string += String.valueOf(((Exchange)curr.data).UID);
						curr= curr.link;
						while(curr!=null)
						{   
							
							output_string += ", ";
							output_string += "" + (((Exchange)curr.data).UID);
							curr = curr.link;
						}
						return output_string;
					
					}
					   
					if(input_query.equals("movePhone"))
					{ 
						if(s.hasNext())
						{a=s.next();}
						if(s.hasNext())
						{b=s.next();}
						a1 = Integer.parseInt(a);  
						b1 = Integer.parseInt(b);
						movePhone(findMobileWithNumber(a1),findExchangewithUID(this.root,b1));
						output_string = "";
						return output_string;
					}
				  
				   
				} catch (Exception e) {
					//System.out.println("Exception");
					output_string += "Error - "+e.getMessage();
				}
				return output_string;
				}
				public MobilePhone findMobileWithNumber(int numm)
				{
					Node curr = root.mset.ll.start;
					//	System.out.println(curr==null);
					while(curr!=null)
					{
						if(((MobilePhone)curr.data).num == numm )
						{
							return (MobilePhone) curr.data;
						}
						curr=curr.link;
					}
					return null;
				}
				
				public Exchange findExchangewithUID(Exchange a,int UID)
				{
					
					if (a.UID==UID)
					{
						return a;
					}
					else
					{
						if(!(a.children.isEmpty()!=0))
						{
							Node curr = a.children.ll.start;
							while(curr!=null)
							{
								if(findExchangewithUID((Exchange)curr.data,UID)!=null)
								{
									return findExchangewithUID((Exchange)curr.data,UID);
								}
								curr=curr.link;
								
							}
							
						}
						else
						{
							return null;
						}
					}
					return null;
				}


              /* **********************
              *****************************
			  Assignment 2 functions are kept here 
			  *****************************
			  **************************** */

			  public Exchange findPhone(MobilePhone m) throws Exception
			  {
				  if(findMobileWithNumber(m.num)==null)
				  {
					 //throw new Exception("Mobile not found");
					 return null;
				  }
				  if(findMobileWithNumber(m.num).switchedOn == 0)
				  { 
					// throw new Exception("Mobile is switched off");
					return null;

				  }

				  return m.location;
			  }
				


			  public Exchange lowestRouter(Exchange a, Exchange b)
			  {
				  if(a.UID == b.UID)
				  {
					  return a;
				  }
				  while(a.UID != b.UID && (a!= null) && (b!=null))
				  {
					  a=a.parent;
					  b=b.parent;
					  if(a.UID == b.UID)
					  {
						  return a;
					  }
					  
				  }
				  return null;
			  }


			  public ExchangeList routeCall(MobilePhone a, MobilePhone b) throws Exception
			  { 
				  if(findMobileWithNumber(a.num)==null || findMobileWithNumber(b.num)==null || a.switchedOn==0 || b.switchedOn==0 )
				  {
					  throw new Exception("Mobile either switched off or not reachable");
				  }
				  
				if(a.num == b.num)
				{
					ExchangeList el = new ExchangeList();
					
					el.ll.insertAtEnd(a.location);
					return el;
				}
			
				 ExchangeList el = new ExchangeList();
				 Exchange exc = new Exchange();
				 exc = lowestRouter(a.location,b.location);
				 Exchange a_loc = new Exchange();
				 a_loc = a.location;
				 el.ll.insertAtEnd(a_loc);
				 while(a_loc.UID != exc.UID)
				 {
					 a_loc = a_loc.parent;
					 el.ll.insertAtEnd(a_loc);
				 }     
				 Exchange b_loc = new Exchange();
				 b_loc = b.location;
				 ExchangeList el2 = new ExchangeList();
				 el2.ll.insertAtStart(b_loc);
				 while(b_loc.UID != exc.UID)
				 {
					 b_loc = b_loc.parent;
					 el2.ll.insertAtStart(b_loc);
				 }  
                el2.ll.deleteAtPos(1);
				 while(!(el2.ll.isEmpty()))
				 {
				
					 el.ll.insertAtEnd(   ((Exchange) el2.ll.start.data)  );
					 el2.ll.deleteAtPos(1);
				 }
                 return el;
			  }




			  public void movePhone(MobilePhone a, Exchange b) throws Exception
			  {   
				  if(findMobileWithNumber(a.num)==null || findExchangewithUID(this.root,b.UID)==null)
				  {
					 throw new Exception("Mobile not found or Exchange not found");
				  }
				  if(a.switchedOn==0 || b.numChildren()!=0)
				  {
					   throw new Exception("Mobile switched off or invalid exchange");
				  }
				int numm = a.num;
				this.root.mset.Delete1(a);
				Exchange new_location = new Exchange();
				new_location = a.location;
				
				
				Exchange curr = new Exchange();
				curr = root;
				while(curr!=null)
				{
					Node curr2 = curr.children.ll.start;
					while(curr2!=null)
					{
						if(((Exchange)curr2.data).mset.IsMember(a))
						{
							((Exchange)curr2.data).mset.Delete1(a);
							
							
						}
						curr2 = curr2.link;
					}
					if(curr2 != null)
					{
						curr=(Exchange)curr2.data;
					}
					if(curr2==null)
					{
						curr= null;
					}

					a.location = b;
					a.switchedOn = 1;
					switchOnwithoutexception(a,b);
				}
				


			  }
		


			}




