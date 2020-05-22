if (Memory.userUid(context).equals(userList.get((holder.getAdapterPosition())).getUserUid())) {
        holder.tvPoints.setTextColor(ContextCompat.getColor(context, R.color.pink));
        holder.tvUserName.setTextColor(ContextCompat.getColor(context, R.color.pink));
        holder.highLightView.setBackgroundColor(ContextCompat.getColor(context, R.color.pink));

    }else{
            holder.tvPoints.setTextColor(Color.parseColor("#FaFaFa"));
            holder.tvUserName.setTextColor(Color.parseColor("#FaFaFa"));
            holder.highLightView.setBackgroundColor(Color.parseColor("#FaFaFa"));
}