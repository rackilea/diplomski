if (session.getLanguage().equals("fa") && languages[position].equals("farsi")) {    
    holder.check.setVisibility(View.VISIBLE);
} else if (session.getLanguage().equals("en") && languages[position].equals("English")) {
    holder.check.setVisibility(View.VISIBLE);
} else {
    holder.check.setVisibility(View.GONE);
}