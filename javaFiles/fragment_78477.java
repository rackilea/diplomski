<html>
<main>
    <h2 th:text="${videoName}"></h2>
    <iframe th:src="${dropboxUrl}"></iframe>
    <p th:text="${videoDescription}"></p>
    ...
</main>
</html>