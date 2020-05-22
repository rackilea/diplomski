public ActionForward confirmEliminarTareas(ActionMapping mapping, ActionForm form,
    HttpServletRequest request, HttpServletResponse response) {

    RenderBandejasForm bandejaForm = (RenderBandejasForm) form;

    request.setAttribute(Constants.TAREAS, 
        Arrays.toString(bandejaForm.getTareasSeleccionadas()));        
    request.setAttribute(Constants.TIPO_BANDEJA,
            bandejaForm.getTipoBandeja());
    request.setAttribute(Constants.TIPO_TAREA, bandejaForm.getTipoTarea());

    return mapping.findForward("confirmEliminarTareas");
}