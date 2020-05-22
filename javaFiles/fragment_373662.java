public E getFirst() {
            if(head == null) {
                throw new NoSuchElementException("Element was null!");
            }else {
                return (E) head.data;
            }

        }

        public E getLast(){
            if(head == null) {
                throw new NoSuchElementException("Element was null!");
            }
            else{
                for(Node iterate=head; iterate!=null; iterate=iterate.next){
                    return (E) iterate.data;
                }

            }
        }