CuratorTransaction curatorTransaction = client.inTransaction();

for (Map.Entry<String, String> entry : transactionInfo.entrySet()) {
    curatorTransaction = curatorTransaction
        .setData().forNode(entry.getKey(), entry.getValue()).and();
}

// If there was at least one entry in transactionInfo, and() makes it a CuratorTransactionFinal
if (curatorTransaction instanceof CuratorTransactionFinal) {
    ((CuratorTransactionFinal)curatorTransaction).commit();
}