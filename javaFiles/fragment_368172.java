public String linealNotation(){
    StringBuffer line = new StringBuffer();
    linearize(line,root); 
    return line.toString();
}


private void linearize(StringBuilder line, Node n){
    if (n==null) {
        return;
    }
    line.append(n.data); 
    line.append("(");       
    linearize(line,n.left);
    line.append(",");
    linearize(line,n.right);
    line.append(")");
}