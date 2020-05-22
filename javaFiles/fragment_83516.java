// In fragment A
((ParentActivity)getActivity()).dispatchInformations("test");

// In ParentActivity
public void dispatchInformations(String mesg){
    fragmentB.sendMessage(mesg);
}