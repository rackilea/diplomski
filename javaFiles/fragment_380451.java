@Override
public void onAttach(Context context) {
  super.onAttach(context);
  try {
        callback = (SomeInterface) getParentFragment();
    } catch (ClassCastException e) {
        throw new ClassCastException("Parent fragment must implement SomeInterface");
    }

}