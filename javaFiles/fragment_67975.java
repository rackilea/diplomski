$("#people").getOrgChart({      
        theme: "deborah",
        primaryColumns: ["name", "phone"],
        imageColumn: "image",
        dataSource: "load-from-xml.xml"
    });