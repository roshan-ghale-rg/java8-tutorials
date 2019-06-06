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


}
