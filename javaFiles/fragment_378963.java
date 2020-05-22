pw.println("<div class=\"form-group\">");
   pw.println("<label class=\"control-label col-lg-2\">Employment Type <span class=\"required\">*</span></label>");
   pw.println("<div class=\"col-lg-10\">");

   if(!"".equalsIgnoreCase(j.getJobemptype()) && j.getJobemptype()!=null){

        if(j.getJobemptype().equalsIgnoreCase("Permanent")){

            pw.println("<select class=\"form-control m-bot15\" name=\"j_empType\" value='"+ j.getJobemptype() +"' required/> \n " +
               "<option value='"+ j.getJobemptype() +"'>"+j.getJobemptype()+"</option>\n " +
               "<option value=\"Contract\">Contract</option> \n " +
               "<option value=\"Temporary\">Temporary</option> \n " +
               "<option value=\"Part Time\">Part Time</option>");
            pw.println("</select>");

        }else if(j.getJobemptype().equalsIgnoreCase("Contract")){

            pw.println("<select class=\"form-control m-bot15\" name=\"j_empType\" value='"+ j.getJobemptype() +"' required/> \n " +
               "<option value='"+ j.getJobemptype() +"'>"+j.getJobemptype()+"</option>\n " +
               "<option value=\"Permanent\">Permanent</option> \n " +
               "<option value=\"Temporary\">Temporary</option> \n " +
               "<option value=\"Part Time\">Part Time</option>");
            pw.println("</select>");
        }else if(j.getJobemptype().equalsIgnoreCase("Temporary")){

            pw.println("<select class=\"form-control m-bot15\" name=\"j_empType\" value='"+ j.getJobemptype() +"' required/> \n " +
               "<option value='"+ j.getJobemptype() +"'>"+j.getJobemptype()+"</option>\n " +
               "<option value=\"Permanent\">Permanent</option> \n " +
               "<option value=\"Contract\">Contract</option> \n " +
               "<option value=\"Part Time\">Part Time</option>");
            pw.println("</select>");

        }else if(j.getJobemptype().equalsIgnoreCase("Part Time")){

                            pw.println("<select class=\"form-control m-bot15\" name=\"j_empType\" value='"+ j.getJobemptype() +"' required/> \n " +
                              "<option value='"+ j.getJobemptype() +"'>"+j.getJobemptype()+"</option>\n " +
                              "<option value=\"Permanent\">Permanent</option> \n " +
                              "<option value=\"Contract\">Contract</option> \n " +
                              "<option value=\"Temporary\">Temporary</option>");
                            pw.println("</select>");

                            }
                              }else {
                                pw.println("<select class=\"form-control m-bot15\" name=\"j_empType\" value='"+ j.getJobemptype() +"' required/> \n " +
                                  "<option value=\"Permanent\">Permanent</option> \n " +
                                  "<option value=\"Contract\">Contract</option> \n " +
                                  "<option value=\"Temporary\">Temporary</option> \n " +
                                  "<option value=\"Part Time\">Part Time</option>");
                                pw.println("</select>");
                                  }
    pw.println("</div>");
    pw.println("</div>");