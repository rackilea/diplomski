if (view == null) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        row = inflater.inflate(R.layout.custom_list, viewGroup, false);
    } else {
        row = view; // CHECK THIS LINE!!!!!!
    }