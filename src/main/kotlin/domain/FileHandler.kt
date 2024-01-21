package domain

import java.io.File

class FileHandler {
    private val fileName = "src/main/resources/students.txt"

    fun readFile(): MutableList<String>? {
        if (this.isFileEmpty()) {
            return null;
        }

        val result = mutableListOf<String>();
        File(this.fileName).forEachLine {
            result.addLast(it)
        }

        return result;
    }

    fun writeFile(serializedObject: String) {
        File(this.fileName).appendText(serializedObject);
        File(this.fileName).appendText("\r\n");
    }

    private fun isFileEmpty(): Boolean {
        return File(this.fileName).readLines().isEmpty();
    }
}