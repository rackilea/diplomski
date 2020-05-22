public void drawMolViewPanel(String sdf) throws FileNotFoundException, CDKException
{
    ReadSDF(sdf);
    this.removeAll();

    for (int i = 0; i < this.fragments.size(); i++)
    {    
        MolViewer mv = new MolViewer();
        mv.setMolecule((Molecule)this.fragments.get(i));
        this.add(mv);
    }

    this.revalidate();
    this.repaint();
}