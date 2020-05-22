ViewGroup viewGroup = findViewById(R.id.yourViewGroupName);
for each child in viewGroup.getChildren {
    if child is of type Button {
        child.setOnClickListener(this);
    }
}