membersTable.removeAll();
for(Control control : membersTable.getChildren()) {
    if (control instanceof Button) {
        control.dispose();
    }
}