public class SomeFragment extends Fragment {
    private Textview foo;
    private dataObject obj;

    ...
    public onCreate(...) {
        this.obj = new dataObject();
        sendRequestToVolley(..., new VolleyCallbacks(this));
    }
    public onCreateView(...) {
        ...
        refreshTextView();
    }

    private void refreshTextView() {
        foo.setText(obj.someVar);
    }

    void onRequestSuccess(Response r) {
        obj.updateData(r);
        refreshTextView();
    }
}


class VolleyCallbacks implements SomeInterface {

    private WeakReference<SomeFragment> fragmentWeak;

    public VolleyCallbacks(SomeFragment fragment) {
        this.fragmentWeak = new WeakReference<>(fragment);
    }

    public onSuccess(Response r) {
        SomeFragment fragment = this.fragmentWeak.get();

        if (fragment != null) {
            fragment.onRequestSuccess(r);
        }
    }
}