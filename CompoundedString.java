import java.io.FileInputStream;
import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.FileNotFoundException;
import java.io.IOException;
public class CompoundedString {
	public static void main(String[] args) throws FileNotFoundException {
	//Importing input file
        int c=0,i=0;
		long start = System.currentTimeMillis();
        Scanner sc = new Scanner(new FileInputStream("Input2.txt"));//import the text file here
        Scanner sc2 = new Scanner(new FileInputStream("Input2.txt"));//as well as here.
		 
        while(sc.hasNextLine()) {
           String line = sc.nextLine();
           c++;
        }
        String s[]=new String[c];
        while(sc2.hasNextLine()) {
            String line = sc2.nextLine();
            s[i] = line.trim().toLowerCase();
           i++;
        }
		long end = System.currentTimeMillis();
        //Main Logic
        String final_s[] = new String[2];
		//Sort has been done in decreasing order
        for(i = 0; i<c ;i++)
		{
			String temp = s[i];
			int j = i-1;
			while(j>=0 && temp.length()>s[j].length())
			{
				s[j+1] = s[j];
				j--;
			}
			s[j+1] = temp;
		}							

		int k = 0;
		for(i = 0; i<c ; i++)
		{
			String temp1 = s[i];
			for(int j = i+1 ; j<c ; j++)
			{
				temp1 = temp1.replaceAll(s[j] , "");
			
			}
			
			if(temp1.equals(""))
			{
				
				final_s[k++] = s[i];
			}
			if(k==2)
				break;
		}
		long time=0;
		time=(end-start);
		System.out.println();
		System.out.println("Longest Compounded String: "+final_s[0]);
        System.out.println("Second Longest Compounded String: "+final_s[1]);
		System.out.println("Time taken to process the input file: "+time+"ms");
	}
}