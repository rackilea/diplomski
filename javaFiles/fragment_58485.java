package com.raspberry.struts.action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import com.opensymphony.xwork2.ActionSupport;
import com.raspberry.dao.control.DBControl;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;

public class DownloadAction extends ActionSupport implements ServletRequestAware {

    public InputStream fileInputStream;
        public HttpSession session;
        public Connection c;
        public String fechaFin;// = null;
        public String fechaInicio; // = null;

        public String goDataRecovery(){
            session.setAttribute("mainopt", "dataRecovery");
            return SUCCESS;
        }

    public InputStream getFileInputStream() throws Exception {           
            return fileInputStream;
    }

        public String doDataRecovery() throws ParseException, FileNotFoundException{
            DBControl dato = new DBControl();

            fechaInicio = getFechaInicio();
            fechaFin = getFechaFin();

            DateFormat df = new SimpleDateFormat("yyyMMMddkkmm");            
            String fecha = df.format(Calendar.getInstance().getTime());

            String lectura = dato.selecAlltLecturasFecha(fechaInicio, fechaFin);

            File archivo = new File ("/media/recovery"+fecha+".txt");
            archivo.getParentFile().mkdirs();
            PrintWriter printWriter;

            printWriter = new PrintWriter(archivo);
            printWriter.println (lectura);
            printWriter.close();

            return SUCCESS;        
        }

        public String getFechaFin() {        
            return fechaFin;
        }

        public String getFechaInicio() {
            return fechaInicio;
        }

    public String execute() throws Exception {

            doDataRecovery();

            DateFormat df = new SimpleDateFormat("yyyMMMddkkmm");            
            String fecha = df.format(Calendar.getInstance().getTime());

            fileInputStream = new FileInputStream(new File ("/media/recovery"+fecha+".txt"));

        return SUCCESS;
    }

        @Override
        public void setServletRequest(HttpServletRequest hsr) {
            session = hsr.getSession();
        }
}