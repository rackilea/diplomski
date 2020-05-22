} catch(IOException e1) {
    logger.log(Level.FINER, "ServerImpl.Exchange (1)", e1);
    closeConnection(this.connection);
} catch(NumberFormatException e3) {
    reject(Code.HTTP_BAD_REQUEST, requestLine, "NumberFormatException thrown");
} catch(URISyntaxException e) {
    reject(Code.HTTP_BAD_REQUEST, requestLine, "URISyntaxException thrown");
} catch(Exception e4) {
    logger.log(Level.FINER, "ServerImpl.Exchange (2)", e4);
    closeConnection(connection);
}