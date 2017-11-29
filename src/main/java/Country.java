
public class Country implements Comparable<Country> {
        String countryName;
        String capitalName;
        Country(String countryName, String capitalName){
            this.countryName = countryName;
            this.capitalName= capitalName;
        }

    public int compareTo(Country country){
        if(countryName.length()==country.countryName.length())
            return 0;
        else if(countryName.length()>country.countryName.length())
            return 1;
        else
            return -1;
    }
}
