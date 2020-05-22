class MySet<E> extends TreeSet<E> {
        public void union(Set<E> s){
            addAll(s);
        }

        public void intersection(Set<E> s){
            retainAll(s);
        }
    }