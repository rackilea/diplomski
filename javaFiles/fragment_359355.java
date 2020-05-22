private OnDataPass dataPasser;

//Interface, trought the fragment can comunicate with activity
public interface OnDataPass {
    public void onDataPass();
}

//Method, which you call in your onClickListener
public void passData() {
    // Method in the Activity
    dataPasser.onDataPass();
}

//Method, which creates the interface
@Override
public void onAttach(Activity a) {
    super.onAttach(a);
    try {
        dataPasser = (OnDataPass) a;
    } catch (ClassCastException e) {
        throw new ClassCastException(a.toString() + " must implement onDataPass");
    }
}