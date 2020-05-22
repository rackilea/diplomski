public BigDecimal getTotal(){return custTotal;} //culprit --here

     public BigDecimal getTotal(){return custTotal;}//culprit --here
        public String getLast(){return custLast;}

        public void setName(String name){this.custName = name;}
        public void setTotal(String price){
            double current = Double.valueOf(String.valueOf(getTotal())); //culprit --here
            this.custTotal = BigDecimal.valueOf(Long.parseLong(current + price));
        }