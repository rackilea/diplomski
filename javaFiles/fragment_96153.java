while ((url = queue.poll()) != null){
    LOG.info("Picked url " + url);
    cachedThreadPool.submit(new ParserCallable(content, url));
}
// shutdown _after_ all jobs have been submitted
cachedThreadPool.shutdown();