<?xml version='1.0' encoding='UTF-8'?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:af="http://xmlns.oracle.com/adf/faces/rich">
  <jsp:directive.page contentType="text/html;charset=UTF-8"/>
  <f:view>
    <af:document title="Page1" id="d1" clientComponent="true">
      <af:resource type="javascript" source="/resources/js/jquery-1.3.2.js"/>
      <af:form id="f1">
        <af:panelStretchLayout id="psl1">
          <f:facet name="center">
            <af:panelGroupLayout id="pgl1">
              <af:panelGroupLayout id="main" styleClass="AFStretchWidth" layout="vertical" clientComponent="true">
                <af:clientListener method="onMainClick" type="click"/>
                <af:serverListener type="clickOnMain" method="#{college.onLoad}"/>
              </af:panelGroupLayout>
            </af:panelGroupLayout>
          </f:facet>
        </af:panelStretchLayout>
      </af:form>
      <af:resource type="javascript">
        onBodyLoad = function (event) {
            fireEvent(document.getElementById(AdfPage.PAGE.findComponentByAbsoluteId('main').getClientId()), 'click');
        }
        fireEvent = function (element, eventType) {
            if (element.fireEvent) {
                element.fireEvent('on' + eventType);
            }
            else {
                var eventObj = document.createEvent('Events');
                eventObj.initEvent(eventType, true, false);
                element.dispatchEvent(eventObj);
            }
        }
        onMainClick = function (event) {
            AdfCustomEvent.queue(event.getSource(), "clickOnMain", 
            {
            },true);
        }
      </af:resource>
      <af:clientListener method="onBodyLoad" type="load"/>
    </af:document>
  </f:view>
</jsp:root>