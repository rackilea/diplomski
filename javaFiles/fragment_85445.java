Iterator<ProcessingStep> i = element.processingSteps.iterator();

while (i.hasNext()) {
       ProcessingStep step = i.next(); 
       if (step.type.equals("FormStepCreateUpdateContactFromFormField")){
           fieldMapping = step.mappings;
           step.execute = "never";
           //i.remove();
        }
     }
// Update contact field IDs with CDO field IDs
    fieldMapping = createFormFieldsMapping(CDOfields, fieldMapping, element);