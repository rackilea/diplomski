gl.setHorizontalGroup( gl.createParallelGroup()
        .addComponent( c1 )
        .addGroup(gl.createSequentialGroup()
            .addPreferredGap(c1, c2, ComponentPlacement.INDENT)
            .addComponent( c2 )
            )
        );
gl.setVerticalGroup( gl.createSequentialGroup()
        .addComponent( c1 )
        .addComponent( c2 )
    );