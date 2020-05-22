for(int r2 = 0; r2 < rows; r2++){
        for(int c2 = 0; c2 < cols; c2++){
            Node currentNode = nodeGrid[r2][c2];
            Node rightNode = null;
            if (c2 < cols - 1) // the condition for the existence of a right node
                rightNode = nodeGrid[r2][c2+1];
            Node bottomNode = null;
            if (r2 < rows - 1) // the condition for the existence of a bottom node
                bottomNode = nodeGrid[r2+1][c2];

            if(rightNode != null && !rightNode.isWall()){
                currentNode.addNeighbor(rightNode);
            }
            if(bottomNode != null && !bottomNode.isWall()){
                currentNode.addNeighbor(bottomNode);
            }
        }
    }