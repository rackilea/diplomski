Scanner sx = new Scanner(System.in);
    Node first = null;
    Node tail = null;

    for (int i = 0; i < N; i++)
    {
        Node current = new Node();
        current.data = sx.nextInt();

        if (tail == null)
        {
            first = tail = current;
        }
        else
        {
            tail = tail.link = current;
        }
    }
    for(Node d = first; d != null; d = d.link)
        System.out.println(d.data);