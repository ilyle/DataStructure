package edu.coerscnu.client;

import edu.coerscnu.basic.list.ArrayList.ArrayUtil;

public class Client {

	public static void main(String[] args) {
		int[] org = { 1, 3, 4, 5, 0, 0, 6, 6, 0, 5, 4, 7, 6, 7, 0, 5 };
		int[] arr1 = { 3, 5, 7, 8, 9, 10, 123 };
		int[] arr2 = { 4, 5, 6, 7 };
		ArrayUtil arrayUtil = new ArrayUtil();
		int[] res = arrayUtil.getPerfectNumbers(10000);
//		String string = arrayUtil.join(org, "nishi");
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
//		System.out.println(string);
	}
}
