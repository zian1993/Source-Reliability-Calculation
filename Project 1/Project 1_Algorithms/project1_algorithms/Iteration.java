package project1_algorithms;

import java.util.ArrayList;
import java.io.*;

//Hassan Khan
//Chris Laxton
//Aung Min
//Algorithms Project 1

//This class does the iteration of the reliability and inversion calculations, until the same reliability
//values have been reached.

public final class Iteration {

	public static int iterationnum;

	public static void Iterate(Pack a)
	{
		//At this point our table structure of each product, with their rankings from various sources, and the sum of the rankings
		//have been made.

		//The w values have been inherited in the pack structure.

		//Opening up the pack structure
		//Creating the table to use
		Table init_table = new Table();
		init_table = a.table;

		ArrayList<Double> input_w_vals = new ArrayList<Double>();
		input_w_vals = a.w_values;

		//Declaring and initializing the revised table
		Table everything = new Table();
		Product temp;
		int temp1;
		int temp2;
		int temp3;
		int temp4;
		int temp5;

		//Multiplying the values in the table by the appropriate w values
		for (int q=0; q<init_table.main.size(); q++)
		{
			temp1 = (int) ((init_table.main.get(q).s1)*(input_w_vals.get(0)));
			temp2 = (int) ((init_table.main.get(q).s2)*(input_w_vals.get(1)));
			temp3 = (int) ((init_table.main.get(q).s3)*(input_w_vals.get(2)));
			temp4 = (int) ((init_table.main.get(q).s4)*(input_w_vals.get(3)));
			temp5 = (int) ((init_table.main.get(q).s5)*(input_w_vals.get(4)));

			temp = new Product(q, temp1, temp2, temp3, temp4, temp5);
			everything.addProduct(temp);
		}

		//Step 2
		//Sorting the table according to the sum values of the products.

		//Making an array of the sum values of products, in order to sort them first.
		ArrayList<Integer> sumvals = new ArrayList<Integer>();

		for (int b=0; b<everything.main.size(); b++)
		{
			sumvals.add(everything.main.get(b).sum);
		}

		//Now finally sorting these sum values and saving them in a different array.
		ArrayList<Integer> sortedsums = new ArrayList<Integer>();
		sortedsums = Sort.MergeSortMain(sumvals);

		//Step 3
		//Adjustment. Now making a new table, which has been sorted according to the sum values of the products
		Table everything2 = new Table();

		for (int c=0; c<sortedsums.size(); c++)
		{
			everything2.addProduct(everything.getProduct(sortedsums.get(c)));
		}

		//At this point, the adjusted table has been created.

		//Step 4
		//Now counting the inversions of each source, using three different sorting algorithms.
		//Making integer arrays of the different sources from the adjusted table, which can then be passed into
		//the sorting algorithms.

		ArrayList<Integer> s1 = new ArrayList<Integer>();
		ArrayList<Integer> s2 = new ArrayList<Integer>();
		ArrayList<Integer> s3 = new ArrayList<Integer>();
		ArrayList<Integer> s4 = new ArrayList<Integer>();
		ArrayList<Integer> s5 = new ArrayList<Integer>();

		for (int d=0; d<everything2.main.size(); d++)
		{
			s1.add(everything2.main.get(d).s1);
			s2.add(everything2.main.get(d).s2);
			s3.add(everything2.main.get(d).s3);
			s4.add(everything2.main.get(d).s4);
			s5.add(everything2.main.get(d).s5);
		}

		//Now that our arrays of the source values are set up, we can pass them into the sort functions and get our
		//inversion values.

		//Also using the inversion values from merge sort to calculate the inversions for
		//each source, for next step. Therefore saving the inversion values into a different array.
		ArrayList<Integer> w_values = new ArrayList<Integer>();
		ArrayList<Integer> tempsource = new ArrayList<Integer>();

		//Setting iteration number
		iterationnum++;

		//Printing my output inversion values to a file
		//The code to print to file has been taken from stackoverflow.
		try(FileWriter fw = new FileWriter("D:\\Uni Work Doe\\Algorithms\\Projects\\Project 1\\myfile.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw))
		{

			//Printing the iteration number
			out.println("Iteration number: " + Iteration.iterationnum);
			out.println("");

			//Starting off with MergeSort
			out.println("Printing inversions as calculated using MergeSort: ");
			out.println("");

			//Source 1
			Sort.inversions = 0;
			tempsource = Sort.MergeSortMain(s1);
			out.println("Source 1 inversions: "+Sort.inversions);
			w_values.add(Sort.inversions);
			out.println("");

			//Source 2
			Sort.inversions = 0;
			tempsource = Sort.MergeSortMain(s2);
			out.println("Source 2 inversions: "+Sort.inversions);
			w_values.add(Sort.inversions);
			out.println("");

			//Source 3
			Sort.inversions = 0;
			tempsource = Sort.MergeSortMain(s3);
			out.println("Source 3 inversions: "+Sort.inversions);
			w_values.add(Sort.inversions);
			out.println("");

			//Source 4
			Sort.inversions = 0;
			tempsource = Sort.MergeSortMain(s4);
			out.println("Source 4 inversions: "+Sort.inversions);
			w_values.add(Sort.inversions);
			out.println("");

			//Source 5
			Sort.inversions = 0;
			tempsource = Sort.MergeSortMain(s5);
			out.println("Source 5 inversions: "+Sort.inversions);
			w_values.add(Sort.inversions);
			out.println("");


			//Now doing InsertionSort
			out.println("Printing inversions as calculated using InsertionSort: ");
			out.println("");

			//Source 1
			Sort.inversions = 0;
			tempsource = Sort.InsertionSort(s1);
			out.println("Source 1 inversions: "+Sort.inversions);
			out.println("");

			//Source 2
			Sort.inversions = 0;
			tempsource = Sort.InsertionSort(s2);
			out.println("Source 2 inversions: "+Sort.inversions);
			out.println("");

			//Source 3
			Sort.inversions = 0;
			tempsource = Sort.InsertionSort(s3);
			out.println("Source 3 inversions: "+Sort.inversions);
			out.println("");

			//Source 4
			Sort.inversions = 0;
			tempsource = Sort.InsertionSort(s4);
			out.println("Source 4 inversions: "+Sort.inversions);
			out.println("");

			//Source 5
			Sort.inversions = 0;
			tempsource = Sort.InsertionSort(s5);
			out.println("Source 5 inversions: "+Sort.inversions);
			out.println("");

			//Now doing QuickSort
			out.println("Printing inversions as calculated using QuickSort: ");
			out.println("");

			//Source 1
			Sort.inversions = 0;
			tempsource = Sort.QuickSortMain(s1);
			out.println("Source 1 inversions: "+Sort.inversions);
			out.println("");

			//Source 2
			Sort.inversions = 0;
			tempsource = Sort.QuickSortMain(s2);
			out.println("Source 2 inversions: "+Sort.inversions);
			out.println("");

			//Source 3
			Sort.inversions = 0;
			tempsource = Sort.QuickSortMain(s3);
			out.println("Source 3 inversions: "+Sort.inversions);
			out.println("");

			//Source 4
			Sort.inversions = 0;
			tempsource = Sort.QuickSortMain(s4);
			out.println("Source 4 inversions: "+Sort.inversions);
			out.println("");

			//Source 5
			Sort.inversions = 0;
			tempsource = Sort.QuickSortMain(s5);
			out.println("Source 5 inversions: "+Sort.inversions);
			out.println("");

		} catch (IOException e) {
			//exception handling left as an exercise for the reader
		}

		//Step 5.
		//Calculating the new w values for the inversions of each source.

		//We have used the inversion values from merge sort to calculate the inversions for
		//each source.

		//Calculating the w values based on the inversions for each source.
		ArrayList<Double> w_values_init = new ArrayList<Double>();
		double temp_val;

		for (int e=0; e<w_values.size(); e++)
		{
			//temp_val = (1/(1+w_values.get(e)));
			temp_val = (double)((double)1/(double)(1+w_values.get(e)));
			w_values_init.add(temp_val);
		}


		//Calculating the sum of the w values
		double w_values_sum = 0;

		for (int f=0; f<w_values_init.size(); f++)
		{
			w_values_sum += w_values_init.get(f);
		}

		//Normalizing the w values
		ArrayList<Double> w_values_final = new ArrayList<Double>();

		for (int g=0; g<w_values_init.size(); g++)
		{
			w_values_final.add((w_values_init.get(g))/w_values_sum);
		}

		//Printing the reliability in % for each source.
		try(FileWriter fw = new FileWriter("D:\\Uni Work Doe\\Algorithms\\Projects\\Project 1\\myfile.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw))
		{
			//Printing the iteration number
			out.println("Reliability for Iteration number: " + Iteration.iterationnum);
			out.println("");

			//Source 1
			out.println("Reliability for Source 1: " + (w_values_final.get(0)*100) + "%");
			out.println("");

			//Source 2
			out.println("Reliability for Source 2: " + (w_values_final.get(1)*100) + "%");
			out.println("");

			//Source 3
			out.println("Reliability for Source 3: " + (w_values_final.get(2)*100) + "%");
			out.println("");

			//Source 4
			out.println("Reliability for Source 4: " + (w_values_final.get(3)*100) + "%");
			out.println("");

			//Source 5
			out.println("Reliability for Source 5: " + (w_values_final.get(4)*100) + "%");
			out.println("");


		} catch (IOException e) {
			//exception handling left as an exercise for the reader
		}


		Pack returnpack = new Pack();
		returnpack.table = a.table;
		returnpack.w_values = w_values_final;

		//Making the recursion here
		//Calling the function recursively, until all the inversions achieved are the same.
		//Defining the base case: if the w/reliability values are the same, return.

		//Double values will hardly ever equal to one another. Therefore if we desperately
		//wanted to stop the program, we could write code to compare the difference between the
		//current and initial w values instead of checking to see if they are equal. If the
		//difference is smaller than a very minute number, then the program could stop, and assume
		//that the same w values have been reached.
		if (a.w_values.equals(w_values_final))
		{
			return;
		}
		else 
			Iterate(returnpack);
	}

}
