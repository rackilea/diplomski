jButton3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
           System.out.println("In the action");
           JLabel imgLabel = new JLabel(new ImageIcon(this.getClass().getResource( "/resource/images/cd-dvd-icon.png")));
            jPanel2.add(imgLabel);
            jPanel2.revalidate();
            jPanel2.repaint();
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(jButton3)
                    .addGap(59, 59, 59)
                    .addComponent(jToggleButton1)
                    .addGap(50, 50, 50)
                    .addComponent(imgLabel)
                    .addContainerGap(235, Short.MAX_VALUE))
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jToggleButton1)
                        .addComponent(jButton3))
                        .addGap(59, 59, 59)
                        .addComponent(imgLabel)
                    .addContainerGap(368, Short.MAX_VALUE))
            );
        }

    });