try {
   //some code
}
} catch (Exception ex) {
        logger.error(ex);
        ErrorData error = new ErrorData();
        error.setCode("99");
        error.setMessage("General System Error");

        //pass the message to OutboundAdapter
        ctx.writeAndFlush(error);
} finally {
  ctx.close();
}