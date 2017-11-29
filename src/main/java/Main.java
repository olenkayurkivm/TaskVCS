import org.apache.log4j.Logger;

import java.util.Scanner;

public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            Scanner scan = new Scanner(System.in);
            LOG.info("Press 1 to see more");
            if (scan.nextInt() == 1) {
                LOG.info(Choices.CHOICE_1.getMessage());
                LOG.info(Choices.CHOICE_2.getMessage());
                LOG.info(Choices.CHOICE_3.getMessage());
                int choice = scan.nextInt();
                if (choice == 1) {
                    TestList.testList();
                } else if (choice == 2) {
                    TestDeque.testDeque();
                } else if (choice == 3) {
                    TestComparison.useCompareableAndComparator();
                } else {
                    TestList.testList();
                }
            } else {
                running = false;
            }
        }
    }

    enum Choices {
        CHOICE_1("Press 1 to see MyArrayList VS ArrayList "), CHOICE_2("Press 2 to see Compare / Comparable"), CHOICE_3("Press 3 to see Deque");
        private String message;

        Choices(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

}
