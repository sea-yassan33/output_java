package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.CarDto;

public class MainCarTask {
	
static CarDto respForm = new CarDto();
	

	public static void main(String[] args) {
		
		CarDto carList = doExcute();
		
		if(carList.getCarMakerList().size() !=0) {
			System.out.println("メーカーの数：" + carList.getCarMakerList().size());
		}else {
			System.out.println("メーカーの登録はありません。" );
		}
		
		int mackerSize;
		
		mackerSize = makerStock();
		System.out.println(mackerSize + "社の登録があります。");
	}
	
	public static CarDto doExcute() {
		
		// マップに車種情報を設定
        Map<String, List<String>> carModelsData = new HashMap<>();
        carModelsData.put("AAA", Arrays.asList("Aロー", "Aウス"));
        carModelsData.put("BBB", Arrays.asList("Bック", "Bード"));
        respForm.setCarModels(carModelsData);
        
        //リストにメーカを設定
        List<String> carmakerList = new ArrayList<>();
        carmakerList.addAll(Arrays.asList("AAA", "BBB"));
        respForm.setCarMakerList(carmakerList);
        
        //車体の色
        List<String> carBodyColorList = new ArrayList<>();
        carBodyColorList.addAll(Arrays.asList("黒", "白", "銀"));
        respForm.setBodyColorList(carBodyColorList);
        
		return respForm;
	}
	
	private static int makerStock() {
		int nam = 0;
		
		if(nam == 0) {
			nam = respForm.getCarMakerList().size();
		}else {
			nam =0;
			nam = respForm.getCarMakerList().size();
		}
		return nam;
	}

}
