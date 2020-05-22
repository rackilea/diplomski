<form name="queuePositionForm" id="queuePositionForm_${i}" action="/updatePosition" method="post">
    <select name="selPosition" id="selPosition_${i}" onChange="updatePosition(${i})">
        <option value=""></option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
   </select>
</form>