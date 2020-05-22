public void mouseClicked(MouseEvent e) {
    boxHolder.add(createPanel());
    int indexPosition  = 2;
    try //Will only remove it if there is already a panel or other component there
    {
        boxHolder.remove(indexPosition);
    }
    catch(Exception ex){}
    try //Will only add here if you have a component in index position 1
    {
        boxHolder.add(createPanel(),indexPosition);
    }
    catch(Exception ex){}
    scrollPaneContainer.revalidate();
}