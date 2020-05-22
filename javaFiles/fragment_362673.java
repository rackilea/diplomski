public void inOrderTraverseTree(Node focusNode, double min, double max) 
{

    if (focusNode != null) {
        inOrderTraverseTree(focusNode.leftChild, min, max);

    if (focusNode.gpa >= min && focusNode.gpa <= max){                
        System.out.println(focusNode);
    }
    else {
        System.out.print("");
    }

    inOrderTraverseTree(focusNode.rightChild, min, max);
    }// end if
}// end inOrderTraverseTree