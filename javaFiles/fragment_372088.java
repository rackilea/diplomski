if (isSelected)
    {
        renderButton.setForeground(myFColor1);
        renderButton.setBackground(myBColor1));
        renderButton.setIcon(nonactiveUpdate);
    }
    else
    {
        renderButton.setForeground(myFColor2);
        renderButton.setBackground(myBColor2);
        renderButton.setIcon(tableUpdate);
    }

    if (hasFocus)
    {
        renderButton.setForeground(myFColor3);
        renderButton.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(252, 181, 73)));
        renderButton.setIcon(activeUpdate);
    }
    else
    {
        renderButton.setBorder( originalBorder );
    }