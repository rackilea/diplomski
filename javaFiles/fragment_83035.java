package org.supercsv.io;

import java.io.Writer;

import org.supercsv.prefs.CsvPreference;

public class QuoteAllCsvBeanWriter extends CsvBeanWriter {

    public QuoteAllCsvBeanWriter(Writer writer, CsvPreference preference) {
        super(writer, preference);
    }

    @Override
    protected String escapeString(String csvElement) {

        // perform normal escaping
        final String escaped = super.escapeString(csvElement);

        // add surrounding quotes if required
        final String quote = String.valueOf((char) preference.getQuoteChar());
        if (escaped.startsWith(quote) && escaped.endsWith(quote)){
            return escaped;
        } else {
            return quote + escaped + quote;
        }
    }

}