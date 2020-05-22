/// The interface
public interface getselectpos
    {
        void onItemClick(CintasHolder holder, int posicion);
    }

private getselectpos interfaceclick;
//Declared a private variable to manage the interface



//in the constructor recover the interface, for exemple.

//CintasDataset is a class to manage the data for the adapter

 public CintasAdapter(List<CintasDataset> items, getselectpos Interfaceclick)
    {
        this.mitems = items; //the elements 
        this.interfaceclick=Interfaceclick; // the interface create from in the fragment
    }




/// Class holder for this class , and implements OnClickListener

public class CintasHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public ImageView imagen; //an imagen
        public TextView modocorte;/a textview 

        public CintasHolder(View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);//add the listener for an element
        }

        //add onClick and set the funcion onItemClick , declared in the interface
        @Override
        public void onClick(View view)
        {
            interfaceclick.onItemClick(this, getAdapterPosition());
        }
    }