JPanel complete=new JPanel();
    GroupLayout gl=new GroupLayout(complete);
    complete.setLayout(gl);
    gl.setAutoCreateContainerGaps(true);

    gl.setHorizontalGroup(gl.createParallelGroup() //this is parallel bcz you need components vertically
            .addComponent(visualize)       //you MUST add components to both horizontal and vertical groups
            .addComponent(operations)
            .addComponent(sheet)
    );

    gl.setVerticalGroup(gl.createSequentialGroup() //NOTE that this is sequential
            .addComponent(visualize)
            .addComponent(operations)
            .addGap(50)        //you can add gaps if you want
            .addComponent(sheet)
    );

    add(complete);