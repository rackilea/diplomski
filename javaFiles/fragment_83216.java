package com.basilbourque.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class DailyProductFileHandler {
    public List < DailyProduct > read ( Path path ) {
        // TODO: Add a check for valid file existing.

        List < DailyProduct > list = List.of();  // Default to empty list.
        try {
            // Prepare list.
            int initialCapacity = ( int ) Files.lines( path ).count();
            list = new ArrayList <>( initialCapacity );

            // Read CSV file. For each row, instantiate and collect `DailyProduct`.
            BufferedReader reader = Files.newBufferedReader( path );
            Iterable < CSVRecord > records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse( reader );
            for ( CSVRecord record : records ) {
                // date,name,quantity,quality,realmQ,cost
                LocalDate localDate = LocalDate.parse( record.get( "date" ) );
                String name = record.get( "name" );
                Integer quantity = Integer.valueOf( record.get( "quantity" ) );
                BigDecimal quality = new BigDecimal( record.get( "quality" ) );
                BigDecimal realmQ = new BigDecimal( record.get( "realmQ" ) );  // Note: case-sensitive.
                BigDecimal cost = new BigDecimal( record.get( "cost" ) );
                // Instantiate `DailyProduct` object, and collect it.
                DailyProduct dailyProduct = new DailyProduct( localDate , name , quantity , quality , realmQ , cost );
                list.add( dailyProduct );
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        return list;
    }

    public void write ( final List < DailyProduct > dailyProducts , final Path path ) {
        try ( final CSVPrinter printer = CSVFormat.RFC4180.withHeader( "date" , "name" , "quantity" , "quality" , "realmQ" , "cost" ).print( path , StandardCharsets.UTF_8 ) ; ) {
            for ( DailyProduct dp : dailyProducts ) {
                printer.printRecord( dp.localDate , dp.name , dp.quantity , dp.quality , dp.realmQ , dp.cost );
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    public static void main ( final String[] args ) {
        DailyProductFileHandler fileHandler = new DailyProductFileHandler();

        Path pathInput = Paths.get( "/Users/basilbourque/data.csv" );
        List < DailyProduct > list = fileHandler.read( pathInput );
        System.out.println( list );

        String when = Instant.now().truncatedTo( ChronoUnit.SECONDS ).toString().replace( ":" , "•" );
        Path pathOutput = Paths.get( "/Users/basilbourque/data_" + when + ".csv" );
        fileHandler.write( list , pathOutput );
        System.out.println( "Writing file: " + pathOutput );
    }
}