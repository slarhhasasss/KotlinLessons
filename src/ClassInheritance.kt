interface SMS {
    fun sendSms(message : String, sendToNumber: Int)
}


//Parent class:
//ключевое слово open перед названием классом позволяет наследовать этот класс
open class Phone(private val model : String, _number : Int = 0) : SMS{
    //Чтобы класс-наследник мог переопределять перменные, они должны быть open
    open var number : Int = _number
        set(value) {
            println("You have changed your phone number from $field on $value")
            field = value
        }
    //Аналогично с функциями
    open fun printModel() {
        println("Model of your phone is $model")
    }
    //Но если функция или переменная принадлежит интерфейсу, то для ее переопределения в классе-наследнике
    //не надо прописывать слово open перед этой функцией
    override fun sendSms(message : String, sendToNumber : Int) {
        println("You sent \"$message\" to $sendToNumber")
    }
}

//Класс, который будет наслежовать класс Phone()
//Класс SmartPhone() имеет те же самые функции, переменные и конструкторы, что и класс-родитель Phone(),
//то есть, к экземпляру класса SmartPhone() можно применять такие же функции и методы, что и к экземпляру класса Phone()
class SmartPhone(_model : String, _number : Int) : Phone(_model, _number) {
    //Переопределим переменную number, изменим его setter, чтобы можно было задавать только 5-ти значные числа как номер
    override var number : Int = -1
        set(value) {
            if(value in 10000..99999) {
                field = if(field == -1) {
                    println("Now your phone number is $value")
                    value
                } else {
                    println("Your smartPhone number was changes from $field to $value")
                    value
                }
            }
            else {
                println("Error! Your number is incorrect!")
            }
        }

    init {
        number = _number
    }

    override fun sendSms(message: String, sendToNumber: Int) {
        if(number == -1) {
            println("Error! Firstly you should take number of your phone!")
        }
        else {
            super.sendSms(message, sendToNumber)
        }
    }

    fun printNumber() {
        if (number == -1) {
            println("Error! You haven't got number!")
        }
        else {
            println("Your number is $number")
        }
    }

}



fun main() {
    val curPhone = SmartPhone("Nokia", 1234)            //print: Error! Your number is incorrect!
    curPhone.printModel()                                              //print: Model of your phone is Nokia
    curPhone.sendSms("Hello!", 1235)              //print: Error! Firstly you should take number of your phone!
    curPhone.number = 12353                                            //print: Now your phone number is 12353
    curPhone.printNumber()                                             //print: Your number is 12353
    curPhone.number = 12345                                            //print: Your smartPhone number was changes from 12353 to 12345
    curPhone.sendSms("Hello!", 12346)            //print: You sent "Hello!" to 12346
    println()

    //Можно создавать экземпляр класса-наследника прямо в коде!
    val iPhone = object : Phone("Apple", 77777) {
        //здесь можно переопределять функции и переменные родительского класса или создать свои функции
        override fun printModel() {
            println("You Have Iphone!")
        }

        fun sayAndroidIsBad() {
            println("Android is Bad!")
        }
    }
    iPhone.printModel()                       //print: You Have Iphone!
    iPhone.sayAndroidIsBad()                 //Android is Bad!
}