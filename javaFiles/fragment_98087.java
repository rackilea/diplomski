if(checkbox.isChecked){
   String service=serviceArray.get(getAdapterPosition);
   selectedServiceArray.add(service);
   holder.serviceNameTv.setText(selectedServiceArray.toString);
} else {
  String service=serviceArray.get(getAdapterPosition);
  selectedServiceArray.remove(service);  
  holder.serviceNameTv.setText(selectedServiceArray.toString);
}