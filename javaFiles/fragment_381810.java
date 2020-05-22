<div class="cal-year-box">
   <div class="row row-fluid cal-before-eventlist colgrid">
   <% t = cal._getTotalContractWeeks(); %>
   <% imax = t; %>
   <% jmax = 10; %>
   <% i = 0; %> 
   <% j = jmax ; %>
   <% while(i <= imax) { %>
         <div class="span3 col-md-1 cal-cell" data-cal-row="-week<%= j%>" style="background-color: <%= cal._weekContractEventStatusColor(i) %>" ><%= cal._weekContract(i) %>
         <% i ++; %>
         <% j ++; %>         
   </div>
         <% if (j > jmax) { %>
   </div>
   <div class="row row-fluid cal-before-eventlist colgrid">
         <% j = 1; %>
         <% } %>      
   <% } %>
   </div>
</div>