function ajaxWebFlowSubmitGet(divID,pars,view) {
    new Ajax.Updater({success:divID},
                        view+"&date="+new Date().getTime(),
                        {   method:'get',
                            parameters:pars,
                            evalScripts:true,
                            onFailure:reportError,
                            requestHeaders: ['Accept','text/html;type=ajax']    
                        });
}