private void SetExcelReportParameter(JRXlsExporter exporterXLS,
                JasperPrint jasperPrint, ByteArrayOutputStream byteArrayOutputStream) {

            exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT,
                    jasperPrint);
            exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,
                    byteArrayOutputStream);
            exporterXLS.setParameter(JRXlsExporterParameter.IS_IGNORE_CELL_BORDER,
                    Boolean.FALSE);
            exporterXLS.setParameter(
                    JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
            exporterXLS.setParameter(
                    JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
                    Boolean.TRUE);
            exporterXLS.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN,
                    Boolean.TRUE);

            exporterXLS.setParameter(
                    JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,
                    Boolean.TRUE);
            exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
                    Boolean.FALSE);
            exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE,
                    Boolean.TRUE);

            exporterXLS.setParameter(JRXlsExporterParameter.IS_IMAGE_BORDER_FIX_ENABLED,
                    Boolean.TRUE);
            exporterXLS.setParameter(JRXlsExporterParameter.IS_FONT_SIZE_FIX_ENABLED,
                    Boolean.TRUE);

            exporterXLS.setParameter(JRXlsExporterParameter.IS_IGNORE_GRAPHICS,
                    Boolean.FALSE);

        }