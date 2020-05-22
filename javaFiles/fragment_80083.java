SignerInfoGenerator sigGen = new JcaSignerInfoGeneratorBuilder( new JcaDigestCalculatorProviderBuilder().build())
            .build(shaSigner, certificate);

    final CMSAttributeTableGenerator sAttrGen = sigGen.getSignedAttributeTableGenerator();
    sigGen = new SignerInfoGenerator(sigGen, new
            DefaultSignedAttributeTableGenerator(){
                @Override
                public AttributeTable getAttributes(@SuppressWarnings("rawtypes")
                                                            Map parameters) {
                    AttributeTable ret = sAttrGen.getAttributes(parameters);
                    return ret.remove(CMSAttributes.cmsAlgorithmProtect);
                }
            }, sigGen.getUnsignedAttributeTableGenerator());
    gen.addSignerInfoGenerator(sigGen);