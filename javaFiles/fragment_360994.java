for (int i = 0; i < objectList.size(); i++) 
            {
                if (i == left) {
                    swappedList.add((GeometricObject) objectList.get(right));
                }else if (i == right)
                    swappedList.add((GeometricObject) objectList.get(left));
                else {
                    swappedList.add((GeometricObject) objectList.get(i));
            }
        }