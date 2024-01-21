package domain

class Menu {
    companion object {
        fun showOptions() {
            println("1. Register new student");
            println("2. Register student grade")
            println("3. Show students")
            println("");
            println("0. Exit")
        }
    }
}