package project1_algorithms;

import java.io.*; 
import java.util.*;

//Hassan Khan
//Chris Laxton
//Aung Min
//Algorithms Project 1

//This class is for reading data from the source.txt files.

public final class Product_io {

	//Credit for this method goes to geeksforgeeks.org
	public static ArrayList<Integer> readfile (String a) throws Exception
	{
		// We need to provide file path as the parameter: 
		// double backquote is to avoid compiler interpret words 
		// like \test as \t (ie. as a escape sequence) 
		File file = new File(a); 
		ArrayList<Integer> z = new ArrayList<Integer>();

		BufferedReader br = new BufferedReader(new FileReader(file)); 

		String st;
		int convert;
		while ((st = br.readLine()) != null) 
		{
			convert = Integer.parseInt(st);
			z.add(convert);
		}

		return z;
	}

}
