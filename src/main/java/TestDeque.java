import org.apache.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;


 class TestDeque {
    private static final Logger LOG = Logger.getLogger(TestDeque.class);
     static void testDeque (){
        Deque <String>deque1 = new LinkedList<>();
        Deque <Integer> deque2 = new ArrayDeque <>();
        String str1 = "New entry";
        String str2 = "One more new entry";
        String str3 = "And more";
        deque1.add (str1);
        deque1.addFirst (str1);
        deque1.addLast (str2);
        deque1.addFirst(str3);
        deque1.add(str3);
        LOG.info (String.format("First element in deque1: %s", deque1.getFirst()));
        LOG.info (String.format("Last element in deque1: %s", deque1.getLast()));
        LOG.info (String.format("Removing first element in deque1: %s", deque1.removeFirst()));
        LOG.info (String.format("Removing first element in deque1: %s", deque1.removeFirst()));
        deque2.offer(1);
        deque2.offerFirst(2);
        deque2.offerLast(10);
        LOG.info (String.format("First element in deque1: %d", deque2.peekFirst()));
        LOG.info (String.format("Last element in deque1: %d", deque2.peek()));
        LOG.info (String.format("Removing first element in deque1: %d", deque2.pollLast()));
    }
}
