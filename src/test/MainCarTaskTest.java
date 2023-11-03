package test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dto.CarDto;
import main.MainCarTask;

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

}
