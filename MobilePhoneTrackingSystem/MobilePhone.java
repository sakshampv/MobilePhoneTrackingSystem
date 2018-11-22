//*************************** SAKSHAM JAIN ****** 2017MT10747 *********************************** //

import java.io.*;
import java.util.Scanner;
public class MobilePhone
{
	int num = 0;
	int switchedOn = 1;
	Exchange location;
	MobilePhone(int number)
	{
		this.num= number;
		
	}
	public int number()
	{
		return num;
	}
	public Boolean status()
	{
		if(switchedOn == 1)
		{
			return true;
		}
		else
		{
			return false;
		}

	}
	public void switchOn()
	{
		this.switchedOn =1;
	}
	public void switchOff()
	{
		this.switchedOn = 0;
	}

	public Exchange location()
	{
		if(switchedOn==1)
		{
			return location;

		}
		else
		{
			// throw exception
		}
        return null;
	}

}
