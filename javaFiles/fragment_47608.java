public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("Stackoverflow");
    shell.setLayout(new GridLayout(1, false));

    Graph g = new Graph(shell, SWT.NONE);
    g.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    Random random = new Random(System.currentTimeMillis());

    final List<GraphNode> nodes = new ArrayList<>();
    for (int i = 0; i < 10; i++)
    {
        GraphNode node = new GraphNode(g, SWT.NONE);
        node.setText("TEST");
        node.setLocation(random.nextInt(400), random.nextInt(400));
        nodes.add(node);
    }

    for (int i = 0; i < 50; i++)
    {
        GraphNode source;
        GraphNode target;

        do
        {
            source = nodes.get(random.nextInt(nodes.size()));
            target = nodes.get(random.nextInt(nodes.size()));
        } while (source.equals(target));

        new GraphConnection(g, SWT.NONE, source, target);
    }

    Button clear = new Button(shell, SWT.NONE);
    clear.setText("Clear");
    clear.addListener(SWT.Selection, e -> {
        for(GraphNode node : nodes)
        {
            node.dispose();
        }
        nodes.clear();
    });
    clear.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

    shell.pack();
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}