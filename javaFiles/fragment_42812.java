add(p, BorderLayout.CENTER);
add(p1, BorderLayout.NORTH);
add(p2, BorderLayout.SOUTH);
// HERE
Timer t = new Timer(1000, new TimerListener(a)); 
a.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent event) {
        Random r = new Random();
        int rand = r.nextInt(5);
        switch (rand) {
        // ... code
        if (rand == 0) {
            t.restart();    
        } else {
            a.setIcon(guncold);
        }

    }

});