StringBuilder message = new StringBuilder();
while (rs.next()) {
    message.append(space)
        .append(rs.getString("idStacja"))
        .append(" ")
        .append(rs.getString("nazwa"))
        .append(" ");
}
JLabel input = new JLabel(message.toString());
submenu.add(input, BorderLayout.CENTER);