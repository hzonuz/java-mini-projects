class Node {
    Integer data;
    Node next;
    Node(Integer data)
    {
        this.data = data;
        next = null;
    }
}
public class LinkedList {
    Node head;
    Node last;

    public LinkedList() {
        head = null;
        last = null;
    }
    public LinkedList(Integer element) {
        head = new Node(element);
        last = head;
    }
    public boolean add(Integer element) {
        add(size(),element);
        return true;
    }
    public void add(int index , Integer element) {
        Node currNode = head;
        Node newNode = new Node(element);
        if(head == null) {
            head = newNode;
        }
        else if (index == 0) {
            newNode.next = head;
            head = newNode;
        }
        else {
            for (int i = 0; i < index - 1; i++) {
                currNode = currNode.next;
            }
            newNode.next = currNode.next;
            currNode.next = newNode;
        }
        if(index == size() -1)
            last = newNode;
    }
    public boolean addAll(LinkedList linkedlist) {
        if(head == null) {
            head = linkedlist.head;
            last = linkedlist.last;
            return true;
        }
        else {
            last.next = linkedlist.head;
            last = linkedlist.last;
            return true;
        }
    }
    public boolean addAll(int index, LinkedList linkedlist) {
        Node currNode = head;
        if (head == null) {
            head = linkedlist.head;
            last = linkedlist.last;
        } else if (index == 0) {
            linkedlist.last.next = head;
            head = linkedlist.head;
        } else {
            for (int i = 0; i < index - 1; i++) {
                currNode = currNode.next;
            }
            if(linkedlist.last == null)
                return false;
            linkedlist.last.next = currNode.next;
            currNode.next = linkedlist.head;
        }
        return true;
    }
    public void addFirst(Integer element) {
        add(0,element);
    }
    public void addLast(Integer element) {
        add(element);
    }
    public void clear() {
        head = null;
    }
    public Integer get(int index) {
        Node currNode = head;
        for(int i = 0 ;i < index; i++) {
            currNode = currNode.next;
        }
        return currNode.data;
    }
    public int indexOf(Integer i) {
        Node currNode = head;
        for(int j = 0; currNode != null;j++) {
            if(currNode.data == i)
                return j;
            currNode = currNode.next;
        }
        return -1;
    }
    public boolean contains(Integer i) {
        return indexOf(i) != -1;
    }
    public int size() {
        int i = 1;
        Node currNode = head;
        if(isEmpty())
            return 0;
        while (currNode.next != null) {
            i++;
            currNode = currNode.next;
        }
        return i;
    }
    public Integer remove() {
        int i = head.data;
        head = head.next;
        return i;
    }
    public Integer remove(int index) {
        if(index == 0)
            return remove();
        else {
            Node currNode = head;
            int i;
            for(int j = 0;j < index - 1; j++) {
                currNode = currNode.next;
            }
            i = currNode.next.data;
            currNode.next = currNode.next.next;
            return i;
        }
    }
    public Integer[] toArray() {
        int n = size();
        Integer[] array = new Integer[n];
        Node currNode = head;
        for(int i = 0; i < n; i++) {
            array[i] = currNode.data;
            currNode = currNode.next;
        }
        return array;
    }
    public boolean isEmpty() {
        return head == null;
    }
}
class Main {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.add(5);
        list1.add(7);
        list1.add(1,8);
        list1.remove(1);
        System.out.println(list1.head.data);
        System.out.println(list1.last.data);
        LinkedList list2 = new LinkedList(2);
        list2.add(4);
        list2.add(12);
        list2.addAll(0,list1);
        Integer[] a = new Integer[list2.size()];
        a = list2.toArray();
        for(int i = 0; i<list2.size();i++)
            System.out.println(a[i]);
    }
}
