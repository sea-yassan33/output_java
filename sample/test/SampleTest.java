package test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import org.junit.Test;

import main.Sample;

public class SampleTest {

	/**
	 * privateインスタンス変数のテスト<br>
	 * 
	 * <対象＞<br>
	 * private String strValue = null;
	 */
	@Test
	public void testPraivateInstans01() throws Exception{
		String testValue = "test";
		Sample testee = new Sample();
		
		//初期値の確認
		assertNull(testee.getStrValue());
		
		//private変数のフィールドを取得
		Field field = testee.getClass().getDeclaredField("strValue");
		// private変数へのサクセス制限を解除
		field.setAccessible(true);
		// private変数に値を設定
		field.set(testee, testValue);
		
		// private変数を確認
		String result = String.valueOf(field.get(testee));
		//strValueStaticに値が入っていること
		assertThat(result, is(testValue));
		//getStrValue()メソッドで値が取得できる事
		assertThat(testee.getStrValue(), is(testValue));
	}
	
	/**
	 * privateクラス変数の設定・参照<br>
	 * staticの場合、特定インスタンスの中身を変えるわけではないので<br>
	 * 値の設定時に第一引数をnullに設定<br>
	 * 
	 * ＜対象＞<br>
	 * private static String strValueStatic = null;
	 */
	@Test
	public void testPraivateStatic02() throws Exception {
		String testValue = "test";
		
		//初期値の確認
		assertNull(Sample.getStrValueStatic());
		
		// private変数のフィールドを取得
		Field field = Sample.class.getDeclaredField("strValueStatic");
		// private変数へのアクセス制限を解除
		field.setAccessible(true);
		// private変数に値を設定
		field.set(null, testValue);
		
		//private変数を確認
		String actual = String.valueOf(field.get(null));
		assertThat(actual, is(testValue));
		assertThat(Sample.getStrValueStatic(), is(testValue));
		
	}
	
	/**
	 * 3.動的privateクラスのインスタンス変数<br>
	 * クラスローダー経由でコンストラクタを取得<br>
	 * 完全修飾名の外側のクラス$インナークラスを指定<br>
	 * インナークラスのオブジェクトを取得した後は、前述と同様にフィールドを取得
	 * 
	 * 【対象】<br>
	 * private InnerDynamic innerDynamic = null;
	 */
	@Test
	public void testDyanamicInnerClass03() throws Exception{
		String testValue = "test";
		Sample testee = new Sample();
		
		// 初期値の確認
        assertNull(testee.getDynamicInnerPrivate());
        
        // インナークラスのオブジェクトを取得
        Class innerClazz = Class.forName("main.Sample$InnerDynamic");
        Constructor constructor = innerClazz.getDeclaredConstructor(new Class[] {Sample.class});
        constructor.setAccessible(true);
        Object inner = constructor.newInstance(testee);
        
        // インナークラスのprivate変数のフィールドを取得
        Field field = inner.getClass().getDeclaredField("iStrValue");
        field.setAccessible(true);
        field.set(inner, testValue);
        
        // 外側のクラスのインナークラスを保持するフィールドを取得
        Field outerFld = testee.getClass().getDeclaredField("innerDynamic");
        outerFld.setAccessible(true);
        outerFld.set(testee, inner);
        
        //private変数を確認
        String actual = String.valueOf(field.get(inner));
        assertThat(actual, is(testValue));
        assertThat(testee.getDynamicInnerPrivate(), is(testValue));
        
	}

}
