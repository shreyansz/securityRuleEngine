package securityRuleEngine;

import static org.junit.Assert.*;

import org.junit.Test;

public class SecurityRuleEngineTest {

	@Test
	public void testMain() 
	{
		//fail("Not yet implemented");
	}

	@Test
	public void testDateWithinAWeek() 
	{
		assertTrue(SecurityRuleEngine.dateWithinAWeek("2014-12-17"));
		assertFalse(SecurityRuleEngine.dateWithinAWeek("2014-12-30"));
		assertFalse(SecurityRuleEngine.dateWithinAWeek("2014-12-03"));
	}

	@Test
	public void testDisplayRejectedMessage() 
	{
		assertEquals("Security rejected.", SecurityRuleEngine.displayRejectedMessage());
	}

	@Test
	public void testAcceptedIssuer() 
	{
		assertTrue(SecurityRuleEngine.acceptedIssuer("issuerTest"));
		assertFalse(SecurityRuleEngine.acceptedIssuer("dummy"));
	}
	
	@Test
	public void testIsValidDate() 
	{
		assertTrue(SecurityRuleEngine.isValidDate("2014-12-31"));
		assertFalse(SecurityRuleEngine.isValidDate("2014-14-34"));
	}
}
