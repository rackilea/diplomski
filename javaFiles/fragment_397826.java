Transaction transaction = pendingList.get(0);
SendRequest request = SendRequest.forTx(transaction);
request.feePerKb = Transaction.REFERENCE_DEFAULT_MIN_TX_FEE; // Or you can make other highter fee to spped it up

wallet.completeTx(request);
wallet.commitTx(request);