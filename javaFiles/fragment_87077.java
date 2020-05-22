if(node==null){
    code.add(new Code(node.getElement().getLetter(), prefix));
} else {
    traverse(code, node.getLeft(), prefix + "0");
    traverse(code, node.getRight(), prefix + "1");
}