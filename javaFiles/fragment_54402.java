<s:form target="_top" cssClass="table-controls form-wrapper" name="incentives" id="frmIncentives" action="saveIncentives.action" method="post">
        <div id="actionErrors" style="color: red;">
                        <s:actionerror />
                        <s:fielderror />
        </div>
            <table id ="showIncentives" cellspacing="0" cellpadding="0" border="1" width="500" >
                <tr style="font-weight: bold">
                    <td><s:checkbox name="Select All" id="select_all"
                            theme="simple" /></td>
                    <td>
                    <td></td>
                    <td></td>
                    <td><s:text name="Marketing Incentive" /></td>
                    <td></td>
                    <td><s:text name="Advertising Incentive" /></td>
                    <td></td>
                    <td><s:text name="Channel Placement Incentive" /></td>
                    <td></td>
                    </tr>
            <s:iterator value="incentiveList" status="stat">
                    <tr>
                        <td><s:checkbox name="checkboxes[%{#stat.index}]" theme="simple" /></td>
                        <td></td>
                        <td><s:property value="pricingTierId" /> <s:hidden name="pricingTierId" value="%{incentiveList.pricingTierId}" /></td>
                        <td><s:property value="marketingAmount" /> <s:hidden name="marketingAmount" value="%{incentiveList.marketingAmount}" /></td>
                        <td></td>
                        <td><s:property value="marketingIncentive" /><s:hidden name="marketingIncentive" value="%{incentiveList.marketingIncentive}" /></td>
                        <td></td>
                        <td><s:property value="advertizingIncentive" /><s:hidden name="advertizingIncentive" value="%{incentiveList.advertizingIncentive}" /></td>
                        <td></td>
                        <td><s:property value="channelPlacementIncentive" /><s:hidden name="channelPlacementIncentive" value="%{incentiveList.channelPlacementIncentive}" /></td>
                        <td></td>
                    </tr>
            </s:iterator>
            </table>
            <c:if test="${fn:length(incentiveList) == 0}">
                <s:submit id="submitButton" name="submit" value="Submit Incentives" onclick='return closeWindow()' disabled="true"/>
            </c:if>
            <c:if test="${fn:length(incentiveList) gt 0}">
                <s:submit id="submitButton" name="submit" value="Submit Incentives" onclick='return closeWindow()' disabled="false"/>
            </c:if>
    </s:form>