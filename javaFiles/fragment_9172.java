public void playerFrame()
{
    GridBagConstraints gbc = new GridBagConstraints();

    JPanel newPanel = new JPanel(new GridBagLayout());
    playerFrameArr.add(newPanel);

    gbc.gridx = 0;
    gbc.gridy = 0;
    newPanel.add(new JButton("LABEL"), gbc);

    gbc.gridx = 1;
    gbc.gridy = 0;
    newPanel.add(new JButton("BUTTON"), gbc);

    gbc.gridx = 0;
    gbc.gridy = frameCounter + 1;
    container.add(newPanel, gbc);

    System.out.println(frameCounter);

    frameCounter++;
}