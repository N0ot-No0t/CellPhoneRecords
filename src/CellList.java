
import java.util.NoSuchElementException;
import java.util.Random;

public class CellList {

    class CellNode {

        private CellPhone cellPhone; //cell phone object pointer inside the node
        private CellNode next; //pointer to the next node

        /**
         * Default Constructor
         */
        public CellNode() {

            this.cellPhone = null;
            this.next = null;

        }

        /**
         * Parameterized Constructor
         *
         * @param cellPhone cell phone object pointer
         * @param node      node object
         */
        public CellNode(CellPhone cellPhone, CellNode node) {

            this.cellPhone = cellPhone;
            this.next = node;

        }

        /**
         * Copy Constructor
         *
         * @param cellNode node object pointer
         */
        public CellNode(CellNode cellNode) {

            this.cellPhone = cellNode.cellPhone;
            this.next = cellNode.next;

        }

        /**
         * copy constructor for the node class
         *
         * @return a copy of the node
         */
        public CellNode clone() {

            return new CellNode(this.cellPhone, this.next);


        }

        /**
         * Accessor method for the cell phone inside the node
         *
         * @return a cell phone
         */
        public CellPhone getCellPhone() {
            return cellPhone;
        }

        /**
         * Mutator method for the cell phone inside the node
         * @param cellPhone cell phone object pointer
         */
        public void setCellPhone(CellPhone cellPhone) {
            this.cellPhone = cellPhone;
        }

        /**
         * Accessor method for the next node pointer
         * @return node pointer [PRIVACY LEAK, METHOD SHOULD BE PRIVATE]
         */
        public CellNode getNode() {
            return next;
        }

        /**
         * Mutator method for the next node pointer
         * @param node node pointer [PRIVACY LEAK]
         */
        public void setNode(CellNode node) {
            this.next = node;
        }
    }

    private CellNode head; //point to the 1st node in the list
    private int size; //size of the list (keeps track of the number of nodes)
    private Random r = new Random();

    /**
     * Default Constructor
     */
    public CellList() {

        this.head = null;
        this.size = 0;


    }

    /**
     * Copy Constructor (deep copy)
     *
     * @param cellList cellList object
     */
    public CellList(CellList cellList) {

        if (cellList.head == null) {
            head = null;
        } else {
            head = null;
            CellNode t1, t2, t3;

            t1 = cellList.head;
            t2 = t3 = null;

            while (t1 != null) {

                if (head == null) {

                    t2 = new CellNode(t1.cellPhone, null);
                    t2.getCellPhone().setSerialNum(r.nextInt(8999999)+1000000);


                    head = t2;

                } else {

                    t3 = new CellNode(t1.cellPhone, null);
                    t3.getCellPhone().setSerialNum(r.nextInt(8999999)+1000000);
                    t2.next = t3;
                    t2 = t3;

                }

                t1 = t1.next;

            }

            t2 = t3 = null;
        }

        size = cellList.size;

    }

    /**
     * clone method that will copy a list
     * @return
     */
    public CellList clone() {

        return new CellList(this);

    }

    /**
     * This method will take a given cellPhone object and will create a new node with the object which will be linked and placed at the beginning of the list
     * @param cellPhone cellPhone object
     */
    public void addToStart(CellPhone cellPhone) {

        head = new CellNode(cellPhone, head);
        size++;

    }

    /**
     * Inserts a node at the specified index. (Note: it is impossible to add an object at the end of the list as the limit is size - 1)
     *
     * @param cellPhone cell phone object pointer
     * @param index index given by the user
     */
    public void insertAtIndex(CellPhone cellPhone, int index) {


        try {

            if (index < 0 || index > size - 1) throw new NoSuchElementException();

        } catch (NoSuchElementException nsee) {

            System.out.println("Invalid index. Shutting down...");
            System.exit(-1);

        }

        if (index == 0) { //special case if the index is at the beginning

            head = new CellNode(cellPhone, head);

        }

        CellNode t = head;

        for (int i = 0; i < index - 1; i++) {

            t = t.next;

        }

//        if(index == size - 1 || index == size - 2){
//            t.next.next = new CellNode(cellPhone, t.next.next);
//        }else {
        t.next = new CellNode(cellPhone, t.next);
        //}

        size++;

    }

    /**
     * Moves the pointer from the node before the index to the node after the index
     *
     * @param index the index from which a node will be deleted
     */
    public void deleteFromIndex(int index) {

        try {

            if (index < 0 || index > size - 1) throw new NoSuchElementException();

        } catch (NoSuchElementException nsee) {

            System.out.println("Invalid index. Shutting down...");
            System.exit(-1);

        }

        if (index == 0) { //special case when the index is on the 1st node
            deleteFromStart();
            return;
        }

        CellNode t = head;

        for (int i = 0; i < index - 1; i++) {

            t = t.next;

        }

        t.next = t.next.next;

        size--;

    }

    /**
     * Deletes the 1st node in the list (the one being pointed by the head pointer)
     * This is done by moving the head pointer to the next node which leaves the previous node to the garbage collector
     */
    public void deleteFromStart() {

        if (head == null) {
            System.out.println("Cannot delete element from empty array");
            return;
        }

        head = head.next;

        size--;

    }

    /**
     * replaces the cell phone inside the specified node with another cell phone
     *
     * @param cellPhone cell phone object pointer
     * @param index     index at which the node will be replace
     */
    public void replaceAtIndex(CellPhone cellPhone, int index) {

        try {

            if (index < 0 || index > size - 1) throw new NoSuchElementException();

        } catch (NoSuchElementException nsee) {

            System.out.println("Invalid index. Shutting down...");
            System.exit(-1);

        }

        CellNode t = head;

        for (int i = 0; i < index; i++) {

            t = t.next;

        }

        t.cellPhone = cellPhone;

    }

    /**
     * This method will check through the specified cell list to see if it has a cell phone with the given serial number
     *
     * @param serialNum serial number given as a parameter
     * @return a cell phone node pointer [PRIVACY LEAK ISSUES, RETURNING A POINTER CAN BE VERY DANGEROUS AS IT CAN ALLOW THE USER TO DESTROY THE WHOLE LIST]
     * [It is better if the method is defined as private to prevent its usage outside the class]
     */
    public CellNode find(long serialNum) {

        CellNode t = head;

        while (t != null) {

            if (t.cellPhone.getSerialNum() == serialNum) return t;

            t = t.next;

        }

        return null;

    }

    /**
     * Checks if the specified cell list contains a cell phone with the given serial number
     *
     * @param serialNum serial number given as a parameter
     * @return true if it contains a cell phone with the given serial number or false if it doesn't
     */
    public boolean contains(long serialNum) {

        if (find(serialNum) != null) return true;

        return false;

    }

    /**
     * Displays the cellList with all its cellPhone object in a Linked List conceptual format
     */
    public void showContents() {

        CellNode t = head;

        int index = 0;

        if (t == null) {
            System.out.println("List is empty, there is nothing to display.");
        } else {

            System.out.println("The current size of the list is " + size + ". Here are the contents of the list");
            System.out.println("====================================================================");

            while (t != null) {

                System.out.print(t.cellPhone + " {" + index + "} ---> ");
                t = t.next;
                index++;

            }

            System.out.println("X\n\n");

        }
    }

    /**
     * equals method used to compare 2 cell lists
     * @param cellList second cellList used for comparison
     * @return true if the cell lists have the same contents (apart from the serial numbers)
     */
    public boolean equals(CellList cellList) {

        CellNode t1 = head;
        CellNode t2 = cellList.head;

        while (t1 != null && t2 != null) {

            if (!t1.cellPhone.getBrand().equals(t2.cellPhone.getBrand()) || t1.cellPhone.getYear() != t2.cellPhone.getYear() || t1.cellPhone.getPrice() != t2.cellPhone.getPrice()) {

                return false;

            }

            t1 = t1.next;
            t2 = t2.next;

        }

        return true;

    }


}
