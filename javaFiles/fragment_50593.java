//Cargas_detalle_previo is the fragment class, the interface  "CintasAdapter.getselectpos "
public class Cargas_detalle_previo extends Fragment  implements  CintasAdapter.getselectpos
{
    //TODO CONTENT
    //exemple for onViewCreated
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        //TODO CONTENT
         List mitems2 = new ArrayList(); // for exemple 

        //declared the adapter
         final CintasAdapter adaptercintas = new CintasAdapter(mitems,this);
    }



    //and  override the function in the interface, in the case  onItemClick
    @Override
    public void onItemClick(CintasAdapter.CintasHolder holder, int posicion)
    {


        //and use the posicion 

        //exemple to show the posicion
        Toast.makeText(getContext(),posicion+"",Toast.LENGTH_LONG).show();


    }

}