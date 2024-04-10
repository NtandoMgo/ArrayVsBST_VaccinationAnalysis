public class Vaccine implements Comparable<Vaccine>{
    
    String countryName;
    String date;
    String  noOfCases;

    public Vaccine(String line){

        String[] lyn = line.split(",");
        countryName = lyn[0];
        
        try {
            date = lyn[1];
        } catch (Exception e) {
            //TODO: handle exception
          //  System.out.println("x");
        }
        
        
        try {
            noOfCases = lyn[2];
        } catch (Exception e) {
            noOfCases = "0";
        }

    }

    public String getCountryName() {
        return countryName;
    }

    public String getDate() {
        return date;
    }

    public String getNoOfCases() {
        return noOfCases;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNoOfCases(String noOfCases) {
        this.noOfCases = noOfCases;
    }

    @Override
    public String toString() {
        return countryName +  " = "+ noOfCases;
    }

    /*@Override
    public int compareTo(Vaccine o) {
        // TODO Auto-generated method stub
        return 0;
    }*/

    @Override
    public int compareTo(Vaccine o) {

        String countryDate = this.countryName + this.date;
        String otherCountryDate = o.countryName + o.date;

        return countryDate.compareTo(otherCountryDate);
    }
}
