/*
Given a sorted linked list, delete all nodes that have duplicate
numbers, leaving only distinct numbers from the original list.In this 
program, you need to 
(1) read 5 numbers and set them in a linkedlist in order
(2) delete duplicate

Example 1:
input: 1,2,3,3,5
output: head-->1-->2-->3-->5-->null

Example 2:
input: 1,1,1,2,3
output: head-->1-->2-->3-->null

Please complete the following program to fullfil the function.
*/
import java.util.Scanner;

public class homework20_1
{
   public static void main(String[] args)
   {
      //add your code here
      Scanner scanner = new Scanner(System.in);
      LinkedList llist = new LinkedList();

      System.out.println("Enter 5 integer numbers: ");

      for (int i = 0; i <= 4; i++) {
         int input = scanner.nextInt();

         ListNode llistNode = new ListNode(input);
         if (llist.head == null) {
            llist.head = llistNode;
         } else {
            ListNode current = llist.head; // start at llist head
            while (current.next != null) {
               current = current.next;
            }
            current.next = llistNode;
         }
      }

      System.out.println("Orginal list: ");
      System.out.println(llist);
 
      deleteDuplicates(llist);

      // Print result after duplicate
      System.out.println(llist);

      scanner.close();
   }
   public static void deleteDuplicates(LinkedList llist)
   {
      //add your code here
      if (llist.head == null) {
         return;
      }

      ListNode current = llist.head;

      while (current != null && current.next != null) {
         if (current.value == current.next.value) {
            current.next = current.next.next; // moves on to the next node if they are equal
         } else {
            current = current.next;
         }
      }
      
   }

}

class ListNode
{
   int value;
   ListNode next;
   ListNode(int v){
      value = v;
   }
}

class LinkedList
{
   ListNode head;
   public String toString()
   {
      String nodeData = "";
      ListNode ref = head;
      while(ref != null)
      {
         nodeData += ref.value + "-->";
         ref = ref.next;
      }
      return "head-->"+nodeData+"null";
   }
}
