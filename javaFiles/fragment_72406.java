botones[index].addActionListener(new ActionListener() {
            private int myIndex;

            {
                this.myIndex = index;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("index is: " + myIndex);
            }
        });