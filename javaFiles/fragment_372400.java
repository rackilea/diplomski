public boolean equals(Object o)
{
    return this.code.equals(o); // this will never return true,
                                // since you are comparing an Integer instance
                                // to an ID instance
}