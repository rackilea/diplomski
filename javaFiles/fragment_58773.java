package de.mystuff.hibernate;

import java.util.List;

import org.hibernate.annotations.common.util.StringHelper;
import org.hibernate.dialect.SQLServer2008Dialect;


/**
 * Special version of {@link SQLServer2008Dialect} which adds a simple query hint support.
 */
public class MySQLServer2012Dialect extends org.hibernate.dialect.SQLServer2012Dialect {


    /**
     * {@inheritDoc}
     * <p>
     * Currently this is a pretty simple query hint implementation. It just concatenates all SQL hints and adds them to the end of the query. This is fine for
     * e.g. {@code OPTION (RECOMPILE)}.
     */
    @Override
    public String getQueryHintString(String sql, List<String> hints) {
        if (hints.isEmpty()) {
            // no query hints at all
            return sql;
        }

        // concatenate all hints
        final String hint = StringHelper.join(", ", hints.iterator());

        if (StringHelper.isEmpty(hint)) {
            // all query hints are empty
            return sql;
        }

        return sql + " " + hint;
    }

}