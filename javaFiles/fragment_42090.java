class DisplayPanel extends JPanel{

    private MyGraph;

    public DisplayPanel(){
        MyGraph graph = new MyGraph();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        graph.draw(g);            //let the objects draw themselves
    }
}