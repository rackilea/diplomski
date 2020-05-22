if (sqlType == SqlTypeValue.TYPE_UNKNOWN || sqlType == Types.OTHER) {
            if (isStringValue(inValue.getClass())) {
                ps.setString(paramIndex, inValue.toString());
            }
            else if (isDateValue(inValue.getClass())) {
                ps.setTimestamp(paramIndex, new java.sql.Timestamp(((java.util.Date) inValue).getTime()));
            }
            else if (inValue instanceof Calendar) {
                Calendar cal = (Calendar) inValue;
                ps.setTimestamp(paramIndex, new java.sql.Timestamp(cal.getTime().getTime()), cal);
            }
            else {
                // Fall back to generic setObject call without SQL type specified.
                ps.setObject(paramIndex, inValue);
            }
        }