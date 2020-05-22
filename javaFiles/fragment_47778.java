public class ArrayAdapterSocio extends ArrayAdapter<Socios> implements View.OnClickListener{

    // Your previous code

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Your previous code
        CapturadorSocio.edit.setTag(socios.obtenerId); 
        // Hopefully you have a method to identify your memebers by Id. 
        // Otherwise, use another unique identifier, like their name.
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnEdit:
            // The edit button was clicked, launch your edition here.
            // You can get the Id of the member by calling v.getTag(),
            // use that to launch edition on the correct member.
            break;

            default:
            break;
        }
    }
}