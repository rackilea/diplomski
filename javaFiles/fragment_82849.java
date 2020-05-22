if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            if (inflater != null) {
                // ###################   CHANGE HERE ###########################
                itemView = inflater.inflate(R.layout.list_badges, parent, false);
            }
            holder = new ViewHolder();
            holder.badge_text = (TextView)itemView.findViewById(R.id.badge_text);
            holder.badge_image = (ImageView)itemView.findViewById(R.id.badge_image);
            itemView.setTag(holder);
        }   else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder) itemView.getTag();
        }