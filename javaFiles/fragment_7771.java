public void refreshPanel()
{
     String fNames[] = (String[]) fields.toArray();
     panel.removeAll();
     for(String fname : fNames)
     {
          //add the fields in `newPanel`, the field name is in `fname` variable
     }
     revalidate();
     repaint();
}