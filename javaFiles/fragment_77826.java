Map<String, Object> values = new HashMap<>();
values.put("users", "someValue");
values.put("services", "someValue2");
values.put("stores", "someValue3");
mDb.updateChildren(values).addOnCompleteListener(new OnCompleteListener<Void>() {
    @Override
    public void onComplete(@NonNull Task<Void> task) {
        // All writes either completed, or none happened
    }
});