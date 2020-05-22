public class YourAdapter extends RecyclerView.Adapter<YourAdapter.ViewHolder> {

  ...
  private AdapterListener listener;

  // define the listener
  public interface AdapterListener {
    void onItemClicked(int position);
  }

  // register the listener with this method
  public setListener(AdapterListener listener) {
    this.listener = listener;
  }

  ...

  public ViewHolder(View itemView) {
    itemView.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {

         // tell the listener about the click
         if(listener != null) {
           listener.onItemClicked(getAdapterPosition());
         }

       }
  }

}