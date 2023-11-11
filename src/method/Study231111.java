package method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Study231111 {
	public static void main(String[] args) {
		
		Study231111 doExcute = new  Study231111();
		
		//arrayTask01
		doExcute.arrayTask01();
		doExcute.listTask02();
	}
	
	/*
	 * 配列を利用してリストに格納する方法<br>
	 * 
	 */
	public void arrayTask01() {
		//配列を準備
		String[] array = new String[3];
		array[0] = "配列1番目";
		array[1] = "配列2番目";
		array[2] = "配列3番目";
		
		System.out.println(array[1]);
	}
	
	/*
	 * 配列(Array)からリスト(List)型へ変換する方法
	 */
	private void listTask02() {
		//配列を準備
		String[] array = new String[3];
		array[0] = "配列1番目";
		array[1] = "配列2番目";
		array[2] = "配列3番目";
		
		// 配列からリストへ変換
		List<String> listStrings = new ArrayList<>(Arrays.asList(array));
		
		// リスト型に追加
		listStrings.add("追加:配列4番目");
		
		System.out.println(listStrings.get(0));
		System.out.println(listStrings.get(3));
	}
}
