<th:block th:each="prg, prgStat : *{programmazioneTransient}">
    .
    .
    .
    <th:block th:each="v, vInd : ${prg.varieTransient}">
        .
        .
        .
    </th:block>
</th:block>