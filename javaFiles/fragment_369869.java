function sendSchema() {
        var schemaOption = document.getElementById('schemaName');
        var selectedSchema = schemaOption.options[schemaOption.selectedIndex].value;
        var url = "somepage.jsp?schema=" + selectedSchema;

        if (window.XMLHttpRequest) {
            request = new XMLHttpRequest();
        } else if (window.ActiveXObject) {
            request = new ActiveXObject("Microsoft.XMLHTTP");
        }

         request.onreadystatechange= function() 
                        {
                            if(this.readyState === 4 && this.status === 200) {
                            document.getElementById("table").innerHTML =this.responseText;// getting response and assign to div with id->table
                        }
                    }; 
                        request.open("GET",url,true);  
                        request.send();
    }