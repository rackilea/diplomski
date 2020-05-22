/**
     * Map to given objects taking into account the inclusion and exclusion sets.
     * 
     * @param mapFrom The object to map attribute values from
     * @param mapTo   The object to map attribute values to
     */
    private void map(Object mapFrom, Object mapTo)
    {
        setMapFilter(mapFrom, mapTo);

        for (Method sMethod : filterMap.keySet())
        {            
            try
            {
               //Find the corresponding getter method to retrieve the attribute value from
                Method gMethod = filterMap.get(sMethod);

                //Invoke the getter to get the attribute to set
                Object attValue = gMethod.invoke(mapFrom, new Object[0]);

                //Get the mapping types and check their compatibility, if incompatible convert attValue type to toType
                Class<?> fromType = gMethod.getReturnType();
                Class<?> toType   = sMethod.getParameterTypes()[0];

                if(!toType.isAssignableFrom(fromType) && Objects.isNotNull(attValue))
                {
                    attValue = parseType(attValue, toType);
                } //if

                //Invoke the setter to set the attribute value
                sMethod.invoke(mapTo, attValue);
            }
            catch (IllegalArgumentException e)
            {
                Logger.getLogger(Constants.APP_LOGGER).fine("Exception in DataFormMappingService.map: "
                                                          + "IllegalArgumentException " + e.getMessage());
                continue;
            }
            catch (IllegalAccessException e)
            {
                Logger.getLogger(Constants.APP_LOGGER).fine("Exception in DataFormMappingService.map: "
                                                          + "IllegalAccessException " + e.getMessage());
                continue;
            }
            catch (InvocationTargetException e)
            {
                Logger.getLogger(Constants.APP_LOGGER).fine("Exception in DataFormMappingService.map: "
                                                          + "InvocationTargetException " + e.getMessage());
                continue;
            }
        } //for each
    } //map

    /**
     * Refactored method to parse an object, attValue, from it's unknown type to the type expected.
     * 
     * @param attValue The attribute value to parse
     * @param type     The type expected/to convert to
     * @return         The attribute value in the expected type, null otherwise
     */
    private Object parseType(Object attValue, Class<?> type)
    {
        Object newAttValue = null;

        if (isLiteral(type))
        {
            newAttValue = attValue.toString();
        }
        else if (isByte(type))
        {
            newAttValue = Byte.valueOf(attValue.toString());
        }
        else if (isInt(type))
        {
            newAttValue = Integer.valueOf(attValue.toString());
        }
        else if (isShort(type))
        {
            newAttValue = Short.valueOf(attValue.toString());
        }
        else if (isLong(type))
        {
            newAttValue = Long.valueOf(attValue.toString());
        }
        else if (isFloat(type))
        {
            newAttValue = Float.valueOf(attValue.toString());
        }
        else if (isDouble(type))
        {
            newAttValue = Double.valueOf(attValue.toString());
        }
        else if (isBoolean(type))
        {
            newAttValue = Boolean.valueOf(attValue.toString());
        } //if-else if*

        return newAttValue;
    } //parseType