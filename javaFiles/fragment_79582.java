@Override
public boolean equals(Object other) {
    if(this == other) {
        return true;
    }

    if((other == null) || (other.getClass() != this.getClass())) {
        return false;
    }

    TermNode node = (TermNode)other;

    return this.value.equals(node.getValue()) 
            && PlotterUtil.isEqual(this.children, node.getChildren()) 
            && this.type == node.getType();
}