public boolean isEmpty()
        {

            return (top == 0);
        }

        /**
         * Returns the number of elements in this stack.
         * @param stack2 
         * @return the number of elements in the stack
         */
        public int size()
        {

            return top; // have this set to 0 temporary since I'm getting the error

        }


        /**
         * Returns a string representation of this stack. The string has the
         * form of each element printed on its own line, with the top most
         * element displayed first, and the bottom most element displayed last.
         * If the list is empty, returns the word "empty".
         * @return a string representation of the stack
         */


        public String toString()
        {
           int top1 = top -1;
           String finishedString = "";
           for(int i = top1;i >= 0;i--)
           {
            finishedString += stack[i].toString() + "\n";
           }
           return finishedString;

        }