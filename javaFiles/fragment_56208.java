public House(Furniture f, House p) {

        // I'm so confused here, I'm not sure how to start 
        this.fur = new Furniture[p.fur.length+1];

        this.fur[0] = f; // Add new furniture

        // Make new instances of furniture from another house(They don't share reference but have same values)
        // Suggested way of doing it
        for(int i =0; i < p.fur.length;i++){
            this.fur[i+1] = new Furniture(p.fur[i].name, p.fur[i].weight);
        }
        /*
           This will share furniture reference between those 2 houses
            so changing one will change another
            This should be avoided
        for(int i =0; i < p.fur.length;i++){
            this.fur[i+1] = p.fur[i];
        }*/
    }