report



        .columnHeader(//title of the report


              Components.text("Tax Invoice Cum Delivery Challan").setStyle(boldStyle).setFixedHeight(10)
              .setHorizontalAlignment(HorizontalAlignment.CENTER))

             .columns(
                     col.column("", "companyName", type.stringType()).setFixedWidth(200).setStyle(col1style))

              .pageFooter(Components.pageXofY())//show page number on the page footer
              .setDataSource("SELECT companyName FROM marketing_database.company_profile", 
                                      connection);

        try {
                    //show the report
            report.show();

                    //export the report to a pdf file
            report.toPdf(new FileOutputStream("c:/report.pdf"));
        } catch (DRException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
      }