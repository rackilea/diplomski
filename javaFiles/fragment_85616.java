String[] texts  = new String[] { "employeeName:*borgy*","employeeName:Borgy Manotoy*","employeeName:*Borgy Manotoy*",
                           "employeeEmail:*borgymanotoy@iyotbihagay.com*","employeeEmail:borgymanotoy@iyotbihagay.com",
                           "employeeName:*Manotoy*, employeeEmail:*@iyotbihagay.*",
                           "employeeName:*Manotoy*, employeeEmail:*@iyotbihagay.*, employeeRole:*bouncer*"};
for (String s: texts) {
        processUserSearch(s);
    }
}