class FragmentB extends Fragment ... {
    private FragmentBListener _listener;

    public void setListener(FragmentBListener listener) { _listener = listener ;}

    // And in your Delete button handler:
    private void onDeleteButton() {
        _listener.onDelete();
    }
}