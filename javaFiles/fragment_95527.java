<div th:each="lsPassengers, ***stat*** : *{lsPassengers}">
    <select class="e1 populate w-240 tPassengers" name="tPassengers">

    <option th:each="i, ***statPax***: ${session.travelPartner}" 
                            ...
                        </select>
</div>