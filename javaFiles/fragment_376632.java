public void addFirst(Item item) throws Exception {

      ... unchanged handling of capacity...

        holder[this.frontIndex] = item;
        //CHECK OF THE 2 INDEXES
        if(this.frontIndex==this.backIndex){
            this.backIndex= floorMod((this.backIndex - 1), capacity);
        }
        this.frontIndex = floorMod((this.frontIndex + 1), capacity);
        size++;
    }

     public void addLast(Item item) throws Exception {

      ... unchanged handling of capacity...

        holder[this.backIndex] = item;
        if(this.frontIndex==this.backIndex){
            this.frontIndex= floorMod((this.frontIndex + 1), capacity);
        }
        this.backIndex = floorMod((this.backIndex - 1), capacity);
        size++;
    }