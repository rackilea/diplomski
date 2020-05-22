if(position % 2 == 0){
    viewHolder.textViewKey.setBackgroundColor(context.getResources().getColor(R.color.colorParkerWhite2));
    viewHolder.textViewValue.setBackgroundColor(context.getResources().getColor(R.color.colorParkerWhite2));
} else {
    viewHolder.textViewKey.setBackgroundColor(context.getResources().getColor(R.color.colorParkerWhite1)); //Or the color that you want for odd rows
    viewHolder.textViewValue.setBackgroundColor(context.getResources().getColor(R.color.colorParkerWhite1)); //Or the color that you want for odd rows
}