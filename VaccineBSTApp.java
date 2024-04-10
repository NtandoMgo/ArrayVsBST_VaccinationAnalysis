import java.io.File;
import java.util.Scanner;

public class VaccineBSTApp {
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner (System.in);

        BinarySearchTree<Vaccine> bst = new BinarySearchTree<Vaccine>();

        
        try {
            
            Scanner scan = new Scanner (new File ("data/vaccinations.csv"));

            while (scan.hasNextLine()){

                String entry = scan.nextLine();
                //System.out.println(entry);
                bst.insert(new Vaccine(entry));
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("File not found");
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
    keyboard.close();
    String[] copyCountryArray = new String[count];
      // int p = 0;
    for (int p = 0; p<count; p++){
        copyCountryArray[p] =  countries[p];
    }

    boolean foundCountry = false;

    for (int j = 0; j < copyCountryArray.length; j++) {
        
        String vaccineVariable = copyCountryArray[j] + ","+date;
        Vaccine usrInput = new Vaccine(vaccineVariable);

        if (bst.find(usrInput) != null){
            
            BinaryTreeNode<Vaccine> nodeFoundNew = bst.find(usrInput);

            Vaccine v = nodeFoundNew.data;
            String nameOfCountry = v.getCountryName();
            String vac = v.getNoOfCases();
             foundCountry = true;
            System.out.println(nameOfCountry +" = "+ vac);

        } else {
            System.out.println(copyCountryArray[j] +" = <Not Found>");
        
        }

    }
    System.out.println("opCountInsert = "+ bst.opCountInsert);
    System.out.println("opCountFind = "+ bst.opCountFind);

    }

}
