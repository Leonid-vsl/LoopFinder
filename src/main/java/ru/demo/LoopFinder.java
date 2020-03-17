package ru.demo;

import ru.demo.list.SingleConnectedList;

import java.util.Iterator;

public class LoopFinder {


    public static <E> boolean containsLoop(SingleConnectedList<E> linkedList) {

        Iterator<E> iterator = linkedList.iterator();
        Iterator<E> fastIterator = linkedList.iterator();
        return hasLoop(iterator, fastIterator);
    }

    private static <E> boolean hasLoop(Iterator<E> iterator, Iterator<E> fastIterator) {

        while (iterator.hasNext()) {

            E item = iterator.next();
            E item2 = null;
            if (fastIterator.hasNext()) {
                fastIterator.next();
                item2 = fastIterator.next();
            }

            if (item2 == null) {
                break;
            } else if (item2 == item) {
                return true;
            }
        }
        return false;
    }

    public static <E> E findLoopEnterItem(SingleConnectedList<E> linkedList) {

        Iterator<E> iterator = linkedList.iterator();
        Iterator<E> fastIterator = linkedList.iterator();

        if (hasLoop(iterator, fastIterator)) {
            Iterator<E> fromBeginningItr = linkedList.iterator();
            E enter;
            while ((enter = fromBeginningItr.next()) != fastIterator.next()) ;
            return enter;
        } else {
            return null;
        }
    }

}
