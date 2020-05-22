public MenuViewHolder(View itemView) {
        super(itemView);

        txtMenuName = itemView.findViewById(R.id.menu_name);
        imageMenu = itemView.findViewById(R.id.menu_image);

        itemView.setOnClickListener(this);
    }