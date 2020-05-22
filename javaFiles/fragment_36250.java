public final class Pattern
    implements java.io.Serializable
{
[...]
    /**
     * Parses a group and returns the head node of a set of nodes that process
     * the group. Sometimes a double return system is used where the tail is
     * returned in root.
     */
    private Node group0() {
        boolean capturingGroup = false;
        Node head = null;
        Node tail = null;
        int save = flags;
        root = null;
        int ch = next();
        if (ch == '?') {
            ch = skip();
            switch (ch) {

            case '<':   // (?<xxx)  look behind or group name
                ch = read();
                int start = cursor;
[...]
                // test forGroupName
                int startChar = ch;
                while(ASCII.isWord(ch) && ch != '>') ch=read();
                if(ch == '>'){
                    // valid group name
                    int len = cursor-start;
                    int[] newtemp = new int[2*(len) + 2];
                    //System.arraycopy(temp, start, newtemp, 0, len);
                    StringBuilder name = new StringBuilder();
                    for(int i = start; i< cursor; i++){
                        name.append((char)temp[i-1]);
                    }
                    // create Named group
                    head = createGroup(false);
                    ((GroupTail)root).name = name.toString();

                    capturingGroup = true;
                    tail = root;
                    head.next = expr(tail);
                    break;
                }