package ru.demo.list;

class ListNode<E> {

    private ListNode<E> next;
    private final E data;

    public ListNode(E data) {
        this.data = data;
    }

    ListNode<E> getNext() {
        return next;
    }

    void setNext(ListNode<E> next) {
        this.next = next;
    }

     E getData() {
        return data;
    }
}
