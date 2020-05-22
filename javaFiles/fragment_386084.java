JXDatePicker fDate = new JXDatePicker(new Date());

//edit the Textfield
fDate.getEditor().setBorder(null);
fDate.getEditor().setEditable(false);

//edit the Button
JButton dateBtn= (JButton) fDate.getComponent(1);
Image editImage  =Toolkit.getDefaultToolkit().getImage(getClass().getResource("/toolbarButtonGraphics/general/Edit16.gif"));

dateBtn.remove(eDate);  
dateBtn.setIcon(new ImageIcon(editImage));
dateBtn.setFocusPainted(false);
dateBtn.setMargin(new Insets(0, 0, 0, 0));
dateBtn.setContentAreaFilled(false);
dateBtn.setBorderPainted(false);
dateBtn.setOpaque(false);