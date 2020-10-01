package najah.edu.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.RepositoryIdHelper;

public class MainApp {

	private static FinderApp finder;
	private static Map<String, String> repository;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		finder=new FinderApp();
		repository=new HashMap<String, String>();
		repository.put("HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR" , "510_150_3_2_6");
		repository.put("APARTMENT_BRICK_CITY_NO_ELEVATOR" , "230_120_4_1_12");
		repository.put("APARTMENT_BRICK_VILLAGE_NO_SWIMMINGPOOL" , "100_120_4_2_6");
		repository.put("HOUSE_STONE_VILLAGE_NO_SWIMMINGPOOL" , "150_120_3_2_12");
		
		finder.setProp_repository(repository);
		//ArrayList<Home> lis=(ArrayList<Home>) FinderApp.getRepository();
	ArrayList<Home> lis=(ArrayList<Home>) finder.byPrice(150);
		
		for(Home h:lis) {
			System.out.println(h);
		}
		

	}

}
