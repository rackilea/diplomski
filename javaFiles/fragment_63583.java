gameLogicPool.send(new Runnable() {
         //your logic here
         ctx.write(response);
         //ctx.write actually does this when executed from another thread:
         ctx.executor().execute(new Runnable() {
             //write happens here when you are in event executor already
             }
         );
    }
);