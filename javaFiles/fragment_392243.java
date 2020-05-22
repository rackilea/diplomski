MPartStack stack;
// TODO inject the stack or find in the model

List<MStackElement> children = stack.getChildren();

// Copy the list - don't try and update the original list

List<MStackElement> sorted = new ArrayList<>(children);

// TODO order the list

// Update the stack children

children.clear();
children.addAll(sorted);