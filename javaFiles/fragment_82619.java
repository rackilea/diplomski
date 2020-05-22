listOfObjects.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot querySnapshot) {
             queurySnapshot.getRef().removeValue()
        }
}