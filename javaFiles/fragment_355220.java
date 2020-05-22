package com.testcopy;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

public class TestCopy {

    public static void main (String[] args) {

        TestCopy app = new TestCopy ();
        app.run ();
    }

    public void run () {
        // Create and populate stack
        Stack<String> myStack = new Stack<String> ();
        mkData(myStack);

        // Copy to queue
        Queue<String> myQueue = new ArrayDeque<String> ();
        copyFromStack (myStack, myQueue);

        // Print 
        int i=0;
        for (String s : myQueue) {
            System.out.println ("myQueue[" + i++ + "]: " + s);
        }
    }

    @SuppressWarnings("unchecked")
    public void mkData (Stack stack) {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        // Stack should now contain C, B, A
    }

    public void copyFromStack (Stack stack, Queue queue) {
        @SuppressWarnings("rawtypes")
        Iterator it = stack.iterator ();
        while (it.hasNext()) {
            queue.add(it.next());
        }
    }
}