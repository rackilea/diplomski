/* Things begins to get very messy here */
    public Builder subject(String subject)   {
        ((Student)reference).subjects.add(subject);          
        return this;
    }

    @Override public Student build() {          
        return (Student)super.build();
    }