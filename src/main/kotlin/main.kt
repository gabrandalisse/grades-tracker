import domain.*

fun main() {
    val professor = createProfessor();

    professor.loadStoredStudents();

    val testStudent = Student("Peso Fluma", 5);

    professor.addStudent(testStudent);

    var option = 99;

    while (option != 0) {
        Menu.showOptions();

        option = readInput("Choose an option: ").toInt();

        when(option) {
            0 -> continue;
            1 -> createStudent(professor);
            3 -> showStudents(professor);
            else -> {
                print("Invalid option");
            }
        }

    }

}

fun createStudent(professor: Professor) {
    val name = readInput("Student name: ");
    professor.addStudent(Student(name));
}

fun showStudents(professor: Professor) {
    professor.printStudentsWithGrades();
}

fun readInput(text: String): String {
    println(text);
    return readln();
}

fun createProfessor(): Professor {
    val name = readInput("Enter your name: ");
    val course = readInput("Enter your course: ")
    return Professor(name, course);
}