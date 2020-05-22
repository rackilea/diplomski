public IntegrationFlow getContraindicationsByDrugcodeAndIcd10WorkFlow() {
       //new ContraindicationRequest("string", "string");
       return IntegrationFlows
               .from(Http.inboundGateway("/contraindicationsbydrugcodeandicd10/{code}/{icd10}")
                       .payloadExpression("new net.eir.nexus.model.dto.api.dit.request.ContraindicationRequest(#pathVariables.code, #pathVariables.icd10)")
                       .requestMapping(m -> m.methods(HttpMethod.GET))
                       .errorChannel(IntegrationConfiguration.CHANNEL_ERROR_REST)
               )
               `enter code here`///dit/contraindicationsbydrugcodes/1234567890/Y12319,Y20743/Z34,I10,E0810?icdtype=icd10&format=json
               .handle(Http.outboundGateway(url + "/{code}/{icd10}?icdtype=icd10&format=json")
                       .httpMethod(HttpMethod.GET)
                       .uriVariable("code", "payload.drugCode")
                       .uriVariable("icd10", "payload.icd10")
                       .expectedResponseType(ContraindicationsByDrugcodeAndIcd10Response.class))
                 .transform(ContraindicationsByDrugcodeAndIcd10Response::getAllergyIngredient)
               .get();