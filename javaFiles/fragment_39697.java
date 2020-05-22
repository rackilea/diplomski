%module  test_app 
%{
#include "example.h"

    void callwebsocketreq(sample_websocket_module *mod, 
               sample_websocket_handle * handle,
                sample_websocket_config * config) {
        (*mod->websocket_request)(handle,config);
    }

%}

%include "example.h"
void callwebsocketreq(sample_websocket_module *mod, 
               sample_websocket_handle * handle,
                sample_websocket_config * config);