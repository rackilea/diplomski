if(holder.newsTitle.getText().toString().contains("Page ") && holder.page_separator_flag == true) {
        holder.newsPicture.setVisibility(View.GONE);
        holder.newsTimestamp.setVisibility(View.GONE);
        holder.newsItemLayout.setBackground(context.getResources().getDrawable(R.drawable.background_card_page));
        holder.newsTitle.setTextSize(Float.valueOf(holder.newsTitle.getTextSize()) * 0.50f);
        holder.newsTitle.setTextColor(Color.WHITE);
    }
else {
YOUR DEFAULT VALUES WHEN BOOLEAN IS FALSE
}