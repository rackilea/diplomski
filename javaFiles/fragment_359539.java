private String getToken() {
    final StringBuilder token = new StringBuilder() ;
    final CountDownLatch countDownLatch = new CountDownLatch(1) ;
    FirebaseAuth.getInstance().getCurrentUser().getToken(true).addOnCompleteListener(new OnCompleteListener<GetTokenResult>() {
        @Override
        public void onComplete(@NonNull Task<GetTokenResult> task) {
            token.append(task.getResult().getToken());
            countDownLatch.countDown();
        }
    });
    try {
        countDownLatch.await(30L, TimeUnit.SECONDS);
        return token.toString() ;
    } catch (InterruptedException ie) {
        return null;            
    }
}