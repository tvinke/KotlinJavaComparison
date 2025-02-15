package example.other

fun main(args: Array<String>) {
    KotlinOtherExamples().filtering()
}

class KotlinOtherExamples {

    fun returnWithIf(x: Int): String {
        return if (x > 10) {
            "more than 10"
        } else {
            "less than 10"
        }
    }

    fun let(x: Int?) {
        val y = x?.let { "string" }
        println(y)
    }

    fun errorOnOptional(x: Int?) {
        val y1: Int? = x
        val y2: Int = x ?: throw IllegalArgumentException()
        // after this we know x is not null so it is typecast from Int? to Int
    }

    fun parameters() {
        // can skip default parameters
        ParameterExample("private", "mutable")
        ParameterExample("private", "mutable", "default")

        // skipping default means naming all other parameters afterwards
        ParameterExample("private", "mutable", name = "name")

        // can put variables in different orders of we name them correctly
        ParameterExample(default = "default", private = "private", mutable = "mutable")
    }

    fun whenExamples(enum: ExampleEnum, x: Int, o: Any) {

        // throws compilation error on missing enum
        when (enum) {
            ExampleEnum.ONE -> println("1")
            ExampleEnum.TWO -> println("2")
            ExampleEnum.THREE -> println("3")
        }

        // regular switch
        when (x) {
            0 -> println(0)
            else -> println("else")
        }

        // switch with different checks
        when {
            x >= 0 -> println("positive")
            x < 0 -> println("negative")

            o is String -> println(o)
            o is Int -> println(x.compareTo(o))

            else -> println("else")
        }

    }

    fun noTertiary(x: Int) {
//      val check = x > 0 ? "positive" : "negative"
        val check = if (x >= 0) "positive" else "negative"
    }

    fun combiningLists() {
        val a = listOf("a")
        val b = listOf("b")
        val c = a + b
        println(c)
    }

    fun addingToMap() {
        val map = mutableMapOf("a" to 1)
        println(map)
        map["b"] = 2
        println(map)
    }

    fun filtering() {
        val list = listOf("a", "b", 5, 8, true, false)

        val notStringList = list.filterNot { it is String }
        println("all elements not string in list: $notStringList")

        val evenIndices = list.filterIndexed { index, _ -> index % 2 == 0 }
        println("even indices are: $evenIndices")

        val stringList = list.filterIsInstance(String::class.java)
        println("all strings in list: $stringList")

        val map = mapOf("a" to 1, "b" to 2, "c" to 3)

        val aMap = map.filterKeys { it == "a" }
        println("a: $aMap")

        val threeMap = map.filterValues { it == 3 }
        println("3: $threeMap")

        val notA = map.filterNot { it.key == "a" }
        println("not a: $notA")
    }

}

enum class ExampleEnum {
    ONE, TWO, THREE
}

class ParameterExample(
    private val private: String,
    var mutable: String,
    var default: String = "default",
    var name: String = "name"
)