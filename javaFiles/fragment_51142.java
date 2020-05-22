private class BFSTask extends SwingWorker<LinkedList<Node>, Node>{
    private ArrayList<Node> visitedList;
    private int visitedIndex = 0;
    private boolean traversalDone = false;
    private Timer traversal = new Timer(AppWindow.speed, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Node lastVisited = visitedList.get(visitedIndex);
            Edge visitedEdge = lastVisited.getEdgeBetween(lastVisited.getAttribute("parent", Node.class));
            visitedEdge.setAttribute("ui.color", 0.5);
            visitedIndex++;
            if(visitedIndex >= visitedList.size()){
                traversal.stop();
                traversalDone = true;
                if(BFSAlgorithm.this.getPathToGoal() != null){
                    startTimer();
                }
            }
        }
    });

     @Override
    protected LinkedList<Node> doInBackground() throws Exception {
        Node found = publishNodeBreadthFirst(getStartNode(), getGoalNode());
        if (found != null) {
            return getPathToGoal(found);
        } else{
            return null;
        }
    }

    @Override
    protected void process(List<Node> list) {
        visitedList = (ArrayList<Node>) list;
        traversal.start();
    }

    @Override
    protected void done() {
        try {
            BFSAlgorithm.this.pathToGoal = get();
            if(traversalDone && BFSAlgorithm.this.getPathToGoal() != null){
                startTimer();
            }
            if(BFSAlgorithm.this.getPathToGoal() == null){
                throw new NullPointerException("Goal Not Found.");
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            JOptionPane.showMessageDialog(getAppWindow(), "Goal Node Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
            getAppWindow().disableExceptClear();
            getAppWindow().changeStatus("Goal node not found");

        }
    }

    private LinkedList<Node> getPathToGoal(Node found) {
        LinkedList<Node> path = new LinkedList<>();
        Node parent = found.getAttribute("parent");
        path.addLast(found);
        while (parent != getStartNode()){
            path.addLast(parent);
            parent = parent.getAttribute("parent");
        }
        return path;
    }
}