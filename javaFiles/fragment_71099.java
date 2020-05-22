class Dress extends BaseObservable {

    private String title;

    private String desc;

    /** Constructor */
    public Dress() {}

    /** Constructor, new instance from Firestore {@link QueryDocumentSnapshot} */
    public Dress(@NonNull QueryDocumentSnapshot snapshot) {
        this.fromSnapshot(snapshot);
    }

    public void setTitle(@NonNull String value) {
        boolean changed = !TextUtils.equals(this.title, value);
        if(changed) {
            this.title = value;
            notifyPropertyChanged(BR.title);
        }
    }

    public void setDesc(@NonNull String value) {
        boolean changed = !TextUtils.equals(this.desc, value);
        if(changed) {
            this.desc = value;
            notifyPropertyChanged(BR.desc);
        }
    }

    @Bindable
    public String getTitle() {
        return this.title;
    }

    @Bindable
    public String getDesc() {
        return this.desc;
    }

    public void fromSnapshot(@NonNull QueryDocumentSnapshot snapshot) {
        this.setTitle(String.valueOf(snapshot.getData().get("title")));
        this.setDesc(String.valueOf(snapshot.getData().get("description")));
    }
}