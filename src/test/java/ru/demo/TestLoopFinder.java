package ru.demo;

import org.junit.Assert;
import org.junit.Test;
import ru.demo.list.SingleConnectedList;

import java.util.ArrayList;
import java.util.List;

import static ru.demo.LoopFinder.findLoopEnterItem;

public class TestLoopFinder {

    @Test
    public void testThatListImplIsWorking() {

        SingleConnectedList<String> list = new SingleConnectedList<>();

        list.addItem("1");
        list.addItem("1");
        list.addItem("1");

        Assert.assertEquals("[ 1 , 1 , 1 ] size: 3", list.toString());


        list.addLoop(1);
        Assert.assertEquals("[ 1 , 1* , 1 ] size: 3", list.toString());

    }

    @Test
    public void testThatListNotContainsLoop() {

        SingleConnectedList<String> list = new SingleConnectedList<>();

        list.addItem(new String("1"));
        list.addItem(new String("1"));
        list.addItem(new String("1"));

        Assert.assertFalse(LoopFinder.containsLoop(list));


    }


    /**
     * lets assume that we are checking element by reference if we faced with element with same ref
     * <p>
     * it means that this is loop
     */
    @Test
    public void testThatListContainsLoop() {

        SingleConnectedList<String> list = new SingleConnectedList<>();

        list.addItem(new String("1"));
        list.addItem(new String("1"));
        list.addItem(new String("1"));
        list.addLoop(1);

        Assert.assertTrue(LoopFinder.containsLoop(list));


        int dataSet = 30;
        for (int i = 0; i < dataSet; i++) {
            list = createList(dataSet);
            list.addLoop(i);

            System.out.println(list);
            Assert.assertEquals(String.valueOf(i + 1), findLoopEnterItem(list));


        }

    }

    private SingleConnectedList<String> createList(int size) {
        SingleConnectedList<String> list = new SingleConnectedList<>();

        for (int i = 1; i <= size; i++) {
            list.addItem(String.valueOf(i));
        }

        return list;
    }

}
