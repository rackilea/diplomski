public ActionForward execute(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {

    MyForm theForm = (MyForm) form;
    String name = theForm.getName();

    if (name == null || "".equals(name)) {
        // error case; name is required
        // do something
    }

    if(getErrors(request) == null ||getErrors(request).size() == 0)
        return mapping.findForward("success");
    else
        return mapping.getInputForward();

}