<%
Time[] times = (Time[]) session.getAttribute("times");

int rowCount = times.length;

for(int ctr = 0; ctr < rowCount; ctr++) { %>        
<tr>
    <td><%= ((Schedule)session.getAttribute("schedule")).malls[ctr] %></td>
    <td class="cinema"><%= ((Schedule)session.getAttribute("schedule")).cinemas[ctr] %></td>
    <td>PHP <%= ((Schedule)session.getAttribute("schedule"))..prices[ctr] %></td>
    <td><%= ((Schedule)session.getAttribute("schedule")).dates[ctr] %></td>
    <td><%= ((Schedule)session.getAttribute("schedule")).times[ctr] %></td>
</tr>
<% } %>