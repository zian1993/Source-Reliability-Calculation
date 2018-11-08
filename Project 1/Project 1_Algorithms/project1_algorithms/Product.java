package project1_algorithms;

//Hassan Khan
//Chris Laxton
//Aung Min
//Algorithms Project 1

//This class is basically defining the data structure of the data.
//One object of this class is one row of the table of all the data.

public class Product {

	//Declaring the data variables for each product
	public int pindex;
	public int s1;
	public int s2;
	public int s3;
	public int s4;
	public int s5;
	public int sum;

	public Product(int a, int b, int c, int d, int e, int f)
	{
		pindex = a;
		s1 = b;
		s2 = c;
		s3 = d;
		s4 = e;
		s5 = f;
		sum = s1+s2+s3+s4+s5;

	}
}
