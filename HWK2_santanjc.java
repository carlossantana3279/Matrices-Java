/*
Name: Juan Carlos Santana Penner
MacID: santanjc
Student Number: 001411625
Description: This program takes multiplies any amount of matrices and inverts the product of the matrices 
 */

import java.text.DecimalFormat;
import java.util.Arrays;		//Import the utility For Arrays
	

public class HWK2_santanjc {						//make a public HWK2_santanjc
	public static void main(String[] args) {		//main function
		
		// Make a list(array) that holds all the matrices
		int N = Integer.parseInt(args[0]);			//N variable used for knowing how many matrices there are
		double[][][] list = new double[N][][];		//make a 3 dimensional array
		double[] m = new double[N];		//an array that holds all the m sizes of all the matrices
		int mCounter = 0;				// make an integer that will be used to make a list of all the m's
		double[] n = new double[N];		//an array that holds all the n sizes of all the matrices
		int nCounter = 0;				// make an integer that will be used to make a list of all the n's
		
////////make a list of all the m's and all the n's/////////////////////////////////////////////////////////////////
		for (int i = 1; i < N*2+1;i++){						//make a for loop that starts at 1 and ends at N*2+1		
			if (i%2==1){									//checking if a number is odd
				m[mCounter] = Integer.parseInt(args[i]);	//add the m from the arguments to the list of m's 
				mCounter++;									//increase mCounter by 1
			}else if (i%2==0){								//checking if a number is even
				n[nCounter] = Integer.parseInt(args[i]);	//add the n from the arguments to the list of n's 
				nCounter++;									//increase nCounter by 1
			}												//ends if statements 	
		}													// ends loop
	
		// Used for testing purposes
		/*
		System.out.print("Array m: ");						//used to show all the m's (for testing purposes)
		for (int i = 0; i < m.length; i++){					// make a loop for iterating through the list of m's
			System.out.print(Double.toString(m[i])+ " ");	//prints the m's
		}													// ends for loop
		System.out.println(" ");							// print empty line to make the output look nicer 
		
		System.out.print("Array n: ");						//used to show all the n's (for testing purposes)
		for (int i = 0; i < n.length; i++){					// make a loop for iterating through the list of n's
			System.out.print(Double.toString(n[i])+ " ");	//prints the n's
		}													// ends for loop
		System.out.println(" ");							// print empty line to make the output look nicer 
		*/
///////initialize all the sizes for all the matrices///////////////////////////////////////////////////////////////
		for (int i = 0; i < N; i ++){					
			list[i] = new double[(int) m[i]][(int)n[i]];	//assigns the sizes of all the matrices						
		}													//end of loop
		
////////sanity check for multiplying////////////////////////////////////////////////////////////////////////////
		//Check if the n1 and m2 match etc.. (check if you can multiply the true matrices)
		for (int i = 0; i < N-1;i++){
			if (n[i] != m[i+1]){								//checks if n1 and m2 match etc...
				System.out.println("Multiplication error.");	//prints to let user know that you can't multiply
				return;											//empty return to end the program
			}													//ends if statement
		}														//ends loop
		
		int counter = N*2+1;									//counter used to start putting the argument inputs into the matrices
////////initailize the values of the matrices///////////////////////////////////////////////////////////////					
		for (int i = 0; i < N;i++){								// loop to iterate through all the matrices
			int amtRow = (int) m[i];							// variable used to set the limit on the next loops
			int amtCol = (int) n[i];							// ^
			
			for (int j = 0; j < amtRow; j++){					//loop used to iterate through all the rows
				for (int k = 0; k < amtCol; k++){				//loop used to iterate through all teh columns
					//System.out.println("Matrix:"+ Integer.toString(i) + ", Row:" + Integer.toString(j)+ ", Col:"+ Integer.toString(k));			//used for testing purposes
					//System.out.println("Args Index: "+Integer.toString(counter)+ " Number being put in: " + Integer.parseInt(args[counter]));		//^
					list[i][j][k] = Integer.parseInt(args[counter]);	//assigns the argument to the correct matrix & spot
					counter ++;											//increase counter by 1
					//System.out.println(" ");							// empty print statement used to make output look nicer
					
				}												// end loop for the column loop
			}													// end loop for the row loop
		}														// end loop for the matrix loop
		//result matrix is where our answer is going to be once we multiply all the matrices
		double[][] resultMatrix = list[0];					
		
		//variables initialized for matrix multiplication
		int m1 = 0;	
		int n1 =0;
		int n2=0;
		
////////Matrix Multiplication//////////////////////////////////////////////////////////////////////////////
		for (int h = 0; h < N-1; h++ ){		//the total amount of times that you will have to multiply (N-1)
			
			if (h==0){					//checks if its the first time multiplying
				m1 = (int) m[0]; 		// the amount of rows of the first matrix 
				n1 = (int) n[h];		// the amount of columns of the first matrix
				n2 = (int) n[h+1];//2;	// the amount of columns of the second matrix
			}else if (h>0){				//if its not the first time multiplying
				m1 = (int) m[0];		//m1 stays the same
				n1 = n2;				//n1 becomes the old n2
				n2 = (int) n[h+1];		//the amount of columns of the second matrix
			}							//ends if statements
			
			//System.out.println("h: " + Integer.toString(h));	//used for testing purposes
			double[][] c = new double[m1][n2];		//will temporarily  become the product of the two matrices 
		
			for (int i = 0; i < m1; i++){			//loop for iterating through the rows of the first matrix
				for (int j = 0; j < n2; j++){		//loop for iterating through the columns of the second matrix
					for (int k = 0; k < n1; k++){	//loop fot iterating through each element of each row/column
							c[i][j] += resultMatrix[i][k] * list[h+1][k][j];	//calculates the multiplication and puts it into the c matrix
					}								//ends loop
				}									//ends loop
			}										//ends loop
			resultMatrix = c;						//resultMatrix will hold the final result of the product of the matrices 
				
			// for testing purposes, prints the result matrix
			
			
			
		}

		
//////// Section for inverting the resultMatrix of the product of matrices ///////////////////////////////////////
		m1 = m1;	//m1 is the m size of the result matrix
		n1 = n2;	//n1 is the n size of the result matrix 
		
		
		
		//System.out.println("The Result Matrix");	//print statement 
		//print result matrix, used for testing purposes
		/*
		for (int i = 0; i < m1;i++){									//iterates through the rows of the result matrix
			for (int j = 0; j < n1;j++){								//iterate through the columns of the result matrix
				System.out.print(Double.toString(resultMatrix[i][j]));	//prints each individual element of the matrix
				System.out.print(" ");									//print statement to make output look nice
			}															//ends column loop
			System.out.println(" ");									//print statement to make output look nice
		}																//ends row loop
		System.out.println(" ");										//print statement to make output look nice
		*/
////////sanity check (if its an MxN matrix and M=N)////////////////////////////////////////////////////////
		if (m1 != n1){						//if statement to make sure that m and n are the same size
			System.out.print("M != N");		//outputs that M does not equal N
		}									//end if statement

////////If the Result MAtrix is a 1 by 1
		if (N==1){
			for (int i = 0; i < Double.parseDouble(args[1]);i++){
				for (int j = 0; j < Double.parseDouble(args[2]);j++){
					list[0][i][j] = 1/list[0][i][j];
				}
			}
			for (int i = 0; i < Double.parseDouble(args[1]);i++){
				for (int j = 0; j < Double.parseDouble(args[2]);j++){
					System.out.print(list[0][i][j]+" ");
				}
			}
			return;
		}
		
////////make an elementary matrix///////////////////////////////////////////////////////////////////////////////
		double[][] elem = new double[m1][n1];	//a 2d array that starts out as the elementary matrix, and its the same size as the result maatrix
		for (int i = 0; i <m1; i++){			//loop used for selecting the elements of the diagnol
			elem[i][i]= 1;						//making the elements on the diaganol equal to 1
		}										//end loop
		
		/*   FOr testing purposes
		System.out.println("The Elementary Matrix");	//statement to let user know that it will be printing the elementary matrix
		//print elementary matrix			
		for (int i = 0; i < m1;i++){
			for (int j = 0; j < n1;j++){
				System.out.print(Double.toString(elem[i][j]));		//prints each individual element of the elementary matrix
				System.out.print(" ");								//print statement to make output look nice
			}												
			System.out.println(" ");								//print statement to make output look nice
		}
		*/
	
////////Start the Gauss Jordan, Inversion by using elementary row operations/////////////////////////////////////
///////*** Sanity checks are scattered throughout the code
		
for (int i = 0; i < m1;i++){	//loop for selecting pivot
			
			int pivotPos = i;		//used for knowing which pivot row we are on
			double k = 0.0;			//k  is what we will be using to multiply the pivot row by
			
//Sanity Check, checks if an entire row are zeros
			double sum = 0.0;	//the sum of an entire row, ie an entire row of zeros ='s zero.
			//check entire row
			for (int h = 0; h < m1;h++){					//loop iterating through the rows
				for (int p = 0; p < m1; p++){				//loop for the columns
					sum += Math.abs(resultMatrix[h][p]);	//sum is a cummulator and gets the sum of an entire row
					//System.out.println("Adding:  " + Double.toString(resultMatrix[h][p]));	//used for testing purposes
				}											// ends loop for columns
				//check
				if (sum == 0.0){	// in the sum of an entire row is 0 then a row is all zeros
					//System.out.println("Sum of row"+ Integer.toUnsignedString(h)+ " is 0. Not Invertible!");	// let the user know if matrix is not invertible
					System.out.print("Matrix not invertible");
					return;			// end the program if matrix is not invertible
				}
				//System.out.println(" ");			// makes output look nicer
			}										//ends loop for rows
			
			//switch rows only if needed
			boolean ifCanSwitch = true;			//this will determine if you can cannot switch rows
			//if statement  for tesing
			if (resultMatrix[i][i] == 0){	//if true we need to switch!
				//System.out.println("pivot: row"+Integer.toString(i)+ " column"+Integer.toString(i)+ " starts with a 0"); 	//print statement , lets user know which row and column starts with 0
			}								//end of if statement 
			
			//The FOR loop(Chunk of code) for actually switching rows, **if needed only
//sanity check, will check if you can switch pivot with another row, if there are no other rows then the matrix is not invertible (ie column of zeros)
			for(int j = i; j< m1 ; j++){							//loop for iterating through columns
				if ((resultMatrix[j][i] != 0) & resultMatrix[i][i] == 0) { 	//if an element below the pivot is not zero then switch
					//System.out.println("Switching row" + Integer.toString(i) + " to row" + Integer.toString(j));	//for testing purposes, used to know which rows are being switched
					ifCanSwitch = true;							//makes boolean true
					double[] temp = new double[m1];				//make an array that will temporarily hold a row
					double[] tempElem = new double[m1];			//make an array that will temporarily hold a row, for the elementary matrix
					temp = resultMatrix[j];						//the temporary array holds row j
					resultMatrix[j] = resultMatrix[i];			//let row j = row i
					resultMatrix[i]	= temp;						//let row i = temporary
					
					tempElem = elem[j];							//the temporary array holds row j
					elem[j]= elem[i];							//let row j = row i
					elem[i] = tempElem;							//let row i = temporary
					
					
					/*		used for testing purposes, code prints the result matrix (has been commented already above somewhere)
					System.out.println("The Result Matrix");
					//print result matrix
					for (int p = 0; p < m1;p++){
						for (int h = 0; h < n1;h++){
							System.out.print(Double.toString(resultMatrix[p][h]));
							System.out.print(" ");
						}
						System.out.println(" ");
					}
					System.out.println(" ");
					*/
					
					
					//When Switch is successful break through the for loop
					break;
				}else if (resultMatrix[i][i] == 0) {	//if you need to switch is true
					ifCanSwitch = false;				//this means that the pivot is 0 and you can not switch any row in the matrix
				}
			}
			//Sanity check
			if (ifCanSwitch == false){					//this means that the pivot is 0 and you can not switch any row in the matrix
				//System.out.println("Column of Zero? Cant switch anymore. Not Invertible");	//let user know matrix is not invertible
				System.out.println("Matrix not invertible");			//lest user know that matrix is not invertible
				return;									//ends program
			}											//end if if
			
			double divRow = resultMatrix[i][i];			// what we are going to be
			
			//System.out.println("Divide row:" + Integer.toString(pivotPos)+  " by: "  + Double.toString(divRow) );	//used for testing purposes, lets me know what a row is being divided by
			
			//divide entire pivot row (normalizing the pivot row)
			for (int j = 0; j < m1; j++){			//for iterating through columns
				
				resultMatrix[i][j] = resultMatrix[i][j]*(1/divRow);			//divide the row by divRow
				//System.out.println("Row:" + Integer.toString(i)+ " COlumn:"+ Integer.toString(+j)+ " Number:" + resultMatrix[i][j] );	//used for test, prints row, column, and the number after being divided
				elem[i][j] = elem[i][j]*(1/divRow);							//divide the row by divRow
				
				//Sanity check, if a number is divided by 0 or number cannot exist etc... ei not invertible 
				if ((resultMatrix[i][j] == Double.NaN)|| Double.isInfinite(resultMatrix[i][j])){
					System.out.println("Matrix not invertible");			//lets user know matrix is not invertible
					return;												//end program
				}														//end if statement
			}										//ends column for loop 
			
			
			//Make all coefficient above and below pivot element 0 (add or subtract rows)
			for (int j= 0; j < m1; j++){ 				// for selecting the row we are going to add/subtract 
				if (j != pivotPos){ 					// we are not add/subtracting the pivot row (we are adding to the other rows)
					
					if (resultMatrix[j][i] > 0){ //if the element above/below is positive we subtract it
						k = Math.abs((resultMatrix[j][i]/resultMatrix[i][i]));			// k is what we are going to multiply each row by
						//System.out.println("Subtract, Row"+Integer.toString(j) +" - " + Double.toString(k) + "*Row"+ Integer.toString(i));	//used for testing, lets me know what im actually doing to the rows (row 1 - 2*Row 2)
						
						//Sanity check, if a number is divided by 0 or number cannot exist etc... ei not invertible 
						if ((Double.isNaN(k))|| Double.isInfinite(k)){		
							System.out.println("Matrix not invertible");		//lets user know matrix is not invertible
							return;											//end program
						}													//end if statement			
						
						for (int p = 0; p < m1;p++){ //for adding/subtracting each element in the row
									
							resultMatrix[j][p] = resultMatrix[j][p] - k*resultMatrix[i][p]; //subtract/add that element
							elem[j][p]= elem[j][p] - k*elem[i][p];							//subtract/add that element
							//Sanity check, if a number is divided by 0 or number cannot exist etc... ei not invertible 
							if ((Double.isNaN(resultMatrix[j][p]))|| Double.isInfinite(resultMatrix[j][p])){
								System.out.println("Matrix not invertible");	//lets user know matrix is not invertible
								return;										//end program
							}
						}
						
					} else if (resultMatrix[j][i] < 0){	//if the element above/below is negative we add it
						k = Math.abs((resultMatrix[j][i]/resultMatrix[i][i]));			// k is what we are going to multiply each row by
						//System.out.println("Add, Row"+Integer.toString(j) +" + " + Double.toString(k) + "*Row"+ Integer.toString(i));	//used for testing, lets me know what im actually doing to the rows (row 1 - 2*Row 2)
						//Sanity check, if a number is divided by 0 or number cannot exist etc... ei not invertible 
						if ((Double.isNaN(k))|| Double.isInfinite(k)){	
							System.out.println("Matrix not invertible");	//lets user know matrix is not invertible
							return;										//end program
						}												//end if statement
						
						for (int p = 0; p < m1;p++){ //for adding/subtracting each element in the row
							resultMatrix[j][p] = resultMatrix[j][p] + k*resultMatrix[i][p];		 //subtract/add that element
							elem[j][p]= elem[j][p] + k*elem[i][p];								 //subtract/add that element
							//Sanity check, if a number is divided by 0 or number cannot exist etc... ei not invertible 
							if ((Double.isNaN(resultMatrix[j][p]))|| Double.isInfinite(resultMatrix[j][p])){
								System.out.println("Matrix not invertible");		//lets user know matrix is not invertible
								return;											//end program
							}													//end if statement
						}														//enf row loop									
					}															//end if statement
				}															//end if statement
			}																//end for loop that selects row		
		}																	//ends the pivot for loop 		

		//Code that will print final result
		for (int i = 0; i < m1;i++){									//loop for iterating through the rows
			for (int j = 0; j < n1;j++){								//loop for iterating through the columns
				double number = elem[i][j];								//variable used later to check is if a number is -0
				DecimalFormat df = new DecimalFormat("###.##");			//for rounding
				if (Double.parseDouble(df.format(number)) == -0.0){		//if the rounded number is -0 then it will turn it to 0
					elem[i][j] = 0.0;									//ei -0 turns to 0
				}														//end if statement
				System.out.print(df.format(elem[i][j]) + " ");			// prints out final result
			}															//end columns loop
		}																//end rows loop
	}																	//closes main method
}																		//closes class
