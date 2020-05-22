public class ListModel {

    View view;
    String url;

    public ListModel (View view, String url) {
        this.view = view;
        this.url = url;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}