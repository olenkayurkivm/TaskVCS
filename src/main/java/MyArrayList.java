import java.util.Arrays;


 class MyArrayList {
    private static final int DEFAULT_CAPACITY = 10;
    private String[] elements;
    private int currentSize;

     MyArrayList() {
        elements = new String[DEFAULT_CAPACITY];
        currentSize = 0;
    }

     MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal capacity: " + initialCapacity);
        }
        elements = new String[initialCapacity];
        currentSize = 0;
    }

     void add(String element) {
        getFirstNULL();
        if (getFirstNULL() == -1) {
            ensureCapacity();
        }
        elements[getFirstNULL()] = element;
        currentSize++;
    }

     String get(int index) {
        if (index < 0 || index >= elements.length) {
            throw new IndexOutOfBoundsException();
        } else {
            return elements[index];
        }
    }

    private int getFirstNULL() {
        int firstNULL = -1;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                firstNULL = i;
                break;
            }
        }
        return firstNULL;
    }


    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    private void ensureIndexCapacity() {
        int newSize = elements.length + 1;
        elements = Arrays.copyOf(elements, newSize);
    }

     void add(int index, String element) {
        if (index >= 0) {
            if (index <= elements.length) {
                if (elements[index] == null) {
                    elements[index] = element;
                    currentSize++;
                } else {
                    System.arraycopy(elements, index, elements, index + 1, elements.length - index);
                    elements[index] = element;
                    currentSize++;
                }
            } else if (index >= elements.length) {
                ensureIndexCapacity();
                elements[index] = element;
                currentSize++;
            }
        } else {
            throw new IllegalArgumentException("Illegal index: " + index);
        }
    }

     String remove(int indx) {
        if (indx >= 0 || indx <= elements.length) {
            String removed = elements[indx];
            int shift = elements.length - indx - 1;
            if (shift > 0) {
                System.arraycopy(elements, indx + 1, elements, indx, shift);
            }
            elements[getLastNotNULL()] = null;
            currentSize--;
            return removed;
        } else {
            throw new IllegalArgumentException("Illegal index: " + indx);
        }
    }

     void remove(Object o) {
        for (int i = 0; i < elements.length; i++) {
            if (o.equals(elements[i])) {
                int shift = elements.length - i - 1;
                if (shift > 0) {
                    System.arraycopy(elements, i + 1, elements, i, shift);
                }
                elements[getLastNotNULL()] = null;
                currentSize--;
            }
        }
    }

    private int getLastNotNULL() {
        int lastNotNULL = elements.length - 1;
        for (int i = elements.length - 1; i >= 0; i--) {
            if (elements[i] != null) {
                lastNotNULL = i;
                break;
            }
        }
        return lastNotNULL;
    }

    int size() {
        return currentSize;
    }

     boolean isEmpty() {
        return currentSize == 0;
    }
}
