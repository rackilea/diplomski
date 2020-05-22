import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;
import java.util.Vector;

import lotus.domino.Database;
import lotus.domino.Document;
import lotus.domino.NotesException;
import lotus.domino.Session;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.INullSelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.progress.UIJob;

import com.ibm.csi.types.DocumentSummary;
import com.ibm.notes.java.api.util.NotesSessionJob;
import com.ibm.notes.java.ui.documents.NotesUIField;
import com.ibm.workplace.noteswc.selection.NotesApplicationInfo;
import com.ibm.workplace.noteswc.selection.NotesFieldSelection;
import com.ibm.workplace.noteswc.selection.NotesTextSelection;

public class NotesSelectionObservable implements INullSelectionListener {
    public void addObserver(NotesSelectionObserver cObserver) {
        if (!this.m_cObserverList.contains(cObserver))
            this.m_cObserverList.add(cObserver);
    }

    public void removeObserver(NotesSelectionObserver cObserver) {
        this.m_cObserverList.remove(cObserver);
    }

    public void selectionChanged(IWorkbenchPart cPart, ISelection cSelection) {
        if (cSelection == null || cSelection.isEmpty())
            this.clearSelection();
        else if (cSelection instanceof StructuredSelection) {
            Object cObj = ((StructuredSelection) cSelection).getFirstElement();
            if (cObj instanceof DocumentSummary) {
                DocumentSummary cSummary = (DocumentSummary) cObj;
                this.setURL(cSummary.getUrl());
                if (cSummary.getDocumentKey() != null)
                     this.setURL(cSummary.getDocumentKey().getUniqueId());
            } else if (cObj instanceof NotesApplicationInfo) {
                NotesApplicationInfo cInfo = (NotesApplicationInfo) cObj;
                this.setURL(cInfo.getUrl());
            }
            if (cObj instanceof NotesFieldSelection) {
                NotesUIField f = ((NotesFieldSelection)cObj).getCurrentField();
                this.setField(f.getName());
            }
            if (cObj instanceof NotesTextSelection) {
                // String strOut = ((NotesTextSelection) cObj).getText();
                // System.out.println("Selektierter Text: " + strOut);
            }
            if (false) {
                Class<? extends Object> c;
                String cl = null;
                for (c = cObj.getClass(); c != null; c = c.getSuperclass()) {
                    if (c.equals(Object.class))
                        break;
                    cl = cl != null ? cl + " : " + c.getName() : c.getName();
                }
                System.out.println("Type of selected object: " + cl);
            }
        }
        if (this.m_bModified) {
            this.startJob();
            this.m_bModified = false;
        }
    }

    private void clearSelection() {
        this.m_strDatabaseRepID = null;
        this.m_strDatabaseServer = null;
        this.m_strDocumentUNID = null;
        this.m_strDesginElement = null;
        this.m_strField = null;
        this.m_bModified = true;
    }

    private void setDatabase(String strRepID, String strServer) {
        if (strRepID.equals(this.m_strDatabaseRepID) == false
                || (strServer != null && this.m_strDatabaseServer == null)
                || (this.m_strDatabaseServer != null && this.m_strDatabaseServer.equals(strServer) == false)) {
            this.m_strDatabaseRepID = strRepID;
            this.m_strDatabaseServer = strServer;
            this.m_strDesginElement = null;
            this.m_strDocumentUNID = null;
            this.m_strField = null;
            this.m_bModified = true;
        }
    }

    private void setDesignElement(String strUNID) {
        if (!strUNID.equals(this.m_strDesginElement)) {
            this.m_strDesginElement = strUNID;
            this.m_strDocumentUNID = null;
            this.m_strField = null;
            this.m_bModified = true;
        }
    }

    private void setDocument(String strDocumentUNID) {
        if (!strDocumentUNID.equals(this.m_strDocumentUNID)) {
            this.m_strDocumentUNID = strDocumentUNID;
            this.m_strField = null;
            this.m_bModified = true;
        }
    }

    private void setField(String strField) {
        if (!strField.equals(this.m_strField)) {
            this.m_strField = strField;
            this.m_bModified = true;
        }
    }

    private void setURL(String strURL) {
        if (strURL == null || strURL.isEmpty())
            return;
        URL cURL;
        try {
            cURL = new URL(strURL);
        } catch (MalformedURLException e) {
            return;
        }
        if (!cURL.getProtocol().equalsIgnoreCase("notes"))
            return;
        StringTokenizer cToken = new StringTokenizer(cURL.getPath()
                .substring(1), "/");
        if (cToken.hasMoreElements())
            this.setDatabase(cToken.nextToken(),
                    cURL.getHost().isEmpty() ? null : cURL.getHost());
        else
            return;
        if (cToken.hasMoreElements())
            this.setDesignElement(cToken.nextToken());
        else
            return;
        if (cToken.hasMoreElements())
            this.setDocument(cToken.nextToken());
    }

    private void startJob() {
        if (this.m_strDatabaseRepID != null && this.m_cObserverList.size() > 0) {
            Job cJob = new TheJob(this);
            cJob.schedule();
            try {
                cJob.join();
                for (NotesSelectionObserver o : this.m_cObserverList)
                    o.onUpdateAfterSelectionChange();
                this.m_bModified = false;
            } catch (InterruptedException e) {
                return;
            }
            cJob = new TheUIJob(this);
            cJob.schedule();
        }
    }

    private class NotesSelectionContextImp implements NotesSelectionContext {
        public Database getDatabase() {
            return cDatabase;
        }

        public Document getDocument() {
            return cDocument;
        }

        public String getField() {
            return strField;
        }

        public Database cDatabase;
        public Document cDocument;
        public String strField;
    }

    private class TheJob extends NotesSessionJob {
        public TheJob(NotesSelectionObservable cObservable) {
            super(cObservable.getClass().getName() + ".selectionChanged()");
            this.m_strRepID = cObservable.m_strDatabaseRepID;
            this.m_strServer = cObservable.m_strDatabaseServer != null ? cObservable.m_strDatabaseServer
                    : "";
            if (this.m_strServer.contains("%2F"))
                this.m_strServer = this.m_strServer.replace("%2F", "/");
            this.m_strDocumentUNID = cObservable.m_strDocumentUNID;
            this.m_cContext.strField = cObservable.m_strField;
            this.m_cObservable = cObservable;
        }

        protected IStatus runInNotesThread(Session cSession,
                IProgressMonitor cProgress) throws NotesException {
            this.m_cContext.cDatabase = cSession.getDbDirectory(this.m_strServer).openDatabaseByReplicaID(this.m_strRepID);
            if (!this.m_cContext.cDatabase.isOpen()) {
                this.m_cContext.cDatabase.open();

            }
            this.m_cContext.cDocument = this.m_strDocumentUNID != null ? this.m_cContext.cDatabase.getDocumentByUNID(this.m_strDocumentUNID)
                    : null;
            for (NotesSelectionObserver o : this.m_cObservable.m_cObserverList)
                o.onSelectionChange(this.m_cContext);
            return Status.OK_STATUS;
        }

        private NotesSelectionContextImp m_cContext = new NotesSelectionContextImp();
        private NotesSelectionObservable m_cObservable;
        private String m_strRepID;
        private String m_strServer;
        private String m_strDocumentUNID;
    }

    private class TheUIJob extends UIJob {
        public TheUIJob(NotesSelectionObservable cObservable) {
            super(cObservable.getClass().getName() + ".selectionChanged()");
            this.m_cObservable = cObservable;
        }

        public IStatus runInUIThread(IProgressMonitor arg0) {
            for (NotesSelectionObserver o : this.m_cObservable.m_cObserverList)
                o.onUpdateAfterSelectionChange();
            this.m_cObservable.m_bModified = false;
            return Status.OK_STATUS;
        }

        private NotesSelectionObservable m_cObservable;
    }

    private String m_strDatabaseRepID = null;
    private String m_strDatabaseServer = null;
    private String m_strDesginElement = null;
    private String m_strDocumentUNID = null;
    private String m_strField = null;
    private boolean m_bModified = false;
    private Vector<NotesSelectionObserver> m_cObserverList = new Vector<NotesSelectionObserver>();
}