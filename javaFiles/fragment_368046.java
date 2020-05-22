Query query = FirebaseDatabase.getInstance().getReference().child("Details");

long oneWeekInMillis = 7 * 24 * 60 * 60 * 1000;
long oneWeekAgo = System.currentTimestampMillis() - oneWeekInMillis;
long twoWeeksAgo = oneWeekAgo - oneWeekInMillis;

query = query.orderByChild(timestamp).startAt(twoWeeksAgo).endAt(oneWeekAgo);