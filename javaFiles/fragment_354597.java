package com.quicklyjava;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class JavaReadPDF {


/**
 * @param args
 */
public static void main(String[] args) {
    // TODO Auto-generated method stub
    try {
        PdfReader reader = new PdfReader("c:/XML.pdf");
        String page1 = PdfTextExtractor.getTextFromPage(reader, 1);
        InputStream is = new ByteArrayInputStream(page1.getBytes());
        System.out.println(page1);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

}

}