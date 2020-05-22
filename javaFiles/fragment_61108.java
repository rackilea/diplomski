public class ProfileFragment extends Fragment 
    implements PasswordChangeListener { // See here

    ...

    @Override
    public void onPasswordChanged(String oldPass, String newPass) {
        Toast.makeText(getActivity(), 
            String.format("Changed %s to %s", oldPass, newPass), 
            Toast.LENGTH_SHORT).show();
    }