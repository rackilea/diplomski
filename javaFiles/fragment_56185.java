try {
        if (datetime == null || "".equals(datetime))
            return null
        val gc = new GregorianCalendar()
        gc.setTime(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(datetime))
        val xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc)
        xgc.setMillisecond(DatatypeConstants.FIELD_UNDEFINED)
        xgc.setTimezone(DatatypeConstants.FIELD_UNDEFINED)
        return xgc
    } catch {
        case e: DatatypeConfigurationException => logger.error(e.fillInStackTrace()); throw new Exception(e.fillInStackTrace())
    }