try{

            HttpServletResponse res = PortalUtil.getHttpServletResponse(response);
            String url = PortalUtil.getCurrentCompleteURL(PortalUtil.getHttpServletRequest( req ) );
            String param1=getParamValue(url,"p");//logic here to return param from URL

            if(param1!=null && param1.trim().length()>0){
                requestPageNumber=Integer.parseInt(param1);
            }

            if(requestPageNumber<=uiState.getPageNunmber())//valid
            {}
            else//invalid
            {
                res.sendRedirect( "/proposerdetails?p="+uiState.getPageNunmber() );
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }