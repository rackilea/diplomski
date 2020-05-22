QUser $user = QUser.user;
QTransaction $transaction = QTransaction.transaction;
query().from($user)
    .innerJoin($user.transactions, $transaction) //inner join clause
    .where($user.eq(myUser))
    .singleResult($transaction.money.sum());