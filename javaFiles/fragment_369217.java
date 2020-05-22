@Override
public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
    holder.isBinding = true;

    ...

    /* When calling check() here, we invoke onCheckedChanged(), which will
       update the textview that displays the selected answer - so no need to call
           holder.selectedAnswer.setText(  models.get(position).getSelectedAns() )
       from here */
    holder.radioGroup.check(models.get(position).getChecked());

    holder.isBinding = false;
}