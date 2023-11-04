package test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dto.CarDto;
import main.MainCarTask;
import mockit.Mock;
import mockit.MockUp;

public class MainCarTaskTest00 {
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
		CarDto testDto = new CarDto();
		
		new MockUp<CarDto>() {
			@Mock
			public List<String> setCarMakerList() {
				List<String> carMakerList = new ArrayList<>();
				carMakerList.add("test1");
				carMakerList.add("test2");
				return carMakerList;
			}
		};
		
		//メソッドの取得
		Method testMethod = action.getClass().getDeclaredMethod("makerStock");
		testMethod.setAccessible(true);
		
		//private変数のフィールドを取得
		Field field = action.getClass().getDeclaredField("respForm");
		// private変数へのアクセス制限を解除
		field.setAccessible(true);
		// private変数に値を設定
		field.set(action, new CarDto());
		
		//Integer result = (Integer)testMethod.invoke(action);
		//System.out.println(result);
	
	}
	
	@Test
	public void test() { // MockUp<T>で定義するので、引数は削除する。あるとエラーになる
		new MockUp<BufferedReader>() {
			@Mock
			public String readLine() throws IOException{
				throw new IOException();
			}
		};
	}

}
