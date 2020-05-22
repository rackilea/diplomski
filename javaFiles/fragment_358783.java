public void actionPerformed(ActionEvent e)
{
     Object o = e.getSource();
     if(o == nextButton)
     {
          currentIndex++;
          if(currentIndex == vectorImages.size())
          {
               currentIndex = 0;
          }
          //Change the image in the JLabel
          label.setIcon(new ImageIcon(vectorImages.get(currentIndex)));
     }
     else
     {
          //Iterate backwards
     }
}