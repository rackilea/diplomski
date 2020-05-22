function somefunc(exptype) {
            getSelectedText();
            var reportURL = '<bean:write name="systemDto" property="documenturl"/>';
            var somevalue = '';
            if (checkFields() > 0) {
                //validating all input parameters 
                //set the export type document.form.elements["Type"].value = exptype; 
                var frm = document.form;
                document.form.elements["sysdto.datavalue"].value = somevalue;
                document.reportForm.action = "getItcLeadsReport.do";
                if (exptype == digitvalue) {
                    document.form.action = URL + "?documentName=somereport";
                     var IS_IPAD = navigator.userAgent.match(/iPad/i) != null;
                     if (IS_IPAD == true) 
                     {
                       document.form.target = "_blank";
                     }                          
                 }
                frm.submit();
            }
            return 0;
        }