correct = child.equalNumberOfChildren();  // assign value to correct
    // continue only if not found discrepency 
    if (correct && (child.children.size() == children.size() || child.children.size()==0)) {
        correct = true;
    }else {
        correct = false;
    }
}
return correct;