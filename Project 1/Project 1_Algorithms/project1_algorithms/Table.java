package project1_algorithms;

import java.util.*;

//Hassan Khan
//Chris Laxton
//Aung Min
//Algorithms Project 1

//This class is the table data structure, which holds a list of the product objects.
//Each product object is a row in the table, and contains the product index and the
//source ranking from each source for that particular product.

public class Table {

	//Declaring the data fields.
	public ArrayList<Product> main;

	public Table()
	{
		main = new ArrayList<Product>();
	}

	public void addProduct(Product a)
	{
		main.add(a);
	}

	public int getIndex(int a)
	{
		int i=0;

		while (i<main.size())
		{
			if ((main.get(i).sum)==a)
				return main.get(i).pindex;

			else
				i++;
		}

		//If cant find the sum value
		return -1;
	}

	//Getting a product based on the sum value of that product
	public Product getProduct(int a)
	{
		int i=0;

		while (i<main.size())
		{
			if ((main.get(i).sum)==a)
				return main.get(i);

			else
				i++;
		}

		//If cant find the sum value
		return null;
	}
}
