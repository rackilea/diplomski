package stackexercise;

import java.util.*;

class Node {
  int data;
  Node next;

  public Node(int data) {
    this.data = data;
    this.next = null;
  }
}

public class StackExercise {

  public Node head;

  public void push(int data) //insert at begin 
  {
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
  }

  public Node pop() //deletion at begin
  {
    if (head == null) {
      System.out.print("stack underFlow");
      return null;
    }
    Node x = head;
    head = head.next;
    return x;
  }

  public int maxele(Node head) {
    Node max = head;
    Node temp = head;
    while (temp != null) {
        // My guess is that this is what is wrong.
        // This calculates minimum value (not the max).
        // Read it as:
        //  If the number we are tracking is bigger than the
        //  current data element(i.e. current element is smaller),
        //  capture this (smaller) data element as the new value.
      //if (max.data > temp.data)
        // Whereas this can be read as:
        //  If this data element is bigger than the value we are tracking
        //  capture this (bigger) data element as the new value.
      if (temp.data > max.data)
        max = temp;
      temp = temp.next;
    }
    return max.data;
  }

  public void display() {
    System.out.println("Stack contents:");
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
      System.out.println();
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    StackExercise obj = new StackExercise();
    int maximumElement;
    int N, i = 0;
    int test;

    N = sc.nextInt();
    while (i < N) {
      test = sc.nextInt();
      if (test == 1) {
        obj.push(sc.nextInt());
      } else if (test == 2) {
          Node x = obj.pop();
          if (x != null) {
              System.out.printf("popped: %d\n", x.data);
          } else {
              System.out.println("Stack empty");
          }
      } else if (test == 3) {
        maximumElement = obj.maxele(obj.head);
        System.out.println(maximumElement);
        System.out.println();
      } else if (test == 4) {
          obj.display();
      }
      i++;
    }
  }
}