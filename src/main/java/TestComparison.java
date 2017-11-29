import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

 class TestComparison {
    private static final Logger LOG = Logger.getLogger(TestComparison.class);

     static void useCompareableAndComparator () {
         String[] countryNames = {"USA", "UK", "Canada", "Ukraine"};
         String[] capitalNames = {"Washington", "London", "Ottawa", "Kyiv"};
         List<Country> countries1 = new ArrayList<>();
         Country[] countries2 = new Country[countryNames.length];
         for (int i = 0; i < countryNames.length; i++) {
             countries1.add(new Country(countryNames[i], capitalNames[i]));
             countries2[i] = new Country(countryNames[i], capitalNames[i]);
         }
         sortArrayListUsingComparable(countries1);
         sortArrayUsingComparable(countries2);
         sortArrayListUsingComparator(countries1);
         sortArrayUsingComparator(countries2);
         bynarySearchUsingComparator(countries1);
     }
        private static void sortArrayListUsingComparable (List<Country> countries1) {
            Collections.sort(countries1);
            LOG.info("Sorting ArrayList: ");
            for (Country country : countries1) {
                LOG.info(String.format("Country: %s Capital: %s", country.countryName, country.capitalName));
            }
        }
    private static void sortArrayUsingComparable (Country [] countries2) {
        Arrays.sort(countries2);
        LOG.info("Sorting an Array: ");
        for (Country country : countries2) {
            LOG.info(String.format("Country: %s Capital: %s", country.countryName, country.capitalName));
        }
    }
    private static void sortArrayListUsingComparator (List<Country> countries1) {
        Collections.sort(countries1, new CapitalComparator());
        LOG.info("Sorting ArrayList using Capital Comparator (in natural order): ");
        for (Country country : countries1) {
            LOG.info(String.format("Country: %s Capital: %s", country.countryName, country.capitalName));
        }
    }
    private static void sortArrayUsingComparator (Country [] countries2) {
        Arrays.sort(countries2, new CapitalComparator());
        LOG.info("Sorting an Array using Capital Comparator (in natural order): ");
        for (Country country : countries2) {
            LOG.info(String.format("Country: %s Capital: %s", country.countryName, country.capitalName));
        }
    }
    private static void bynarySearchUsingComparator (List <Country> countries1){
        int index = Collections.binarySearch(countries1, new Country ("USA", "Washington"), new CapitalComparator ());
        LOG.info (String.format ("USA was found at index %d", index));
        int index2 = Collections.binarySearch(countries1, new Country ("USA", "Paris"), new CapitalComparator ());
        LOG.info (String.format ("USA was found at index %d", index2));
    }
}

