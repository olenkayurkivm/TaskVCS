import java.util.Comparator;


public class CapitalComparator implements Comparator <Country> {

    @Override
    public int compare (Country country1, Country country2){
        String capital1 = country1.capitalName;
        String capital2 = country2.capitalName;
        return capital1.compareTo (capital2);
    }
}
