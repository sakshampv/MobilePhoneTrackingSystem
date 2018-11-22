//*************************** SAKSHAM JAIN ****** 2017MT10747 *********************************** //

import java.io.*;
import java.util.Scanner;

public class ExchangeList
{
    linkedlist ll = new linkedlist();
	public ExchangeList()
	{
		ll = new linkedlist();

	}
    public int isEmpty()
    {
    	if(this.ll.isEmpty())
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

}