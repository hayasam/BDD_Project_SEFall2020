package najah.edu.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class FinderApp {

	private static List<Home> repository;
	private static Map<String, String> feature_repository = new HashMap<String, String>();
	//private static EmailService emailservice;
	public static List<Home> priceList;
//	private EmailService actualEmailService;
//	
//	public void setEmailservice(EmailService emailservice) {
//		this.emailservice = emailservice;
//	}
//


	public Map<String, String> getProp_repository() {
		return feature_repository;
	}



	public static List<Home> getRepository() {
		return repository;
	}



	public void setProp_repository(Map<String, String> prop_repository) {
		this.feature_repository = prop_repository;
	   createRepositoryFromFeatureRepository();
	}



	public FinderApp() {
		repository = new ArrayList<Home>();
		actualEmailService=new EmailService();

	}

	public void createRepositoryFromFeatureRepository() {
		// java 1.8

		String currentKey;
		String currentValue;
		Iterator it = feature_repository.entrySet().iterator();
		int id = 0;
		int price, area,noOfbedrooms,noOfbathrooms,leaseLength;
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			// price-area-bedrooms-bath-leaselength
			currentValue = (String) pair.getValue();
			String AofInt[] = currentValue.split("_");
			
			price=Integer.parseInt(AofInt[0]);
			area=Integer.parseInt(AofInt[1]);
			noOfbedrooms=Integer.parseInt(AofInt[2]);
		    noOfbathrooms=Integer.parseInt(AofInt[3]);
			leaseLength=Integer.parseInt(AofInt[4]);
			// type-material-placement-pets-listof amenities
			currentKey = (String) pair.getKey();
			String ar[] = currentKey.split("_");
			HomeType type=checkType(ar[0]);
			HomeMaterial material=checkMaterial(ar[1]);
			HomePlacement placement=checkPalcement(ar[2]);
			HomePets pet=checkPets(ar[3]);
			String arrayOfAmenities[] = ar[4].split(",");
			List<HomeAmenities> listOfAmenities=new ArrayList<HomeAmenities>();
			
			for(String amenity: arrayOfAmenities) {
				HomeAmenities amen = checkHomeAmenities(amenity);
				listOfAmenities.add(amen);
			}
			
			repository.add(new Home(id,  area,  price,   noOfbedrooms,noOfbathrooms,leaseLength,
					                 placement,  type,  material,  listOfAmenities,  pet));
			id += 1;
			// it.remove(); // avoids a ConcurrentModificationException
		}
		
		
		printRepository();
	}

	private HomeMaterial checkMaterial(String material) {
		if (material.equals(HomeMaterial.BRICK.toString()))
			return HomeMaterial.BRICK;
		else if (material.equals(HomeMaterial.STONE.toString()))
			return HomeMaterial.STONE;
		else if (material.equals(HomeMaterial.WOOD.toString()))
			return HomeMaterial.WOOD;
		else
			return null;
	}
	private HomeAmenities checkHomeAmenities(String amenity) {
		if (amenity.equals(HomeAmenities.AIRCONDITIONING.toString()))
			return HomeAmenities.AIRCONDITIONING;
		else if (amenity.equals(HomeAmenities.BALCONY.toString()))
			return HomeAmenities.BALCONY;
		else if (amenity.equals(HomeAmenities.ELEVATOR.toString()))
			return HomeAmenities.ELEVATOR;
		else if (amenity.equals(HomeAmenities.FIREPLACE.toString()))
			return HomeAmenities.FIREPLACE;
		else if (amenity.equals(HomeAmenities.GARAGEPARKING.toString()))
			return HomeAmenities.GARAGEPARKING;
		else if (amenity.equals(HomeAmenities.SWIMMINGPOOL.toString()))
			return HomeAmenities.SWIMMINGPOOL;
		else
			return null;
	}
	private HomePets checkPets(String pet) {
		if (pet.equals(HomePets.YES.toString()))
			return HomePets.YES;
		else if (pet.equals(HomePets.NO.toString()))
			return HomePets.NO;
		
		else
			return null;
	}

	private HomeType checkType(String type) {
		// TODO Auto-generated method stub
		if (type.equals(HomeType.HOUSE.toString()))
			return HomeType.HOUSE;
		else if (type.equals(HomeType.APARTMENT.toString()))
			return HomeType.APARTMENT;
		else
			return null;
	}

	private HomePlacement checkPalcement(String place) {
		if (place.equals(HomePlacement.VILLAGE.toString()))
			return HomePlacement.VILLAGE;
		else if (place.equals(HomePlacement.CITY.toString()))
			return HomePlacement.CITY;
		else
			return null;
	}

	private void printRepository() {
		for (Home p : repository) {
			System.out.println(p);
		}

	}



	public List<Home> byType(String spec) {
		List<Home> foundEstates = new ArrayList<Home>();
		Iterator<Home> it = repository.iterator();
		while (it.hasNext()) {
			Home estate = it.next();
			if (estate.getType().equals(checkType(spec)))
				foundEstates.add(estate);
		}
		return foundEstates;
		
	}

	


	public List<Home> byMaterial(String material) {
		List<Home> foundEstates = new ArrayList<Home>();
		Iterator<Home> it = repository.iterator();
		while (it.hasNext()) {
			Home estate = it.next();
			if (estate.getMaterial().toString().equals(material))
				foundEstates.add(estate);
		}
		
		
		return foundEstates;
		
	}



	public List<Home> byPlacement(String spec) {
		return null;
		// TODO Auto-generated method stub
		
	}



	public List<Home> byPrice(Integer price) {
		List<Home> foundEstates = new ArrayList<Home>();
		Iterator<Home> it = repository.iterator();
		while (it.hasNext()) {
			Home estate = it.next();
			if (estate.getPrice()<price)
				
				foundEstates.add(estate);
		}
		
		// send actual email
		//actualEmailService.sendEmail("haya.sammaneh@gmail.com", foundEstates);
		//==============================
		// just to make it public to test class
		priceList=foundEstates;
		// using mock object
	   // emailservice.sendEmail("haya.sammaneh@gmail.com", foundEstates);
	  //  emailservice.sendEmail("h2@najah.edu", foundEstates);
		return foundEstates;
	}

	

}
