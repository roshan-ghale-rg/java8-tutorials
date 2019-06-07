package com.ghale.datastructures;

public class LinkedlistClass {
    /**
     * inserting the node at the specific position.
     * @param head
     * @param data
     * @param position
     * @return head
     */

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode nodeToBeInserted = new SinglyLinkedListNode(data);
        /**
         * If there is no head.
         */
        if(head == null){
            head = nodeToBeInserted;
            return head;
        }
        /**
         * Assigning the head as the currentNode for traversing.
         */
        SinglyLinkedListNode currentNode = head;
        /**
         * If node has to be added in front of the head.
         */
        if(position ==0){
            nodeToBeInserted.next = currentNode;
            head = nodeToBeInserted;
            return head;
        }
        /**
         * If you want to add the node in between the nodes.
         */
        int counter =1;
        while(currentNode.next != null){
            //this will run till (n-1) nodes.
            if(counter == position){
                SinglyLinkedListNode temp = currentNode.next;
                currentNode.next = nodeToBeInserted;
                currentNode.next.next = temp;
                return head;

            }
            counter = counter+1;
            currentNode = currentNode.next;
        }
        /**
         * If node has to be added in the tail node.
         */
        if(currentNode.next == null && counter == position){
            currentNode.next = nodeToBeInserted;
            return head;
        }
        return head;

    }

    /**
     * Deleting the node at the specific position.
     * @param head
     * @param position
     * @return head
     */
    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        if(head == null){
            return head;
        }
        SinglyLinkedListNode currentnode = head;
        /**
         * If you are deleting the head node.
         */
        if(position == 0 && currentnode.next != null){
            head = currentnode.next;
            return head;
        }
        int counter = 0;
        /**
         * To hold the previous node.
         */
        SinglyLinkedListNode beforeNode = currentnode;
        /***
         * Delete the node that is between the nodes
         */
        while (currentnode.next != null){
            if(position==counter){
                beforeNode.next = currentnode.next;
                return head;
            }
            beforeNode = currentnode;
            currentnode = currentnode.next;
            counter = counter+1;
        }
        /**
         * Deleting the tail node.
         */
        if(position == counter  && currentnode.next == null){
            beforeNode.next = null;
            return head;
        }

        return head;

    }

    /**
     * This  method reverses the linked list program.
     * @param head
     */
    static void reversePrint(SinglyLinkedListNode head) {
        if(head ==null){
        }
        else{
            SinglyLinkedListNode currentNode = head;
            SinglyLinkedListNode prevNode= null;
            SinglyLinkedListNode nextNode = null;
            while(currentNode != null){
                /**
                 * Storing the next node.
                 */
                nextNode = currentNode.next;
                /**
                 * Reversing the pointer back to the previous node
                 */
                currentNode.next = prevNode;
                /**
                 * Interchanging the value of current to previous node
                 * & and nextNode to the current node.
                 */
                prevNode = currentNode;
                currentNode = nextNode;
            }
            /**
             * Assigning previous node to the head.
             */
            head = prevNode;
            while(prevNode != null){
                /**
                 * Printing the data in the nodes.
                 */
                System.out.println(prevNode.data);
                prevNode = prevNode.next;
            }
        }

    }

    /***
     * This method merges the two sorted linked list into one sorted linked list.
     * @param head1
     * @param head2
     * @return
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if(head1 == null && head2 == null){
            return null;
        }
        if(head1 == null &&  head2 != null){
            return head2;
        }
        if(head2 == null && head1 != null){
            return head1;
        }
        SinglyLinkedListNode current1 = head1;
        SinglyLinkedListNode current2 = head2;
        /**
         * Checking the first data of first linked list with the respective first data of the second linked list.
         * if first is smaller then
         */
        if(current1.data < current2.data) {
            /**
             * Point it to the
             */
            current1.next = mergeLists(current1.next, current2);
            return current1;
        }
        else {
            current2.next = mergeLists(current1, current2.next);
            return current2;
        }

    }
}

    /**
     * Get the node value specified from the position of a tail node.
     * @param head
     * @param positionFromTail
     * @return
     */
    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        // Suppose positionFromTail =3
        // 0 1 2 3 // Position From the head.
        // 1 2 3 4 // Node in linked list.
        // 3 2 1 0 // Position From the Tail

        int counter =0;
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode result = head;

        while(current != null){
            current = current.next;
            /**
             * result node points the nodes if the counter from the head node exceeds the position from the tail
             * This leads to add only those nodes that their counter is greater thans the positionFromTail.
             * Adding all those nodes, the last node that is point will be the desired node.
             */
            if(counter++ > positionFromTail){
                result = result.next;
            }
        }
        return result.data;

    }

    /**
     *  Removes duplicates in an sorted linkedList.

     * @param head
     * @return head
     */
    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        if(head == null || head.next == null) return head;


        SinglyLinkedListNode current = head;

        while(current.next != null){
            /**
             * Check the data of the current node with the next node.
             * if it is same then connect the current node with the node
             * that is 2 step forward from the current node
             */
            if (current.data == current.next.data){
                current.next = current.next.next;
            }
            /**
             * otherwise just iterate the node forward.
             */
            else{
                current = current.next;
            }

        }
        return head;


    }

    /**
     * Check whether the linkedlist has a cycle or not.
     * @param head
     * @return
     */
    static boolean checkCyclic(SinglyLinkedListNode head){
        if(head == null){
            return false;
        }
        /**
         * Initializing both to the same head.
         */
        SinglyLinkedListNode first = head;
        SinglyLinkedListNode second = head;
        while(second != null && second.next != null){
            /**
             * Strategy is to iterate one by one for first linkedlist node
             * but
             * for the second one, skipping the next adjacent one.
             */
            first = first.next;
            second =second.next.next;
            /**
             * If it reference to the same object then, it means they have collided
             * otherwise not.
             */
            if(first == second){
                return true;
            }

        }
        return false;

    }

    /**
     * method to find Merge point of the two linked list
     * @param head1
     * @param head2
     * @return
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode first = head1;
        SinglyLinkedListNode second = head2;
        while(first != second){
            if(first.next == null){
                first = head2;//
            }
            else{
                first = first.next;
            }
            if(second.next == null){
                second = head1;
            }
            else{
                second = second.next;
            }
        }
        return first.data;

    }

    /**
     * Inserting a data in the sorted linked list.
     * @param head
     * @param data
     * @return
     */
    static DoublyLinkedListNode insertDataInSortedLinkedList(DoublyLinkedListNode head, int data){
        DoublyLinkedListNode nodeToBeInserted = new DoublyLinkedListNode(data);
        if (head == null){
            head = nodeToBeInserted;
        }
        DoublyLinkedListNode current = head;

        while(current.next != null){
            /**
             * This section is for the data that is greater than the current node data &
             *  and next node data is greater than or equals to the data.
             *  |1|2|4|5| Suppose the 3 has to be inserted.
             *  then output becomes |1|2|3|4|5.
             *  This section suitable between the nodes.
             */
            if(current.data < data && current.next.data >= data){
                DoublyLinkedListNode temp = current.next;
                current.next = nodeToBeInserted;
                nodeToBeInserted.prev = current;
                nodeToBeInserted.next = temp;
                temp.prev = nodeToBeInserted;
                return head;
            }
            /**
             * For this, if the data has to be inserted before the head.
             * That means the data is smaller than the first node(head).So has to be inserted
             * in front of the head.
             */
            else if(current.prev == null && current.data > data){
                nodeToBeInserted.next = current;
                current.prev =nodeToBeInserted;
                head = nodeToBeInserted;
                current = head;
                return head;
            }
            current = current.next;

        }
        /**
         * So far, current holds to be the tail node.
         * This section illustrates if the data has to be attached behind the tail node.
         * Because it the largest data node that the linked list has.
         */
        current.next = nodeToBeInserted;
        nodeToBeInserted.prev = current;

        return head;
    }

    /**
     * Reversing in DoublyLinked List.
     * @param head
     * @return
     */
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        if(head == null){
            return head;
        }
        DoublyLinkedListNode current = head;
        /**
         * Strategy for this, is to reverse the pointer of the DoublyLinkedListNode current node (between prev & next nodes)
         *
         */
        while(current != null){
            DoublyLinkedListNode temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            head = current;
            /**
             * the linked list should be going reversed after the interchange of the prev and next.
             */
            current = current.prev;
        }
        return head;

    }
}


