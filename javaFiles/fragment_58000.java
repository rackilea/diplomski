public SideMenuAdapter(Context context, int textViewResourceId, List<String> objects)
{
        super(context, textViewResourceId, objects);
        this.textViewResourceId = textViewResourceId;
        // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        this.context = context;
        this.objects= objects;

}