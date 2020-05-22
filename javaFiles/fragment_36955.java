Fragment cameraEditing = new Editing(); FragmentManager
 fragmentManager = getFragmentManager(); FragmentTransaction 
fragmentTransaction = fragmentManager.beginTransaction(); 
fragmentTransaction.replace(R.id.cameraLayout, 
cameraEditing,"cameraEditing"); 
fragmentTransaction.addToBackStack("cameraEditing");
 fragmentTransaction.commit();