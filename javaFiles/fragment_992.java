package com.myapp.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import net.sf.log4jdbc.Properties;
import net.sf.log4jdbc.log.log4j2.Log4j2SpyLogDelegator;
import net.sf.log4jdbc.sql.Spy;

public class QueryLogDelegator extends Log4j2SpyLogDelegator {

    private static final Logger LOGGER = LogManager.getLogger("log4jdbc.log4j2");

    private static final Marker SQL_MARKER = MarkerManager.getMarker("LOG4JDBC_SQL");

    private static final Marker SELECT_MARKER = MarkerManager.getMarker("LOG4JDBC_SELECT", SQL_MARKER);

    private static final Marker INSERT_MARKER = MarkerManager.getMarker("LOG4JDBC_INSERT", SQL_MARKER);

    private static final Marker UPDATE_MARKER = MarkerManager.getMarker("LOG4JDBC_UPDATE", SQL_MARKER);

    private static final Marker DELETE_MARKER = MarkerManager.getMarker("LOG4JDBC_DELETE", SQL_MARKER);

    private static final Marker CREATE_MARKER = MarkerManager.getMarker("LOG4JDBC_CREATE", SQL_MARKER);

    private String getSqlOperation(String sql) {
        if (sql == null) {
            return "";
        }
        sql = sql.trim();

        if (sql.length() < 6) {
            return "";
        }
        return sql.substring(0, 6).toLowerCase();
    }

    private boolean shouldSqlBeLogged(String operation) {
        return ((operation == null) || ((Properties.isDumpSqlSelect()) && ("select".equals(operation)))
                || ((Properties.isDumpSqlInsert()) && ("insert".equals(operation))) || ((Properties.isDumpSqlUpdate()) && ("update".equals(operation)))
                || ((Properties.isDumpSqlDelete()) && ("delete".equals(operation))) || ((Properties.isDumpSqlCreate()) && ("create".equals(operation))));
    }

    @Override
    public void sqlTimingOccurred(Spy spy, long execTime, String methodCall, String sql) {
        String operation = getSqlOperation(sql);
        if ((Properties.isDumpSqlFilteringOn()) && (!(shouldSqlBeLogged(operation)))) {
            return;
        }

        Marker marker = getStatementMarker(operation);

        if ((Properties.isSqlTimingErrorThresholdEnabled()) && (execTime >= Properties.getSqlTimingErrorThresholdMsec())) {
            LOGGER.error(marker, sql);
        } else if (LOGGER.isWarnEnabled())
            if ((Properties.isSqlTimingWarnThresholdEnabled()) && (execTime >= Properties.getSqlTimingWarnThresholdMsec())) {
                LOGGER.warn(marker, sql);
            } else
                LOGGER.info(marker, sql);
    }

    private Marker getStatementMarker(String operation) {
        if (operation == null)
            return SQL_MARKER;
        if ("select".equals(operation))
            return SELECT_MARKER;
        if ("insert".equals(operation))
            return INSERT_MARKER;
        if ("update".equals(operation))
            return UPDATE_MARKER;
        if ("delete".equals(operation))
            return DELETE_MARKER;
        if ("create".equals(operation)) {
            return CREATE_MARKER;
        }
        return SQL_MARKER;
    }

}