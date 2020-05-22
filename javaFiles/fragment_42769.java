// The current focus owner on the Scene
Node focusOwner = scene.getFocusOwner();

table.requestFocus();
table.requestLayout();

// Request focus on the currently focused Node
if(focusOwner != null)
    focusOwner.requestFocus();
else
    // request focus on any Node you want
    textField.requestFocus();