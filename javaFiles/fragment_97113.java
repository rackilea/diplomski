@Override
    protected void attributeChanged(AttributeChangeEvent event,
            String attribute, Object oldValue, Object newValue) {
        if (event == AttributeChangeEvent.ADD
                || event == AttributeChangeEvent.CHANGE) {
            if (attribute.charAt(0) == 'u' && attribute.charAt(1) == 'i') {
                if (attribute.equals("ui.class")) {
                    mygraph.styleGroups.checkElementStyleGroup(this);
                    // mygraph.styleGroups.removeElement( tis );
                    // mygraph.styleGroups.addElement( this );
                    mygraph.graphChanged = true;
                } else if (attribute.equals("ui.label")) {
                    label = StyleConstants.convertLabel(newValue);
                    mygraph.graphChanged = true;
                } else if (attribute.equals("ui.style")) {
                    // Cascade the new style in the style sheet.

                    if (newValue instanceof String) {
                        try {
                            mygraph.styleSheet.parseStyleFromString(
                                    new Selector(getSelectorType(), getId(),
                                            null), (String) newValue);
                        } catch (Exception e) {
                            logger.log(Level.WARNING, String.format("Error while parsing style for %S '%s' :", getSelectorType(), getId()), e);
                        }
                        mygraph.graphChanged = true;
                    } else {
                        logger.warning("Unknown value for style [" + newValue + "].");
                    }
                } else if (attribute.equals("ui.hide")) {
                    hidden = true;
                    mygraph.graphChanged = true;
                } else if (attribute.equals("ui.clicked")) {
                    style.pushEventFor(this, "clicked");
                    mygraph.graphChanged = true;
                } else if (attribute.equals("ui.selected")) {
                    style.pushEventFor(this, "selected");
                    mygraph.graphChanged = true;
                } else if (attribute.equals("ui.color")) {
                    style.pushElementAsDynamic(this);
                    mygraph.graphChanged = true;
                } else if (attribute.equals("ui.size")) {
                    style.pushElementAsDynamic(this);
                    mygraph.graphChanged = true;
                } else if (attribute.equals("ui.icon")) {
                    mygraph.graphChanged = true;
                }
                // else if( attribute.equals( "ui.state" ) )
                // {
                // if( newValue == null )
                // state = null;
                // else if( newValue instanceof String )
                // state = (String) newValue;
                // }
            } else if (attribute.equals("label")) {
                label = StyleConstants.convertLabel(newValue);
                mygraph.graphChanged = true;
            }
        } else // REMOVE
        {
            if (attribute.charAt(0) == 'u' && attribute.charAt(1) == 'i') {
                if (attribute.equals("ui.class")) {
                    Object o = attributes.remove("ui.class"); // Not yet removed
                                                                // at
                                                                // this point !
                    mygraph.styleGroups.checkElementStyleGroup(this);
                    attributes.put("ui.class", o);
                    mygraph.graphChanged = true;
                } else if (attribute.equals("ui.label")) {
                    label = "";
                    mygraph.graphChanged = true;
                } else if (attribute.equals("ui.hide")) {
                    hidden = false;
                    mygraph.graphChanged = true;
                } else if (attribute.equals("ui.clicked")) {
                    style.popEventFor(this, "clicked");
                    mygraph.graphChanged = true;
                } else if (attribute.equals("ui.selected")) {
                    style.popEventFor(this, "selected");
                    mygraph.graphChanged = true;
                } else if (attribute.equals("ui.color")) {
                    style.popElementAsDynamic(this);
                    mygraph.graphChanged = true;
                } else if (attribute.equals("ui.size")) {
                    style.popElementAsDynamic(this);
                    mygraph.graphChanged = true;
                }
            } else if (attribute.equals("label")) {
                label = "";
                mygraph.graphChanged = true;
            }
        }
    }