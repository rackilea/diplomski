package com.example.demo.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pdf")
public class PdfMerger {

  @GetMapping
  public void merge(HttpServletResponse response) {
    Document document = new Document(PageSize.LETTER);

    response.setContentType("application/pdf");
    response.setHeader("Content-disposition", "attachment; filename=\"merged.pdf\"");

    OutputStream outputStream = null;
    try {
      outputStream = response.getOutputStream();
      PdfCopy copy = new PdfCopy(document, outputStream);

      document.open();

      for (InputStream file : getPdfs()) {
        copy.addDocument(new PdfReader(file)); // writes directly to the output stream
      }

      outputStream.flush();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (document.isOpen()) {
        document.close();
      }
      try {
        if (outputStream != null) {
          outputStream.close();
        }
      } catch (IOException ioe) {
        ioe.printStackTrace();
      }
    }
  }

  private List<InputStream> getPdfs() {
    List<InputStream> list = new ArrayList<>();

    for (int i = 0; i < 10; i++){
      list.add(PdfMerger.class.getResourceAsStream("/pdf/1.pdf"));
      list.add(PdfMerger.class.getResourceAsStream("/pdf/2.pdf"));
    }

    return list;
  }

}