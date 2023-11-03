package dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarDto {
	
	private List<String> carMakerList = null;
	private Map<String, List<String>> carModels = new HashMap<>();
	private List<String> bodyColorList = null;
	
	
	public void setCarMakerList(List<String> carMakerList) {
		this.carMakerList = carMakerList;
	}
	public List<String> getCarMakerList() {
		return carMakerList;
	}
	
	public void setCarModels(Map<String, List<String>> carModels) {
		this.carModels = carModels;
	}
	public Map<String, List<String>> getCarModels() {
		return carModels;
	}
	
	public void setBodyColorList(List<String> bodyColorList) {
		this.bodyColorList = bodyColorList;
	}
	public List<String> getBodyColorList() {
		return bodyColorList;
	}

}
