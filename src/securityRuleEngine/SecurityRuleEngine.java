package securityRuleEngine;

import java.util.Scanner;
import org.joda.time.Days;
import org.joda.time.LocalDate;

public class SecurityRuleEngine 
{
	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		try 
		{ 
			System.out.println("Enter selection number: 1. Equity 2. Bond");
			int a = reader.nextInt();
			while (0 >= a || 2 < a) 
			{
				System.out.println("Invalid input, try again");
				a = reader.nextInt();
			}
			String displayStr = "Enter next due date (YYYY-MM-DD) for ";
			displayStr += (1 == a) ? "dividend" : "coupon";
			System.out.println(displayStr);
			String dueDate = reader.nextLine();
			while( ! isValidDate(dueDate) )
			{
				if( 0 < dueDate.length())
				{
					System.out.println("Invalid date, try again");
				}
				dueDate = reader.nextLine();
			}
			if( dateWithinAWeek(dueDate) )
			{
				System.out.println(displayRejectedMessage());
			}
			else
			{
				System.out.println("Enter Issuer Name");
				if( ! acceptedIssuer(reader.nextLine()) )
				{
					System.out.println(displayRejectedMessage());
				}
				else
				{
					System.out.println("Security Accepted!");
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			reader.close();
		}
	}
	public static boolean dateWithinAWeek(String dueDateString) 
	{
		LocalDate dueDate = new LocalDate(dueDateString);
		LocalDate curDate = new LocalDate();
		if ( curDate.isAfter(dueDate) || 7 < Days.daysBetween(curDate, dueDate).getDays()) 
		{
			return false;
		}
		return true;
	}
	public static boolean isValidDate(String dateString)
	{
		if ( null == dateString || ! dateString.matches("^(\\d{4})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$"))
		{
	        return false;
		}
		return true;
	}
	public static String displayRejectedMessage()
	{
		return "Security rejected.";
	}
	public static boolean acceptedIssuer(String issuer)
	{
		String[] issuerArr = {"issuerTest", "issuerDummy", "issuerSample"};
		for(String s : issuerArr)
		{
			if(s.equalsIgnoreCase(issuer))
			{
				return true;
			}
		}
	return false;
	}
}