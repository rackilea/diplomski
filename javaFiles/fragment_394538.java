public DetailsViewHolder(View itemView){
            super(itemView);
            viewTypes = new View[viewBundle.size()];
            for (int i = 0; i < viewBundle.size(); i++) {
                viewTypes[i] = (itemView.findViewById((Integer) viewBundle.get(i).get(0)));
            }
        }