public void Update() {
        JPanel p = new JPanel();
        for (int i = 0; i < inv.categories.size(); i++) {
            Category cat = inv.categories.get(i);
            JTextPane name = new JTextPane();
            p.add(name);        
            name.setText(cat.getName());                
        }
        scroll.getViewport().add(p);       
    }