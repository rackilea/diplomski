@Override
    protected void onBindViewHolder(IngredienteViewHolder holder, int position, Ingrediente model) {
        holder.name.setText(model.getName());
        holder.setIngrediente(model);
        if (position % 2 == 0){
            holder.name.setBackgroundColor(Color.BLACK);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)holder.name.getLayoutParams();
            params.removeRule(RelativeLayout.ALIGN_PARENT_START);
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            holder.name.setLayoutParams(params); //causes layout update
        } else {
            holder.name.setBackgroundColor(Color.RED);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)holder.name.getLayoutParams();
            params.removeRule(RelativeLayout.ALIGN_PARENT_START);
            params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            holder.name.setLayoutParams(params); //causes layout update
        }
    }




<RelativeLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <TextView xmlns:android="http://schemas.android.com/apk/res/android"
              android:id="@+id/list_item_name"
              android:layout_width="wrap_content"
              android:layout_height="match_parent"
              android:layout_alignParentStart="true"
              android:textSize="@dimen/list_ingredienti_size"
              android:focusable="false"
              android:text="testo"
              android:textColor="@drawable/selected_textcolor"
              android:gravity="center"
              android:background="@drawable/selected_background"
        />
</RelativeLayout>