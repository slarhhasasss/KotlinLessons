//Посмотрим как создать простой класс с конструктором
//класс можно создать и без коснтруктора, тогда круглые скобочки не нужны, только название класса
//вообще можно обойтись без слова constructor, но с ним понятнее
//init {} - Функция инициализатор
//сам класс моет быть public - по умолчанию, доступен по всему проекту, internal - доступен только внутри одного модуля (src),
// или же private - класс нигде не виден, кроме самого файла, protected - переменная видна внутри самого класса и класса-наследника
class User constructor(_firstName : String, _secondName : String, _age : String) {
    var firstName : String = _firstName
    var secondName : String = _secondName
    var age : String = _age
    //Приватная переменная, доступная только внутри класса:
    private var secretKey : String? = null

    //Можно переопределить setter and getter:
    var login : String? = null
        set(value) {
            if (value == "sex") {
                println("Message: Error! Not allowed login!")
            }
            else {
                field = value
                println("Message: The value was added successfully in login")
            }
        }
        get() {
            println("Message: The value have been gotten from login")
            return field
        }
    //А можно не трогать их:
    var password : String? = null


    init {
        secretKey = firstName + secondName + age
    }

    //Можно сделать несколько конструкторов для разных вариантов инициализации
    //В данном  случае при вызове пустого конструктора, будет вызван обычный конструктор с дефолтными данными
    constructor() : this("Default First Name", "Default Second Name", "Default Age") {
        //TODO: SOME CODE
    }

    //Можно совсем другие типы данных вводить,  и потом с ними работать
    constructor(_firstName : String, _secondName : String, _age: Int) : this() {
        firstName = _firstName
        secondName = _secondName
        age = _age.toString()
    }



    internal fun printUserInfo() {
        println("Name : $firstName\nSecond name : $secondName \nAge : $age")
    }

    internal fun printConfidantUserInfo(_password : String?) {
        if(_password == password) {
            println("Login: $login")
            println("Password: $password")
        }
        else {
            println("Password $_password is wrong!")
        }
    }
}



fun main() {
    println("Empty constructor:")
    val defaultUser = User()
    defaultUser.printUserInfo()
    println()

    println("Full constructor:")
    val dima = User("Dima", "Kolesnikov", 19)
    dima.printUserInfo()
    println()

    //Testing setter and getter
    println("Testing Setter and Getter login:")
    dima.login = "nagibator2000"
    dima.password = "12345"
    dima.printConfidantUserInfo("1234")
    //Здесь сначала вызывается геттер от логина, чтобы присвоить и вывести на экран сам логин (см функцию)
    dima.printConfidantUserInfo("12345")

}