public class LinkedList<T>  {

    // Our Nodes and the size of the LinkedList
    Node itsFirstNode;
    Node itsLastNode;
    private int size;

    // The Constructor
    public LinkedList() {
        itsFirstNode = null;
        itsLastNode = null;
        size = 0;
    }

    // getter to return the size of the List
    public int size() {
        return this.size;
    }
    
    // returns an Iterator 
    public Iterator<T> getIterator() {
        return new Iterator<T>(this);
    }

    // adds an element to the list
    public void add(T element) {

        Node node = new Node(element);

        if (itsFirstNode == null) {
            itsFirstNode = node;
            itsLastNode = node;
        }
        else {
            itsLastNode.setNextNode(node);
            node.setPriorNode(itsLastNode);
            itsLastNode = node;
        }
        size++;
    }

    // adds an element at the specified index of the list
    public void add(T element, int index) {
        int counter = 0;
        Node newNode = new Node(element);
        Node current = itsFirstNode;
        while (current != null ) {
            if (counter == index - 1 )
                break;
            current = current.getNextNode();
            counter++;
        }
        current.getNextNode().setPriorNode(newNode);
        newNode.setNextNode(current.getNextNode());
        newNode.setPriorNode(current);
        current.setNextNode(newNode);
        size++;
    }

    // getter that retrieves the Object at the specified index
    public T get(int index) {
        int counter = 0;
        Node current = itsFirstNode;
        while (current != null ) {
            if (counter == index)
                break;
            current = current.getNextNode();
            counter++;
        }
        return current.getData();
    }
    
    // returns true if element is in the list, false if not
    public boolean contains(T element) {
        Node current = itsFirstNode;
        for(int i = 0; i < this.size; i++){
            if(current.getData() == element){
                return true;
            }
            current = current.getNextNode();
        }
        return false;
    }

    // returns the index of the element if it is in the list, -1 if not found
    public int indexOf(T element) {
        Node current = itsFirstNode;
        for(int i = 0; i < this.size; i++){
            if(current.getData() == element){
                return i;
            }
            current = current.getNextNode();
        }
        return -1;
    }

    // returns an Iterator at the location of the element if it is in the list
    // returns the null reference if the element is not found
    public Iterator<T> iteratorAt(T element) {
        Iterator<T> iter = this.getIterator();
        while(iter.hasNext()){
            T whatever = iter.next();
            if(whatever == element){
                return iter;
            }
        }
        return null;
    }

    public String toString() {
        String returnVal = "";
        Node current = itsFirstNode;
        if (size != 0 ) {
            while (current != null ) {
                returnVal += current.toString();
                returnVal += "\n";
                current = current.getNextNode();
            }
        }
        return returnVal;
    }  // end toString

    // The Node class that we used in the LinkedList
    class Node {
    
        private T data;
        private Node itsNext;
        private Node itsPrior;
    
        public Node(T data) {
            itsNext = null;
            itsPrior = null;
            this.data = data;
        }
    
    
        public T getData() {
            return this.data;
        }
    
        public Node getNextNode() {
            return itsNext;
        }
        
        public Node getPriorNode() {
            return itsPrior;
        }  
    
        public void setNextNode(Node next) {
            itsNext = next;
        }

        public void setPriorNode(Node prior) {
            this.itsPrior = prior;
        }
    
        public String toString() {
            return data.toString();
        }
    
    }  // end of Node
}
