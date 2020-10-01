package najah.edu.app;

import java.util.List;

public class Home {
	private int id;
    private int area;
    private int price;
    private int no_of_bedrooms;
    private int no_of_bathrooms;
    private int lease_length;
    private HomePlacement placement;
    private HomeType type;
    private HomeMaterial material;
    private List<HomeAmenities> amenities;
    private HomePets pet;
    
	public Home(int id, int area, int price,  int no_of_bedrooms, int no_of_bathrooms,int lease_length,
			HomePlacement placement, HomeType type, HomeMaterial material, List<HomeAmenities> amenities,
			HomePets pet) {
		super();
		this.id = id;
		this.area = area;
		this.price = price;
		this.no_of_bathrooms = no_of_bathrooms;
		this.no_of_bedrooms = no_of_bedrooms;
		this.lease_length = lease_length;
		this.placement = placement;
		this.type = type;
		this.material = material;
		this.amenities = amenities;
		this.pet = pet;
	}

	@Override
	public String toString() {
		return "Home [id=" + id + ", area=" + area + ", price=" + price + ", no_of_bedrooms=" + no_of_bedrooms
				+ ", no_of_bathrooms=" + no_of_bathrooms + ", lease_length=" + lease_length + ", placement=" + placement
				+ ", type=" + type + ", material=" + material + ", amenities=" + amenities + ", pet=" + pet + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNo_of_bedrooms() {
		return no_of_bedrooms;
	}

	public void setNo_of_bedrooms(int no_of_bedrooms) {
		this.no_of_bedrooms = no_of_bedrooms;
	}

	public int getNo_of_bathrooms() {
		return no_of_bathrooms;
	}

	public void setNo_of_bathrooms(int no_of_bathrooms) {
		this.no_of_bathrooms = no_of_bathrooms;
	}

	public int getLease_length() {
		return lease_length;
	}

	public void setLease_length(int lease_length) {
		this.lease_length = lease_length;
	}

	public HomePlacement getPlacement() {
		return placement;
	}

	public void setPlacement(HomePlacement placement) {
		this.placement = placement;
	}

	public HomeType getType() {
		return type;
	}

	public void setType(HomeType type) {
		this.type = type;
	}

	public HomeMaterial getMaterial() {
		return material;
	}

	public void setMaterial(HomeMaterial material) {
		this.material = material;
	}

	public List<HomeAmenities> getAmenities() {
		return amenities;
	}

	public void setAmenities(List<HomeAmenities> amenities) {
		this.amenities = amenities;
	}

	public HomePets getPet() {
		return pet;
	}

	public void setPet(HomePets pet) {
		this.pet = pet;
	}
	
	

	
    
    
    
    
}
