Iterator<IWebParser> it = pc.webParser.iterator();
while (it.hasNext()) {
    IWebParser parser = it.next();
    logger.trace("trying parser " + parser.getClass().getSimpleName().toString());
    if (parser.canExecute(url)) {
        return parser.parse(page, url, tTerms);
    } else {
        logger.trace("parser " + parser.getClass().getSimpleName().toString() + " returned false to canExecute()" );
    }
}