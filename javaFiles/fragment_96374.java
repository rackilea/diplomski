protected List<Node> generateSuccessors(Node node){
                List<Node> ret = new LinkedList<Node>();
                int x = node.x;
                int y = node.y;
                if(y < map.length - 1 && map[y+1][x] == 1)
                                ret.add(new Node(x, y+1));

                if(x < map[0].length - 1 && map[y][x+1] == 1)
                                ret.add(new Node(x+1, y));

                return ret;
}