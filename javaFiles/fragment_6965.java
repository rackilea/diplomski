// firstname elements
        for(int i=1; i<5;i++){ 
            Element row= doc.createElement("row");    
            row.setAttribute("serialno",Integer.toString(i));
            rootElement.appendChild(row);
        }