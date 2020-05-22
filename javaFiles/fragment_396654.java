final ArrayList<MyObject> objects = new ArrayList<>();
            for (DataSnapshot child : children) {
                MyObject object = child.getValue(MyObject.class);
                objects.add(object);
            }
            MyObject objectToUse = objects.get(i);