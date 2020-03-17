package ru.demo.list;

import java.util.Iterator;
import java.util.Objects;

/**
 * Test purposes implementation of linked list
 *
 * @param <E>
 */
public class SingleConnectedList<E> {

    private ListNode<E> head;
    private ListNode<E> last;
    private int loopEnter = -1;
    private int size;

    /**
     * Add to end of list
     */
    public void addItem(E item) {
        Objects.requireNonNull(item);
        ListNode<E> newNode = new ListNode<>(item);
        if (last != null) {
            last.setNext(newNode);
            last = newNode;
        } else {
            last = head = newNode;
        }
        size++;
    }

    /**
     * Let assume that we might have list only with loop in the end
     * for task perspective will be enough
     * <p>
     * [1] -> [2] -> [3] -> [4]
     *                |      |
     *               [6] <- [5]
     */
    public void addLoop(int to) {

        if (to < 0 || to > size - 1) throw new IndexOutOfBoundsException();

        int i = 0;
        ListNode<E> current = head;
        while (i != to) {
            current = current.getNext();
            i++;
        }
        last.setNext(current);
        loopEnter = to;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        Iterator<E> iterator = iterator();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(iterator.next().toString() + "");
            if (i == loopEnter) {
                stringBuilder.append("*");
            }
            if (i < size - 1) {
                stringBuilder.append(" , ");
            }
        }
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }

    /**
     * Simple implementation for task purposes without modCnt check
     *
     * @return
     */
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            private ListNode<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E data = null;
                if (current != null) {
                    data = current.getData();
                    current = current.getNext();
                }
                return data;
            }
        };

    }

}
