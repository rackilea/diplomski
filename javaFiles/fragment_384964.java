ArrayList<String> values=new ArrayList<String>();

        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {


            for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {
                String children = childDataSnapshot.getValue(String.class);
                if (!values.contains(children)) {
                    values.add(newValue);
                }

            }