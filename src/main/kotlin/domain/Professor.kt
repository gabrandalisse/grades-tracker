package domain

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.*

class Professor(val name: String, val course: String, private val students: MutableList<Student> = mutableListOf()) {
    private val fileHandler = FileHandler();

    fun loadStoredStudents() {
        this.fileHandler.readFile()?.forEach {
            val student = Json.decodeFromString<Student>(it);
            this.students.addLast(student);
        }

        println("Students loaded: ${this.students.size}");
    }

    fun addStudent(student: Student) {
        this.students.addLast(student);

        val serializedStudent = Json.encodeToString(student)

        this.fileHandler.writeFile(serializedStudent);
    }

    fun printStudentsWithGrades() {
        this.students.forEach {
            println("Student: ${it.name} has a grade of: ${it.grade}")
        }
    }
}