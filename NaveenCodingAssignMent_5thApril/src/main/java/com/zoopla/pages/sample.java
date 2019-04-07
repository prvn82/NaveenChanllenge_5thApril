package com.zoopla.pages;

public class sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String s ="£1,395,000";
		
		String[] split = s.split(" ");
		String[] split2 = split[0].split("£");
		String replaceAll = split2[1].replaceAll(",", "");

		
			System.out.println(replaceAll);
		
	}

}
