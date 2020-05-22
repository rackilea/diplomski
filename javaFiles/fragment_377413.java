Set<Integer> selectedSeats = new LinkedHashSet<>();
    for (int i = 0; i < 30; i++) 
    {
        if (ButtonList[i].isSelected()) 
        {
            selectedSeats.add(i + 1);
        }
    }

    if (selectedSeats.isEmpty()) 
    {
        JFrame parent= new JFrame();
        JOptionPane.showMessageDialog(parent, "You haven't select a seat");
    }
    else
        pass(title, selectedSeats);