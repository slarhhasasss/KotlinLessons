import kotlin.Int as Int

//Создание изолированного класса
sealed class Education {
    //внутри изолированного класса можно создавать подклассы
    data class School(val _number : Int, val _name : String? = null) : Education() {
        init {
            nameOfBuilding = _name
        }
    }
    data class MusicSchool(val _number: Int, val _name: String? = null) : Education() {
        init {
            nameOfBuilding = _name
        }
    }
    data class University(val _name: String, var eduPrice : Int? = null) : Education() {
        init {
            nameOfBuilding = _name
        }
    }

    //Так же можно создавать уже готовые объекты, в которых можно переопределять функции и переменные
    object MGU : Education() {
        const val name = "MGU"
        private const val eduPrice = 400000

        fun costOfEducation() = eduPrice

        override fun printName() {
            println("MGU")
        }
    }

    //еще можно создавать функции класса Education и его переменные:
    var nameOfBuilding : String? = null

    open fun printName() {
        if (nameOfBuilding != null) {
            println(nameOfBuilding)
        }
        else {
            println("There are no name!")
        }
    }
}


//А еще можно писать функции и переменные подкласса вне подкласса:
//Так же можно для любых классов делать
fun Education.University.printCostOfEdu() {
    if(eduPrice != null) {
        println("Education in $nameOfBuilding costs $eduPrice!")
    }
    else {
        println("The price of Education in $nameOfBuilding is unknown!")
    }
}
//Аналогично с переменными:
//Только значения этой переменной присваиваются только через getter и setter, Но так лучше не делать...
val Education.School.score : Int
    get() = 1


fun main() {
    val mgu = Education.MGU
    mgu.printName()                  //print: MGU
    Education.MGU.printName()        //print: MGU
    println(mgu.costOfEducation())   //print: 400000

    val school1568 = Education.School(1568, "Pablo Nerudo")
    school1568.printName()            //print: Pablo Nerudo

    val hse = Education.University("Higher school of memes")
    hse.printName()                   //Higher school of memes
    hse.printCostOfEdu()              //print: The price of Education in Higher school of memes is unknown!

    val musicSchoolATGrechaninova = Education.MusicSchool(1, "Grechaninova")
    musicSchoolATGrechaninova.printName()                    //print: Grechaninova

    val school1430 = Education.School(1430)
    school1430.printName()                                   //print: There are no name!
    println("Score of school number ${school1430._number} is ${school1430.score}") //print: Score of school number 1430 is 1


}