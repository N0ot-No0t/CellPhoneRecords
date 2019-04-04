import javafx.scene.control.Cell;

import java.util.NoSuchElementException;

public class CellList {

    class CellNode {

        private CellPhone cellPhone;
        private CellNode next;

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
         * @param cellPhone cell phone object
         * @param node      node object
         */
        public CellNode(CellPhone cellPhone, CellNode node) {

            this.cellPhone = cellPhone;
            this.next = node;

        }

        /**
         * Copy Constructor
         *
         * @param cellNode node object
         */
        public CellNode(CellNode cellNode) {

            this.cellPhone = cellNode.cellPhone;
            this.next = cellNode.next;

        }

        public CellNode clone() {

            return new CellNode(this.cellPhone, this.next);


        }

        public CellPhone getCellPhone() {
            return cellPhone;
        }

        public void setCellPhone(CellPhone cellPhone) {
            this.cellPhone = cellPhone;
        }

        public CellNode getNode() {
            return next;
        }

        public void setNode(CellNode node) {
            this.next = node;
        }
    }

    private CellNode head;
    private int size;

    /**
     * Default Constructor
     */
    public CellList() {

        this.head = null;
        this.size = 0;


    }

    /**
     * Copy Constructor
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


                    head = t2;

                } else {

                    t3 = new CellNode(t1.cellPhone, null);
                    t2.next = t3;
                    t2 = t3;

                }

                t1 = t1.next;

            }

            t2 = t3 = null;
        }

        size = cellList.size;

    }

    public CellList clone() {

        return new CellList(this);

    }


    public void addToStart(CellPhone cellPhone) {

        head = new CellNode(cellPhone, head);
        size++;

    }

    public void insertAtIndex(CellPhone cellPhone, int index) {


        try {

            if (index < 0 || index > size - 1) throw new NoSuchElementException();

        } catch (NoSuchElementException nsee) {

            System.out.println("Invalid index. Shutting down...");
            System.exit(-1);

        }

        if (index == 0) {

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
     * WIP
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

        CellNode t = head;

        for (int i = 0; i < index - 1; i++) {

            t = t.next;

        }

        t.next = t.next.next;

        size--;

    }

    /**
     * WIP
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
     * @param cellPhone cell phone object
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

    public CellNode find(long serialNum) {

        CellNode t = head;

        while (t != null) {

            if (t.cellPhone.getSerialNum() == serialNum) return t;

            t = t.next;

        }

        return null;

    }

    public boolean contains(long serialNum) {

        if (find(serialNum) != null) return true;

        return false;

    }

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
     * @param cellList second cellList used to compare
     * @return
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
