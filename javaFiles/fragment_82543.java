public native void loadResourcePdf(String fileName, VPdfViewer instance)/*-{
    var pdfviewer = instance.@pl.pdfviewer.client.ui.VPdfViewer::jsObject;
    pdfviewer.work = false;
    if ((pdfviewer.fileName == null || pdfviewer.fileName != fileName) && fileName != null) {
        $wnd.PDFJS.disableStream = true;
======> $wnd.PDFJS.workerSrc = 'APP/PUBLISHED/pdf.worker.js';
        $wnd.PDFJS.getDocument(fileName).then(function (pdf) {
            pdfviewer.pdfFile = pdf;
            pdfviewer.fileName = fileName;
            pdfviewer.pageCount = pdf.numPages;
            if (pdfviewer.pageNumber == 0 && pdf.numPages > 0) {
                pdfviewer.pageNumber = 1;
            }
            pdfviewer.showPdfPage(pdfviewer.pageNumber);
        });
    }

}-*/;