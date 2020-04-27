package Demo_FoodOrder.FoodOrder;

import java.io.Console;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.framework.general.Base;
import com.framework.pages.HelpPage;
import com.framework.pages.OrderPage;

public class FoodOrdertest extends Base {
		
		OrderPage orderPage;
		HelpPage  helpPage;
		

		
		public FoodOrdertest() {
			super();
		}
		
		
		@BeforeMethod()
		public void setup()
		{
			initialization();
			orderPage = new OrderPage();
			
		}
		
		@Test(priority=1)
		public void Sortsearch() throws Exception 
		{
			orderPage.searchbest();
		}
		
	@Test(priority=2)
		public void orderingfood() throws Exception 
		{
			orderPage.EnterPin();
		}
		@Test(priority=3)
		public void VerifyTitle() throws Exception 
		{
			String title = orderPage.title();
			Assert.assertEquals(title, "Restaurants and takeaways in Area51, AR51 | Just Eat");
		}
		
	@Test(priority=4)
				public void ClickHelp() throws Exception 
				{
					helpPage = orderPage.Help();
					try
					{
					  Assert.assertTrue(verifyTextPresent("Due to the impact from COVID-19 (Coronavirus), wait times to speak with our Customer Care team are longer than normal"));
					  System.out.println("Due to the impact from COVID-19 (Coronavirus), wait times to speak with our Customer Care team are longer than normal is present on the home page");
					}
					catch (Exception e)
					{
						 System.out.println("Covid is not present on the home page");
					}
					
					
				}
	
			@Test(priority=5)
			public boolean verifyTextPresent(String value) throws Exception
			{
				helpPage = orderPage.Help();
				
			  driver.getPageSource().contains(value);
		
		
				try
				{
				  Assert.assertTrue(verifyTextPresent("Due to the impact from COVID-19 (Coronavirus), wait times to speak with our Customer Care team are longer than normal"));
				  System.out.println("Due to the impact from COVID-19 (Coronavirus), wait times to speak with our Customer Care team are longer than normal is present on the home page");
				}
				catch (Exception e)
				{
					 System.out.println("Covid is not present on the home page");
				}
				return false;
			}	
			
			@AfterMethod()
				public void tearDown()
				{
					driver.close();
				}
		
		
	
	}
