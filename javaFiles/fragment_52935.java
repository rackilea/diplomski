@Override
public void mouseClicked(MouseEvent e) {            
        JPanel p = (JPanel) e.getSource();
        String s = p.getName();
        String[] numbers = s.replaceAll("^\\D+", "").split("\\D+");
        int y = Integer.valueOf(numbers[0]);
        int x = Integer.valueOf(numbers[1]);
        ...