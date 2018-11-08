package InsertionSort;

import java.util.ArrayList;

public class Sort {

	public static ArrayList<Integer> sorting(ArrayList<Integer> a) {
		
		//Create Variables 
		int size = a.size();
		int i = 0;
		int j = 0;
		int temp = 0;
		int count = 0;
		
		//Create two for loops to go through each element
		for (i = 0; i < size; i ++)
		{
			for(j = i; j > 0; j--)
			{
				if(a.get(j)<a.get(j-1))
				{
					temp = a.get(j);
					a.set(j,a.get(j-1));
					a.set(j-1, temp);
					count++;
				}
			}
		}
		
		System.out.println("Sorted Array: " +a);
		System.out.println("Inversions That Occured: " +count);
		
		return a;

	}

}
