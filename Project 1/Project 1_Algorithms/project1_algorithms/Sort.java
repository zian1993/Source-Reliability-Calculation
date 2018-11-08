package project1_algorithms;

import java.util.*;

//Hassan Khan
//Chris Laxton
//Aung Min
//Algorithms Project 1

//We designed this class as a utility class with all the sorting algorithms.
//This class is called everytime we need to sort an array.

public final class Sort {

	//Declaring the inversions variable
	public static int inversions;

	public static ArrayList<Integer> QuickSortMain(ArrayList<Integer> a)
	{
		//Declaring three local arrays
		ArrayList<Integer> lessthan = new ArrayList<Integer>(); 
		ArrayList<Integer> greaterthan = new ArrayList<Integer>();  
		ArrayList<Integer> equalto = new ArrayList<Integer>(); 

		//Define the base case
		if (a.size()<=1)
			return a;

		//Else
		//Picking a pivot randomly
		Random rand = new Random();
		int randval = rand.nextInt(a.size());
		int pivot = randval;
		Integer j;

		//Dividing the array into less than, greater than
		//and equal to
		for (int d=1; d<a.size(); d++)
		{
			j = a.get(d);
			//If the value in the array is lesser than, 
			//greater than or equal to the value
			//of the pivot element
			if (j.compareTo(a.get(pivot))<0)
			{
				inversions+= greaterthan.size();
				lessthan.add(j);
			}
			else
			{
				if(a.get(d) == a.get(pivot))
				{
					if(d!=pivot)
					{
						inversions+=greaterthan.size();
					}
				}
				if(d<pivot)
				{
					inversions++;
				}
				greaterthan.add(j);
			}

		}
		lessthan = QuickSortMain(lessthan);
		greaterthan = QuickSortMain(greaterthan);
		lessthan.add(a.get(pivot));
		lessthan.addAll(greaterthan);

		return lessthan;
	}

	public static ArrayList<Integer> MergeSortMain(ArrayList<Integer> a)
	{
		//Defining the base return case
		if (a.size()<=1)
			return a;

		//Defining the rest of the function
		//Declaring some local ArrayLists and half size int
		int halfsize = (a.size()/2);
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();

		for (int k=0; k<halfsize;k++)
		{
			left.add(a.get(k));
		}

		for (int h=halfsize; h<a.size(); h++)
		{
			right.add(a.get(h));
		}

		return MergeSortMerge(MergeSortMain(left), MergeSortMain(right));
	}

	public static ArrayList<Integer> MergeSortMerge(ArrayList<Integer> a, ArrayList<Integer> b)
	{
		//Creating an array to hold both the arrays
		ArrayList<Integer> newarray = new ArrayList<Integer>();

		//Creating the indexes for the left and right arrays
		int l = 0;
		int r = 0;

		//While both arrays are still being read through,
		//use this loop.
		while ((l<a.size())&&(r<b.size()))
		{
			if ((a.get(l))<=(b.get(r)))
			{
				newarray.add(a.get(l));
				l++;
			}

			else
			{
				newarray.add(b.get(r));
				r++;
				inversions = inversions+(a.size()-l);
			}
		}

		//After one of the arrays are over
		//If left array is still remaining
		while (l<a.size())
		{
			//Copy rest of left array to the new array
			newarray.add(a.get(l));
			l++;
		}

		while (r<b.size())
		{
			//Copy rest of left array to the new array
			newarray.add(b.get(r));
			r++;
		}

		return newarray;
	}

	public static ArrayList<Integer> InsertionSort(ArrayList<Integer> a) {

		//Create Variables 
		int size = a.size();
		int i = 0;
		int j = 0;
		int temp = 0;
		ArrayList<Integer> return_array = new ArrayList<Integer>();
		//int count = 0;

		//Copy the input array into a new array
		for (int z = 0; z<a.size(); z++)
		{
			return_array.add(a.get(z));
		}

		//Create two for loops to go through each element
		for (i = 0; i < size; i ++)
		{
			for(j = i; j > 0; j--)
			{
				if(return_array.get(j)<return_array.get(j-1))
				{
					temp = return_array.get(j);
					return_array.set(j,return_array.get(j-1));
					return_array.set(j-1, temp);
					inversions++;
				}
			}
		}

		return return_array;
	}
}