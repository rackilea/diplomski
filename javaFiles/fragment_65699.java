switch (rs.getMetaData().getColumnType(i + 1)) {
                        case 93:
                            rowData[i] = rs.getDate(i + 1).toString() + "> " + rs.getTime(i + 1);
                            break;
                        case 4:
                            rowData[i] = rs.getInt(i + 1);
                            break;
                        case -5:
                            rowData[i] = rs.getLong(i + 1);
                            break;
                        case 7:
                            rowData[i] = rs.getFloat(i + 1);
                            break;
                        default:
                            rowData[i] = rs.getString(i + 1);
                            break;
                    }