package test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dto.CarDto;
import main.MainCarTask;
import mockit.Mock;
import mockit.MockUp;

public class MainCarTaskTest {
	private MainCarTask action;
	
	@Before
	public void setUp() {
		action = new MainCarTask();  
	}
	
	@Test
	public void testDoExcute() throws Exception{
		
		CarDto resultTest = action.doExcute();
		
		//レスポンスフォームの中身が空でないこと
		assertNotNull(resultTest);
		assertNotNull(resultTest.getCarModels());
		assertNotNull(resultTest.getCarMakerList());
		assertNotNull(resultTest.getBodyColorList());
		
		//CarMakerListのリストの中身が2つ格納されていること
		assertEquals(2, resultTest.getCarMakerList().size());
		
		//AAAをキーにしたリストの中に２つある事
		assertThat(resultTest.getCarModels().get("AAA").size(), is(2));
		
	}
	
	@Test
	public void testMakerStock02() throws Exception{
		
		MainCarTask action = new MainCarTask();

		new MockUp<CarDto>() {
			@Mock
			public List<String> getCarMakerList() {
				List<String> carMakerList = new ArrayList<>();
				carMakerList.add("test1");
				carMakerList.add("test2");
				return carMakerList;
			}
		};
		
		// 初期値の確認
		Integer resultInt = action.makerStock();
		
		assertNotNull(resultInt);
		assertThat(resultInt, is(2));
		
	}
}
