<select id="customer-title" name="customer-title" th:field="*{selectedCustomerId}" th:required="required" class="form-control">                     
        <option value="" th:text="-Select-"></option>
        <option th:each="temp : *{customerSet}" 
            th:value="${temp.customerId}"  
            th:text="${temp.customerName}">
        </option>
</select>