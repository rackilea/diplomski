Collections.sort(data, new Comparator<TXCartData>() {
        @Override
        public int compare(TXCartData lhs, TXCartData rhs) {
            int n1=Integer.parseInt(lhs.rowId);
            int n2=Integer.parseInt(rhs.rowId);
            if (n1>=n2){
                return 1;
            }
            return -1;
        }
    });