List<Player> players = new ArrayList<Player>();

if (control == 1) {
     String name = JOptionPane.showInputDialog(null, "New player: ", "Add New Player",
             JOptionPane.INFORMATION_MESSAGE);
     int attendance = Integer.parseInt(JOptionPane.showInputDialog(null,
             "How many matchs have he played so far? ", "Attendance", JOptionPane.INFORMATION_MESSAGE));
     Player player = new Player(name, attendance);
     players.add(player);

} else if (control == 2) {
    for (int i = 0; i < players.size(); i++) {
        Player player = players.get(i);
        JOptionPane.showMessageDialog(null, "Attendance = " + player.getAttendance(), "N: " + i + "- " + player.getName(),
                JOptionPane.WARNING_MESSAGE);
    }                
}