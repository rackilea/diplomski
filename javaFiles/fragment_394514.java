Node searchRec(Node Temp, int key) {

            if (Temp != null) {
                Node t = null;
                if (key > Temp.item) {
                    t = searchRec(Temp.right, key);
                    return t;
                }
                if (key < Temp.item) {
                    t = searchRec(Temp.left, key);
                    return t;
                }
                if (key == Temp.item)
                    return Temp;
            }
            return Temp;
        }