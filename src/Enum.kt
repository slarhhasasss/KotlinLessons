//Создадим класс-перечисление
//Конструктор в данном случае лишь показывает, какими переменными обладают элементы класса перечисления
enum class Animals(val nameOfAnimal : String) {
    DOG("Petr"),
    CAT("Galina"),
    BEAR("Alina"),
    LION("Dima");

    //name - то, что выюрал пользователь экземпляром перечисления (какое животное он выбрал)
    fun printUserChoice() {
        println("User selected $name")
    }

    fun printNameUsersChoice() {
        println("User selected $name with name $nameOfAnimal")
    }
}


fun main() {
    val simpleAnimal = Animals.BEAR
    simpleAnimal.printUserChoice()                //print: User selected BEAR

    val simpleAnimal2 = Animals.DOG
    simpleAnimal2.printNameUsersChoice()          //print: User selected DOG with name Petr

    println("The ${Animals.CAT} has name ${Animals.CAT.nameOfAnimal}") //print: The CAT has name Galina

}