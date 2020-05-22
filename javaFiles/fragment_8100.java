public void toggleContactsSelection( boolean isSelected ) {
   for( Contact contact : contactArrayList ) {
       contact.setSelected(isSelected);
   }
   notifyDataSetChanged(); // OR you can use notifyItemRangeChanged - which ever suits your needs
}