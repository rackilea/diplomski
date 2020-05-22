UndergradTA student = null;
GradTA stud = null;

if (option == 1) {

    student = new UndergradTA();
    student.setIsUnderGrad(true);

} else if (option == 2) {

    stud = new GradTA();
    stud.setIsGrad(true);
}