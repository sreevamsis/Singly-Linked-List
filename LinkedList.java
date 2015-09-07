@SuppressWarnings("unchecked")

class LinkedList<E> {
  Node<E> start;
  Node<E> end;
  int size;
  LinkedList() {
    start  = null;
    end = null;
    size = 0;
  }
  public int getSize() {
    return size;
  }
  public void insert(E data) {
    Node<E> element = new Node<E>(data,null);    
    size++;    
    if(start == null) {
      start = element;
      end = start;
    } else {
      end.setLink(element);
      end = element;
    }
  }
  public void insertAfter(E data, E after) {
    int flag = 0;
    Node<E> element = start;
    while (element.getLink() != null) {
      flag = 0;
      if (element.getData() == after) {
        flag = 1;
        Node<E> temp = element;
        Node<E> newelement = new Node<E>(data,element.getLink());
        element.setLink(newelement);
        element = newelement;
        break;
      }
      element = element.getLink();
    }
    if (flag == 0) {
      Node<E> temp = element;
      Node<E> newelement = new Node<E>(data,element.getLink());
      element.setLink(newelement);
      element = newelement;
      end = element;
    }
    size++;
  }
  public void insertBefore(E data, E before) {
    int flag = 0;
    Node<E> element = start;
    Node<E> temp = element;
    while (element.getLink() != null) {
      flag = 0;
      if (element.getData() == before) {
        flag = 1;
        Node<E> newelement = new Node<E>(data, temp.getLink());
        temp.setLink(newelement);
        break;
      }
      temp = element;
      element = element.getLink();
    }
    if (flag == 0) {
      Node<E> newelement = new Node<E>(data, temp.getLink());
      temp.setLink(newelement);
    }
    size++;
  }
  public void remove(int index) {
    int flag = 0;
    Node<E> element = start;
    if (index == 0) {
      element = element.getLink();
      start = element;  
    }
    element = start;
    Node<E> temp = start;
    int i = 0;
    while (element.getLink() != null) {
      flag = 0;
      if (i == index) {
        flag = 1;
        element = element.getLink();
        temp.setLink(element);
        break;
      }
      temp = element;
      element = element.getLink();
      i++;
    }
    if (flag == 0) {
      element = element.getLink();
      temp.setLink(element);
      end = temp;
    }
    size--;
  }
  public void removeElement(E data) {
    int flag = 0;
    Node<E> element = start;
    if (element.getData() == data) {
      element = element.getLink();
      start = element;  
    }
    Node<E> temp = element;
    while (element.getLink() != null) {
      flag = 0;
      if (element.getData() == data) {
        flag = 1;
        element = element.getLink();
        temp.setLink(element);
        break;
      }
      temp = element;
      element = element.getLink();
    }
    if (flag == 0) {
      element = element.getLink();
      temp.setLink(element);
      end = temp;
    }
    size--;
  }
  public void popFront() {
    Node<E> element = start;
    element = element.getLink();
    start = element;
    size--;
  }
  public void popBack() {
    Node<E> element = start;
    Node<E> temp = element;
    int i = 0;
    while (element.getLink() != null) {
      if (i == getSize() - 2) {
        Node<E> newelement = new Node<E>(element.getData(), null);
        element = element.getLink();
        temp.setLink(newelement);
        end = newelement;
        break;
      }
      temp = element;
      element = element.getLink();
      i++;
    }
    size--; 
  }
  public void pushFront(E data) {
    Node<E> newelement = new Node<E>(data, null);
    newelement.setLink(start);
    start = newelement;
    size++;
  }
  public void concat(LinkedList<E> newlist) {
    Node<E> element = start;
    int i = 0;
    while (element.getLink() != null) {
      if (i == getSize() - 2) {
        Node<E> newelement = newlist.start;
        element = element.getLink();
        element.setLink(newelement);
        break;
      }
      element = element.getLink();
      i++;
    }
    int newsize = newlist.getSize();
    size = size + newsize;
  }
  public void concatAt(int index, LinkedList<E> newlist) {
    int flag = 0;
    Node<E> element = start;
    Node<E> newstart = newlist.start;
    Node<E> newend = newlist.end;
    if (index == 0) {
      flag = 1;
      newend.setLink(element);
      start = newstart;
    }
    element = start;
    Node<E> temp = start;
    int i = 0;
    while ((element.getLink() != null) && (index != 0)) {
      flag = 0;
      if (i == index) {
        flag = 1;
        newend.setLink(element);
        temp.setLink(newstart);
        break;
      }
      temp = element;
      element = element.getLink();
      i++;
    }
    if ((flag == 0) && (index == size - 1)) {
      flag = 1;
      newend.setLink(element);
      temp.setLink(newstart);
    }
    if (flag == 1) {
      int newsize = newlist.getSize();
      size = size + newsize;
    }
  }
  public void makeEmpty() {
    start = null;
  }
  public void getList() {
    if (start == null) {
      System.out.println("list is empty");
    } else {
      Node<E> element = start;
      if (start.getLink() == null) {
        System.out.print(element.getData());
      } else {
        System.out.print(element.getData() + "-");
        element = start.getLink();
        while (element.getLink() != null) {
          System.out.print(element.getData() + "-");
          element = element.getLink();
        }
        System.out.println(element.getData());
      }
    }
  }
}