public MenuAdapter(Context context, int resource, RealmList<DetailPerson> objects) {
    super(context, resource, objects);
    this.context = context;
    this.persons = objects;
    inflater = LayoutInflater.from(context);
}