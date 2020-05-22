abstract class Place {
    // ..
    public abstract void action();
}

class NamedPlace extends Place {
    public void action() {
            JOptionPane.showMessageDialog(null, p.getName() + " " + p.getPosition(), "Platsinfo: ", JOptionPane.INFORMATION_MESSAGE);
    }
}

class DescribedPlace extends Place {
    public void action() {
            JOptionPane describedPane = new JOptionPane();
            describedPane.setMessage("Name: " + p.getName() + " " + p.getPosition() + "\n" + "Description: " + ((DescribedPlace) p).getDescription());
            describedPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
            JDialog dialog = describedPane.createDialog(p, "Platsinfo:");
            dialog.setVisible(true);
    }
}