String ext = fileNameOri.substring(fileNameOri.lastIndexOf(".") + 1);
        switch (ext.toLowerCase()) {
        case "xlsx": 
            ct = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
            break;
        }