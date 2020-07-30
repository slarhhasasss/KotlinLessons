//Создание статических переменных в классе:

class Bird(private val name : String) {
    //это статические переменные класса, которые не будут создаваться для каждого конкретного экзмепляра
    companion object {
        var population : Int = 0
        var arrayOfNames = mutableListOf<String>()
    }

    //Каждый раз при создании экземпляра класса будет увеличиваться популяция птиц на 1
    init {
        population++
        arrayOfNames.add(name)
        println("Вы создали птичку по имени $name! Теперь их популяция насчитывает $population особей!")
    }

    fun printName() {
        println("Эту птичку зовут $name")
    }
}


//функция, которая будет перечислять по именам всю популяцию птиц по любому представителю данной особи:
fun printPopulationOfBirds() {
    println("В популяции ${Bird.population} особей:")
    for(bird in Bird.arrayOfNames) {
        println(bird)
    }
}

fun main() {
    val golub_1 = Bird("NATASHA")
    val golub_2 = Bird("Alina")
    golub_1.printName()
    printPopulationOfBirds()
}