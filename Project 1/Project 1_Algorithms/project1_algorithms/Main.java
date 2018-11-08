package project1_algorithms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

//Hassan Khan
//Chris Laxton
//Aung Min
//Algorithms Project 1

//This is the main class, where we read data from the source files, and then operate on them
//to calculate the inversions.

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//First, reading the data from the source file
		//Initializing the arrays into which we will insert data
		ArrayList<Integer> source1 = new ArrayList<Integer>();
		ArrayList<Integer> source2 = new ArrayList<Integer>();
		ArrayList<Integer> source3 = new ArrayList<Integer>();
		ArrayList<Integer> source4 = new ArrayList<Integer>();
		ArrayList<Integer> source5 = new ArrayList<Integer>();

		//Inserting the data into the arrays
		try {
			source1 = Product_io.readfile("D:\\Uni Work Doe\\Algorithms\\Projects\\Project 1\\source1.txt");
			source2 = Product_io.readfile("D:\\Uni Work Doe\\Algorithms\\Projects\\Project 1\\source2.txt");
			source3 = Product_io.readfile("D:\\Uni Work Doe\\Algorithms\\Projects\\Project 1\\source3.txt");
			source4 = Product_io.readfile("D:\\Uni Work Doe\\Algorithms\\Projects\\Project 1\\source4.txt");
			source5 = Product_io.readfile("D:\\Uni Work Doe\\Algorithms\\Projects\\Project 1\\source5.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Declaring a product object to form the products
		Product temp;

		//Declaring and initiating a table object to form the arraysort of all the products.
		Table everything = new Table();

		//Step 1
		//Initiating and declaring the product, and filling
		//each product with data

		if (((source1.size())==(source2.size()))&&((source2.size())==(source3.size()))&&(source3.size())==(source4.size())&&(source4.size())==(source5.size()))
		{
			//Since all sizes are the same, picking
			//one array size to create the loop for the products.
			for (int a=0; a<source1.size();a++)
			{
				temp = new Product(a, source1.get(a),source2.get(a),source3.get(a),source4.get(a),source5.get(a));
				everything.addProduct(temp);
			}
		}
		else
			System.out.println("Please enter the same sized sources!");

		//At this point our table structure of each product, with their rankings from various sources, and the sum of the rankings
		//have been made.

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
		Iteration.iterationnum = 0;

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


		Pack iterateinput = new Pack();
		iterateinput.table = everything;
		iterateinput.w_values = w_values_final;

		Iteration.Iterate(iterateinput);

		System.out.println("Finished Running! ");

	}

}
