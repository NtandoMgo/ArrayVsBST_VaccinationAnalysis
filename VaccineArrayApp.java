import java.util.*;
import java.io.*;

public class VaccineArrayApp
{
   static int opCount = 0;
   public static void main(String[] args) 
   {  
      Scanner inputStream = null;
      try
   	{
   		inputStream = new Scanner(new FileInputStream("data/vaccinations.csv"));
   	}
   	catch (FileNotFoundException e)
   	{
   		System.out.println("File not found");
   		System.exit (0);
   	}
      VaccineArrayApp r = new VaccineArrayApp();
      Scanner keyboard = new Scanner(System.in);
      String[][] allData = new String[9919][];
      
      for(int i = 0; i < 9919; i++){
         String[] row = new String[3];
         String line = inputStream.nextLine();
         String[] list = line.split(",");
         String country = list[0];
         String date = list[1];
         String numberOfCases;
         try{
            numberOfCases = list[2];
         }catch(Exception g){
            numberOfCases = "0";
         }
         row[0] = country;
         row[1] = date;
         row[2] = numberOfCases;
         allData[i] = row;
      }

      System.out.println("Enter the date: ");
      String date = keyboard.nextLine();

      System.out.println("Enter the list of countries (end with an empty line):");
      
      String[] countries = new String[9919];
      String country = keyboard.nextLine();
      int i = 0;

      while (!country.equals("")){

         countries[i] = country;
         country = keyboard.nextLine();
         i++;

      }

      int count = 0;

      for (int k= 0; k < 9919;k++){

         if (countries[k] != null){
            count++;
         }
      }
      String[] copyCountryArray = new String[count];
      // int p = 0;
      for (int p = 0; p<count; p++){
         copyCountryArray[p] =  countries[p];
      }

      keyboard.close();
     
         System.out.println("Results:");

     for (int s = 0; s < count; s++){
      
         String cs = copyCountryArray[s];
         boolean found = false;

         for (int c = 0;c<9919;c++){
            String[] subData = allData[c];
            String cou = subData[0];
            String dt = subData[1];
            String noOfCases = subData[2];

            opCount ++;
            if (dt.equals(date) && cs.equals(cou)){
               System.out.println(cou+" = "+noOfCases);
               found = true;
               break;
            } 
         }

         if (!found) {
            System.out.println(cs+" = <not found>");
         }

     }
     System.out.println("opCount ="+opCount);
   }

}