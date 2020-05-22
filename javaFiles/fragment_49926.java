private void makeTransfer(View view) {
    Bundle bundle = new Bundle();
    bundle.putString("name", "Aleksey");
    Navigation.findNavController(view).navigate(R.id.transferAction, bundle);

    //Type safe passing data 
    InitialFragmentDirections.TransferAction action = InitialFragmentDirections.transferAction();
    action.setLastName("Petrov");
    Navigation.findNavController(view).navigate(action);
}