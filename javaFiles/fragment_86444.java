if (arraylistSelectedConsumerIds != null) {
    for (int i = 0; i <arraylistSelectedConsumerIds.size(); i++) {

            ConsumerId = arraylistSelectedConsumerIds.get(i);
            databaseAdapter.updateEmailmark(ConsumerId);
            Toast.makeText(AdminActivity.this,"consumer id" + ConsumerId, Toast.LENGTH_LONG).show();
    }
}