package najah.edu.acceptance_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.mockito.Mockito;

import io.cucumber.datatable.internal.difflib.myers.MyersDiff;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.app.EmailService;
import najah.edu.app.FinderApp;
import najah.edu.app.Home;
import najah.edu.app.HomeMaterial;
import najah.edu.app.HomePlacement;
import najah.edu.app.HomeType;
import najah.edu.app.MockEmailHolder;

public class SearchHomeSteps {

	private static FinderApp finder;
	private MockEmailHolder mh;
	private  List<Home> byMaterialList;
	private static List<Home> byTypeList;
	private List<Home> byPlacementList;
	private List<Home> byPriceList;
	private String spec;
	private int price;
	

	// dependency Injection
	public SearchHomeSteps(FinderApp finder,MockEmailHolder meh) {
		this.finder = finder;
		mh=meh;
	}
	
	// Each scenario call this step---- we need to make some repositories static

	@Given("these homes are contained in the system")
	public void theseHomesAreContainedInTheSystem(Map<String, String> feature_repository) {
		if (finder.getProp_repository().size() == 0) {
			finder.setProp_repository(feature_repository);
		}
	}
	
	

	
	

	@When("I search about home by {string}")
	public void iSearchAboutHomeBy(String spec) {
		this.spec = spec;
		if (spec.equals(HomeType.APARTMENT.toString()) || spec.equals(HomeType.HOUSE.toString())) {
			byTypeList = finder.byType(spec);
		} else if (spec.equals(HomeMaterial.BRICK.toString()) || spec.equals(HomeMaterial.WOOD.toString())
				|| spec.equals(HomeMaterial.STONE.toString())) {
			byMaterialList = finder.byMaterial(spec);
		} else if (spec.equals(HomePlacement.CITY.toString()) || spec.equals(HomePlacement.VILLAGE.toString())) {
			byPlacementList = finder.byPlacement(spec);
		}

	}

	@Then("A list of homes that matches the  type specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheTypeSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		Iterator<Home> it = byTypeList.iterator();
		if (spec.equals(HomeType.APARTMENT.toString())) {
			assertEquals("found 2 Apartments homes", 2, byTypeList.size());
			while (it.hasNext()) {
				assertTrue(it.next().getType().APARTMENT.toString().equals(spec));
			}

		}

		else if (spec.equals(HomeType.HOUSE.toString()))

		{
			assertEquals("found 1 House homes", 1, byTypeList.size());
			while (it.hasNext()) {
				assertTrue(it.next().getType().HOUSE.toString().equals(spec));
			}

		}

	}

	@When("I search about home with price less than {int}")
	public void iSearchAboutHomeWithPriceLessThan(Integer pricee) {
		price = pricee.intValue();
		byPriceList = finder.byPrice(price);
	}

	@Then("A list of homes that matches the price specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesThePriceSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
	
		assertEquals("found 2  homes", 3, byPriceList.size());
		Iterator<Home> it = byPriceList.iterator();
		while (it.hasNext()) {
			Home h = it.next();
			assertTrue(h.getPrice() < price);
		}

	}

	@Then("A list of homes that matches the  material specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheMaterialSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("\n\n"+byMaterialList);
		
		
	   
		Iterator<Home> it = byMaterialList.iterator();

		if (spec.equals(HomeMaterial.WOOD.toString())) {
			assertEquals("found 1 Wood homes", 1, byMaterialList.size());
			while (it.hasNext()) {
				assertTrue(it.next().getMaterial().WOOD.toString().equals(spec));
				//verify(emailservice,times(1)).sendEmail("hayasam@najah.edu", "By materiallllllllllllllll");
			}

		}

		else if (spec.equals(HomeMaterial.STONE.toString()))

		{
			assertEquals("found 1 STONE homes", 1, byMaterialList.size());
			while (it.hasNext()) {
				assertTrue(it.next().getMaterial().STONE.toString().equals(spec));
				// verify(emailservice,times(1)).sendEmail("hayasam@najah.edu", "anysubject");
			}

		} else if (spec.equals(HomeMaterial.BRICK.toString()))

		{
			assertEquals("found 2 Brick homes", 2, byMaterialList.size());
			while (it.hasNext()) {
				assertTrue(it.next().getMaterial().BRICK.toString().equals(spec));
				 //verify(emailservice,times(1)).sendEmail("hayasam@najah.edu", "anysubject");
			}

		}

	}

	@Then("A list of homes that matches the  placement specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesThePlacementSpecificationShouldBeReturnedAndPrintedOnTheConsole() {

	}

	@When("I search about home with area less than {int}")
	public void iSearchAboutHomeWithAreaLessThan(Integer area) {

	}

	@Then("A list of homes that matches the area specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheAreaSpecificationShouldBeReturnedAndPrintedOnTheConsole() {

	}
	
	
		@Then("email with the result should be send to user {string}")
		public void emailWithTheResultShouldBeSendToUser(String email) {
			verify(mh.getEmailService(),times(1)).sendEmail(email, FinderApp.priceList);
		 
		}


			@Then("email with the result should be send to user {string} and {string}")
			public void emailWithTheResultShouldBeSendToUserAnd(String email1, String email2) {
				verify(mh.getEmailService(),times(1)).sendEmail(email1, FinderApp.priceList);
				verify(mh.getEmailService(),times(1)).sendEmail("h2@najah.edu", FinderApp.priceList);
			}




}
