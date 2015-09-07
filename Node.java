class Node<E> {
  E data;
  Node link;
  Node(E data, Node link) {
    this.data = data;
    this.link = link;
  }
  public void setData(E data) {
    this.data = data;
  }
  public void setLink(Node link) {
    this.link = link;
  }
  public E getData() {
    return data;
  }
  public Node getLink() {
    return link;
  }
}
