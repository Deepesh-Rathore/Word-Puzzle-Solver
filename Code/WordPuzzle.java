import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



public class WordPuzzle
{
	
	// loads the dictionary into hash table
	public void loadDictionary(String path, MyHashTable<String> H,int en)
	{
	    Scanner s1=null;
		try {
			s1 = new Scanner(new File(path));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	     int wordCount = 0;
	     
	     while(s1.hasNext()){
	    	 String word = s1.nextLine();
	    	 if(en ==1) // if running enhanced algorithm
	    	 {
	    		StringBuilder sb = new StringBuilder();
				for(int i = 0; i < word.length(); i++) 
				{
					sb.append(word.charAt(i));
					
					if(i == word.length() - 1) 
					{
						H.insert(sb.toString(), true);
						wordCount++;
					}
					else 
					{								
						H.insert(sb.toString(), false);
					}							
				}
	    		 
	    	 }
	    	 else
	    	 {
//	    		 String word = s1.nextLine();
		    	 H.insert(word,true);
		    	 wordCount++;
	    	 }
	    	 
	     }
	     
	     s1.close();
	     System.out.println("Dictionary loaded, total words = "+wordCount);
	}
	
	
	public void seeHorizontalWE(MyHashTable<String> table,ArrayList<String> results, char matrix[][], int en )
	{
		StringBuilder sb = new StringBuilder();	
  	  	
		for (int i=0; i<matrix.length; i++)
		{
			   
	      for (int j=0; j<matrix[i].length; j++)
	      {
			sb.setLength(0);
	      
	        for( int k=0; k + j < matrix[i].length; k++ ) 
	        {
        	sb.append(matrix[i][k+j]);
        	int eVal = table.contains(sb.toString());
        	
        	if (eVal==0  && en==1)
        	{
        		sb.setLength(0);
        		break;
        	}
        	else if (eVal == 1)
            {
        		
        		results.add(new String(sb));
            }
        	else
        	{
        		
        	}
        	
    	
	        }
	      }
		 }
            
	}
	
	public void seeHorizontalEW(MyHashTable<String> table,ArrayList<String> results, char matrix[][],int en )
	{
		StringBuilder sb = new StringBuilder();	
  	  	
		for (int i=0; i<matrix.length; i++)
		{
			   
	      for (int j=matrix[i].length-1; j>=0; j--)
	      {
			sb.setLength(0);
	      
	        for( int k=j; k >=0; k-- ) 
	        {
	        	sb.append(matrix[i][k]);
        	
        		if(sb.length() <2)
        		{continue;}
        	
        		int eVal = table.contains(sb.toString());
            	
            	if (eVal==0  && en==1)
            	{
            		sb.setLength(0);
            		break;
            	}
            	else if (eVal == 1)
                {
            		
            		results.add(new String(sb));
                }
            	else
            	{
            		
            	}
        	
    	
	        }
	      }
		 }
            
	}
	
	public void seeVerticalNS(MyHashTable<String> table,ArrayList<String> results, char matrix[][],int en )
	{
		StringBuilder sb = new StringBuilder();	
		
		for (int i=0; i<matrix[0].length; i++)
		{
			   
	      for (int j=0; j<matrix.length; j++)
	      {
				sb.setLength(0);
		      
		        
		        for( int k=0; k + j < matrix.length; k++ ) 
		        {
		        	sb.append(matrix[k+j][i]);
	//	        	System.out.print("("+(k+j)+", "+i+") ");
		        	if(sb.length() <2)
	        		{continue;}
		        	
		        	int eVal = table.contains(sb.toString());
		        	
		        	if (eVal==0  && en==1)
		        	{
		        		sb.setLength(0);
		        		break;
		        	}
		        	else if (eVal == 1)
		            {
		        		//System.out.println("Found \"" + sb + "\" horizontally L to R at "+ "(" + i + "," + j + ")");
		        		results.add(new String(sb));
		            }
		        	else
		        	{
		        		
		        	}
	    	
		        }
	//	        System.out.println();
	      }
		}
            
	}
	
	public void seeVerticalSN(MyHashTable<String> table,ArrayList<String> results, char matrix[][],int en )
	{
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<matrix[0].length; i++)
		{
			
	      for (int j=0; j<matrix.length; j++)
	      {
				sb.setLength(0);
		      
		        
		        for( int k=matrix.length-1; (k - j) >= 0; k-- ) 
		        {
		        	sb.append(matrix[k-j][i]);
	//	        	System.out.print("("+(k-j)+", "+i+") ");
		        	if(sb.length() <2)
	        		{continue;}
		        	
		        	int eVal = table.contains(sb.toString());
		        	
		        	if (eVal==0  && en==1)
		        	{
		        		sb.setLength(0);
		        		break;
		        	}
		        	else if (eVal == 1)
		            {
		        		//System.out.println("Found \"" + sb + "\" horizontally L to R at "+ "(" + i + "," + j + ")");
		        		results.add(new String(sb));
		            }
		        	else
		        	{
		        		
		        	}
	    	
		        }
	//	        System.out.println();
	      }
		}
	}
	     
	public void seeDiagonalNE(MyHashTable<String> table,ArrayList<String> results, char matrix[][],int en)
	{
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<matrix.length; i++)
		   {
			   for(int j=0; j<matrix[0].length; j++)
			   {
				   int z = i;
				   sb.setLength(0);
				   for(int k=j; k<matrix[0].length; k++)
				   {
//					   System.out.print("("+z+", "+k+") ");
					   sb.append(matrix[z][k]);
					   if(sb.length() <2)
		        		{	z--;
						   if(z<0)
						   {break;}
						   continue;}
					   
					   int eVal = table.contains(sb.toString());
			        	
			        	if (eVal==0  && en==1)
			        	{
			        		sb.setLength(0);
			        		break;
			        	}
			        	else if (eVal == 1)
			            {
			        		//System.out.println("Found \"" + sb + "\" horizontally L to R at "+ "(" + i + "," + j + ")");
			        		results.add(new String(sb));
			            }
			        	else
			        	{
			        		
			        	}
					   z--;
					   if(z<0)
					   {break;}
				   }
//				   System.out.println();
				   
			   }
		   }
	}
	
	public void seeDiagonalSW(MyHashTable<String> table,ArrayList<String> results, char matrix[][],int en)
	{
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<matrix.length; i++)
		   {
			   for(int j=0; j<matrix[0].length; j++)
			   {
				   int z = i;
				   sb.setLength(0);
				   for(int k=j; k>=0; k--)
				   {
//					   System.out.print("("+z+", "+k+") ");
					   sb.append(matrix[z][k]);
					   if(sb.length() <2)
		        		{z++;
						   if(z>matrix.length-1)
						   {break;}
						   continue;}
					   int eVal = table.contains(sb.toString());
			        	
			        	if (eVal==0  && en==1)
			        	{
			        		sb.setLength(0);
			        		break;
			        	}
			        	else if (eVal == 1)
			            {
			        		//System.out.println("Found \"" + sb + "\" horizontally L to R at "+ "(" + i + "," + j + ")");
			        		results.add(new String(sb));
			            }
			        	else
			        	{
			        		
			        	}
					   z++;
					   if(z>matrix.length-1)
					   {break;}
				   }
//				   System.out.println();
				   
			   }
		   }
	}
	
	   public void seeDiagonalSE(MyHashTable<String> table,ArrayList<String> results, char matrix[][],int en)
		{
			StringBuilder sb = new StringBuilder();
	   
			for(int i=0; i<matrix.length; i++)
			   {
				   for(int j=0; j<matrix[0].length; j++)
				   {
					   int z = i;
					   sb.setLength(0);
					   for(int k=j; k<matrix[0].length; k++)
					   {
//						   System.out.print("("+z+", "+k+") ");
						   sb.append(matrix[z][k]);
						   if(sb.length() <2)
			        		{z++;
							   if(z>matrix.length-1)
							   {break;}
							   continue;}
						   
						   int eVal = table.contains(sb.toString());
				        	
				        	if (eVal==0  && en==1)
				        	{
				        		sb.setLength(0);
				        		break;
				        	}
				        	else if (eVal == 1)
				            {
				        		//System.out.println("Found \"" + sb + "\" horizontally L to R at "+ "(" + i + "," + j + ")");
				        		results.add(new String(sb));
				            }
				        	else
				        	{
				        		
				        	}
						   z++;
						   if(z>matrix.length-1)
						   {break;}
					   }
//					   System.out.println();
					   
				   }
			   }
		}
	   
	   public void seeDiagonalNW(MyHashTable<String> table,ArrayList<String> results, char matrix[][],int en)
		{
			StringBuilder sb = new StringBuilder();
	   
			for(int i=0; i<matrix.length; i++)
			   {
				   for(int j=0; j<matrix[0].length; j++)
				   {
					   int z = i;
					   sb.setLength(0);
					   for(int k=j; k>=0; k--)
					   {
//						   System.out.print("("+z+", "+k+") ");
						   sb.append(matrix[z][k]);
						   if(sb.length() <2)
			        		{z--;
							   if(z<0)
							   {break;}
							   continue;}
						   
						   int eVal = table.contains(sb.toString());
				        	
				        	if (eVal==0  && en==1)
				        	{
				        		sb.setLength(0);
				        		break;
				        	}
				        	else if (eVal == 1)
				            {
				        		//System.out.println("Found \"" + sb + "\" horizontally L to R at "+ "(" + i + "," + j + ")");
				        		results.add(new String(sb));
				            }
				        	else
				        	{
				        		
				        	}
						   z--;
						   if(z<0)
						   {break;}
					   }
//					   System.out.println();
					   
				   }
			   }
		}
	

	
public static void main(String args[])
{
	Scanner s1 = new Scanner(System.in);
	MyHashTable<String> table = new MyHashTable<>( );
	WordPuzzle wp = new WordPuzzle();
	
	System.out.println("Enter noumber of rows and columns: ");
	int row = s1.nextInt();
	int col = s1.nextInt();
	
	if(row<1 || col<1)
	{
		System.out.println("Enter row and column greater than 0 !");
		s1.close();
	}
	else
	{
		System.out.println("Enter 0 for normal, 1 for enhanced algorithm: ");
		int en = s1.nextInt();
		
		char[][] matrix = new char[row][col];
		

		
		Random rand = new Random();
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				matrix[i][j] = (char) (97 + rand.nextInt(26));
			}
		}
		
	   // display puzzle
	   System.out.println("************************************************");
	   System.out.println("The word puzzle is: ");
	   for (int i=0; i<matrix.length; i++)
	   {
	      for (int j=0; j<matrix[i].length; j++)
	         System.out.print(matrix[i][j] + " ");
	      System.out.println();
	   }
	
		
	   //load dictionary file into hash table
	   
	   /********Select one of the path(and edit as required) from below depending on the location of dictionary.txt file********/
//	   String dictionaryPath = "D:/MyStudy/UTD/sem1/Assignments/A&DS/proj 3/dictionary.txt"; 
	   String dictionaryPath = "dictionary.txt";
	   System.out.println("************************************************");
	   wp.loadDictionary(dictionaryPath, table,en);
//	   table.printMyHash();

	   // check for words 
	
	   ArrayList<String> wordsFound = new ArrayList<>();
	  
	   long startTime = System.currentTimeMillis( );
	   
	   wp.seeHorizontalWE(table, wordsFound, matrix,en);
	   wp.seeHorizontalEW(table, wordsFound, matrix,en);
	   wp.seeVerticalNS(table, wordsFound, matrix,en);
	   wp.seeVerticalSN(table, wordsFound, matrix,en);
	   wp.seeDiagonalNE(table, wordsFound, matrix,en);
	   wp.seeDiagonalSW(table, wordsFound, matrix,en);
	   wp.seeDiagonalNW(table, wordsFound, matrix,en);
	   wp.seeDiagonalSE(table, wordsFound, matrix,en);
	   
	   
	   long endTime = System.currentTimeMillis( );
	   
	   System.out.println("************************************************");
	   System.out.println("Printing words found: ");
	   for(String a: wordsFound)
	   {
		   System.out.println(a);
	   }
	   System.out.println("************************************************");
	   System.out.println("Total "+wordsFound.size()+" words found, time taken = "+(endTime-startTime)+" ms");
	   
	   
   
	}
}
}