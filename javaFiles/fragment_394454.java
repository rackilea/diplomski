<bean id="pdfReport"
      class="org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView"
      p:url="classpath:chathuranga-sample-report.jrxml"
      p:reportDataKey="datasource"> 

      <property name="headers">
        <props>
            <prop key="Content-Disposition">
                 attachment; filename=pdffilename.pdf
            </prop>
        </props>
  </property>
</bean>