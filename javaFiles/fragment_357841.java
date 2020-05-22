try {
        t1 = (TestBikes)super.clone(); // creates a clone of temp, not a TestBikes
        t1 = (TestBikes)this.clone(); // does the same thing  
        t1 = (TestBikes)clone(); // does the same thing  

    } catch (CloneNotSupportedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }