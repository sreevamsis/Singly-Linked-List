class LinkedListTest {
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    LinkedList<Integer> newlist = new LinkedList<Integer>();
    list.insert(3);
    list.insert(4);
    list.insert(5);
    list.insert(6);
    newlist.insert(3);
    newlist.insert(4);
    newlist.insert(5);
    newlist.insert(6);
    list.insertAfter(8,6);
    list.insertBefore(9,8);
    list.remove(5);
    list.removeElement(9);
    list.popFront();
    list.popBack();
    list.pushFront(2);
    list.getList();
    list.concatAt(2, newlist);
    System.out.println(list.getSize());
    list.getList();
    list.makeEmpty();
    list.getList();
  }
}