switch (rs.getMetaData().getColumnType(i + 1)) {
                        case 93: //DATE
                            rowData[i] = rs.getDate(i + 1).toString() + "> " + rs.getTime(i + 1);
                            break;
                        default:
                            rowData[i] = rs.getString(i + 1);
                            break;
                    }