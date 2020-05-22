private final int REQUEST_CODE = 1

class ImagePicker extends Fragment{
   /*here we are calling the start activity for result
   supposing you know how to use the gallery intent so just giving you 
   the answer what you want */

   Intent intent = new Intent(getContext(), YourClass.class);
   startActivityForResult(intent, REQUEST_CODE);
 }