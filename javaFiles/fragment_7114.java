private void StackActionPerformed(java.awt.event.ActionEvent evt) 
{
   b1=new JButton("Push");
   b2=new JButton("Pop");
   b3=new JButton("Peek");
   b4=new JButton("Clear");
   b1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
         pushButtonActionPerformed(evt);
      }
   });
   tb.add(b1);
   tb.add(b2);
   tb.add(b3);
   tb.add(b4);    
   frame_st.add(tb);
   frame_st.setExtendedState(Frame.MAXIMIZED_BOTH);
   JPanel contentPane = (JPanel)frame.getContentPane();
   contentPane.revalidate();
   contentPane.repaint();
}