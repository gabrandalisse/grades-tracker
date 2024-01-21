package domain

import com.fasterxml.uuid.Generators
import kotlinx.serialization.*

@Serializable
class Student (val name: String, val grade: Int = 0) {
        val id = Generators.timeBasedGenerator().generate().toString();
}