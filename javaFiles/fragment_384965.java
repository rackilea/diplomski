Set<String> set = new HashSet<String>();
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {


            for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {
                String children = childDataSnapshot.getValue(String.class);
                set.add(children);

            }