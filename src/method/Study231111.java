package method;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Study231111 {
	public static void main(String[] args) throws Exception {
		
		Study231111 doExcute = new  Study231111();
		
		//arrayTask01
//		doExcute.arrayTask01();
		doExcute.listTask02();
//		doExcute.listTask03();
		doExcute.mapTask05();
//		doExcute.mapTask06();
//		doExcute.mapTask07();
//		doExcute.scanTask08();
//		doExcute.bufferTask09();
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
	
	/*
	 * 一度にリストに格納する方法
	 */
	private void listTask03() {
		
		//リストの作成
		ArrayList<String> listStr = new ArrayList<>(Arrays.asList("配列1","配列2","配列3"));
		
		System.out.println(listStr.get(1));
	}
	
	/*
	 * Mapの格納方法
	 */
	private void mapTask05() {
		Map<String, Integer> map = new HashMap<>();
		
		//// キーと値のペアを追加
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("a", 4);
		
		System.out.println(map);
	}
	
	/*
	 * Mapの格納方法2
	 * 
	 */
	private void mapTask06() {
		Map<String, List<Integer>> map = new HashMap<>();
		
		//配列を作成して値を格納
		ArrayList<Integer> listA = new ArrayList<>(Arrays.asList(1,2,3));
		//mapに配列を格納する。
		map.put("aList", listA);
		
		//配列を作成して値を格納
		ArrayList<Integer> listB = new ArrayList<>(Arrays.asList(5,6,7));
		//mapに配列を格納する。
		map.put("bList", listB);
		
		//aListを出力
		System.out.println(map.get("aList"));
		
	}
	
	/*
	 * Mapの格納方法3
	 */
	private void mapTask07() {
		Map<String, List<Integer>> map = new HashMap<>();
		
		String keyStr = "aList"; 
		
		//配列を作成して値を格納
		ArrayList<Integer> listA = new ArrayList<>(Arrays.asList(1,2,3));
		//mapに配列を格納する。
		map.put(keyStr, listA);
		
		System.out.println(map.get(keyStr));
		
		//aListに格納
		ArrayList<Integer> addList = new ArrayList<>(map.get(keyStr));
		addList.add(4);
		map.put(keyStr, addList);
		
		System.out.println(map.get(keyStr));
	}
	
	/*
	 * Scannerの使用例
	 */
	private void scanTask08() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("名前を入力してください");
		
		String nameStr = sc.nextLine();
		
		System.out.println("こんにちは、" + nameStr + "さん");
	}
	
	/*
	 * BufferedReaderの使用例
	 */
	private void bufferTask09() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("名前を入力してください");
		
		String nameStr = br.readLine();
		
		System.out.println("こんにちは、" + nameStr + "さん");
	}
}
