final StringBuilder stringBuilder = new StringBuilder();

for (String email : categorySet.get(position).getEmails()) {
    if (!stringBuilder.toString().isEmpty()) {
        stringBuilder.append("\n");
    }
    stringBuilder.append(email);
}

holder.category_emails.setText(stringBuilder.toString());