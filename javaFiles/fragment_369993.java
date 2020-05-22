for (int i = startLine; i < endLine + 1; i++)
{
    buttonName = inputFile.readLine();
    Button1 = new JButton(buttonName);
    buttonPanel.add(Button1, BorderLayout.LINE_START);
}