String choice = null;
for (RadioButton rb : rBtns) {
    if (rb.isSelected) {
        choice = rb.getText(); break();
    }
}

if (choice.equals(question.getAnswer))
    return true; //correct
else
    return false; //wrong