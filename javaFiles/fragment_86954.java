fileName = dateString+"_マイページ情報.xls"; 
fileName = URLEncoder.encode(fileName,"UTF-8"); 
try {
        response.setContentType("application/ms-excel; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        if(browserType.equals("IE")||browserType.equals("Chrome"))
            response.setHeader("Content-Disposition","attachment; filename="+fileName);
        if(browserType.endsWith("Firefox"))
            response.setHeader("Content-Disposition","attachment; filename*=UTF-8''"+fileName);
    } catch (Exception e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }