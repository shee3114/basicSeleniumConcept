package June.June;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderConceptExample {

	@Test(dataProvider = "inputProvider", priority = 1)
	public void testMethod(String firstName, String lastName) {

		System.out.println("First Name is: " + firstName + " and Last Name is: " + lastName);
	}

	@Test(dataProvider = "multipleInput", priority = 2)
	public void testMethod1(String Person, String color, int birthDate, String month, String birthYear) {
		System.out.println("Favourite color of " + Person + ": " + color + " and birthdate is: " + birthDate + ","
				+ month + " " + birthYear);
	}

	@DataProvider(name = "inputProvider")
	public Object[][] getData() {
		return new Object[][] { { "Sheetal", "Desai" }, { "Snehal,", "Desai" }, { "Suyash", "Desai" },
				{ "Kaushalya", "Desai" } };
	}

	@DataProvider(name = "multipleInput")
	public Object[][] getListOfData() {
		return new Object[][] {

				{ "Me", "Red", 8, "August", "1994" }, { "Neha", "Black", 8, "January", "1997" },
				{ "Suyash", "Yellow", 25, "August", "2001" }, { "Mummy", "White", 29, "May", "1774" } };
	}
}
