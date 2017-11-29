import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


 class TestList {
    private static final Logger LOG = Logger.getLogger(TestList.class);
    static void testList () {
       MyArrayList myList = new MyArrayList();
       List<String> arrayList = new ArrayList<>();
       String str = "new string";
       int addLoading = 100000;
       int removeLoading = 20000;
       int getLoading = 20000;
       addInMyList(myList, addLoading, str);
       addInArrayList(arrayList, addLoading, str);
       removeFromMyList(myList, removeLoading, str);
       removeFromArrayList(arrayList, removeLoading, str);
       getFromMyList(myList, getLoading);
       getFromArrayList(arrayList, getLoading);
   }
       private static void addInMyList (MyArrayList myList, int addLoading, String str ) {
           long startAdd1 = System.currentTimeMillis();
           for (int i = 1; i <= addLoading; i++) {
               myList.add(str);
           }
           int timeAdd1 = (int) (System.currentTimeMillis() - startAdd1);
           LOG.info(String.format("Performance of myList.add() %d on %d elements", timeAdd1, myList.size()));
       }
    private static void addInArrayList (List<String> arrayList, int addLoading, String str ) {
        long startAdd2 = System.currentTimeMillis();
        for (int i = 1; i <= addLoading; i++) {
            arrayList.add(str);
        }
        int timeAdd2 = (int) (System.currentTimeMillis() - startAdd2);
        LOG.info(String.format("Performance of ArrayList.add() %d on %d elements", timeAdd2, arrayList.size()));
    }
    private static void removeFromMyList (MyArrayList myList, int removeLoading, String str) {
        long startRemove1 = System.currentTimeMillis();
        for (int i = 1; i <= removeLoading; i++) {
            myList.remove(str);
        }
        int timeRemove1 = (int) (System.currentTimeMillis() - startRemove1);
        LOG.info(String.format("Performance of myList.remove() %d on %d elements", timeRemove1, removeLoading));
    }
    private static void removeFromArrayList (List<String> arrayList, int removeLoading, String str ) {
        long startRemove2 = System.currentTimeMillis();
        for (int i = 1; i <= removeLoading; i++) {
            arrayList.remove(str);
        }
        int timeRemove2 = (int) (System.currentTimeMillis() - startRemove2);
        LOG.info(String.format("Performance of ArrayList.remove() %d on %d elements", timeRemove2, removeLoading));
    }
    private static void getFromMyList (MyArrayList myList, int getLoading) {
        long startGet1 = System.currentTimeMillis();
        for (int i = 0; i < getLoading; i++) {
            myList.get(i);
        }
        int timeGet1 = (int) (System.currentTimeMillis() - startGet1);
        LOG.info(String.format("Performance of myList.get() %d on %d elements", timeGet1, getLoading));
    }
    private static void getFromArrayList (List<String> arrayList, int getLoading) {
       long startGet2 = System.currentTimeMillis();
       for (int i = 0; i<getLoading; i++){
           arrayList.get (i);
       }
       int timeGet2 = (int)(System.currentTimeMillis() - startGet2);
       LOG.info(String.format("Performance of ArrayList.get() %d on %d elements", timeGet2, getLoading));
}
}
