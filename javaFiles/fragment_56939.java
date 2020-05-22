public Integer test() {
    try {
        return this.ID;   //Still 0 at time of return
    } finally {
        this.ID = 2;     //This still gets executed, but after the return value is stored
    }
}