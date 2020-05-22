public CustomAdapter(Context context, ArrayList<String> nam,
            ArrayList<String> date, ArrayList<String> time) {
        super();

        this.context = context;
        this.nam.addAll(nam);
        this.date.addAll(date); 
        this.time.addAll(time);

        inflater =LayoutInflater.from(context);

    }