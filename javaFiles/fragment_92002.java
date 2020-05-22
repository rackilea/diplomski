<form ...>
    Tasks:
    <c:forEach var = "task" items = "${tasks}">
        <input type = "checkbox" name = "taksIds" value = "${task.id}"> ${task.title}
    </c:forEach>

    Workers:
    <c:forEach var = "worker" items = "${workers}">
        <input type = "checkbox" name = "workerIds" value = "${worker.id}"> ${worker.name}
    </c:forEach>
</form>