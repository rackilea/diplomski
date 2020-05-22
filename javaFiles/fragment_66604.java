<div th:each="classroom : ${classroomList}">
    <div>"${classroom.name}"</div>
    <ul>
      <div th:each="student : ${classroom.studentList}">
         <li>"${student.name}"</li>
      </div>
    </ul>
</div>