//Обычная procedure
fun printOneWord(word : String) {
    println(word)
}

//Функция с любым числом входных данных. Здесь переменная words работает как массив
fun printWords(vararg words : String) {
    if (words.isEmpty()) {
        print("No words was added!")
    }
    else {
        words.forEach { elem ->
            print("$elem ")
        }
    }
    println()
}

//Функция, которая принимает одно фиксированное значение и неизвестно сколько других:
//Функция берет переменную, и суммирует ее с другими, если нет других, то прибавляется 1, функция возвращает результат
//Значение по умолчанию для переменной res = 0, то есть даже если игнорировать этот параметр, то есть при вызове
//функции не передавать его, то по умолчанию res = 0.
fun sumAll(res : Int = 0, vararg vars : Int) : Int{
    return if (vars.isEmpty()) {
        res + 1
    }
    else {
        var ans = res
        vars.forEach { elem ->
            ans += elem
        }
        ans
    }
}

//Можно в функцию передавать массив элементов:
//Эта функция принимает массив элементов, а затем сортирует его и возвращает
// новый отсоортированный массив, не изменяя исходного
fun sort(vararg arr : Int) : Array<Int> {
    var ansArr = emptyArray<Int>()
    if (arr.isEmpty()) {
        return ansArr
    }
    else {
        arr.forEach { elem : Int ->
            ansArr += elem
        }
        val arrSize = arr.size
        var i = 0
        var j: Int
        while(i < arrSize) {
            j = i
            while(j < arrSize) {
               if(ansArr[i] > ansArr[j]) {
                   val tmpVar = ansArr[i]
                   ansArr[i] = ansArr[j]
                   ansArr[j] = tmpVar
               }
                j++
            }
            i++
        }
        return ansArr
    }
}



fun main() {
    //Проверим функцию printWords()
    println("Функции printWords() передали 3 значения:")
    printWords("one", "Two", "three")
    println("функции не передали никаких значений:")
    printWords()
    println()

    //Проверим функцию sumAll()
    println("Функции sumAll() передали значения : 1, 2, 3, 4:")
    println("ans = ${sumAll(1, 2, 3, 4)}")
    println("Функции sumAll() передали значения : 1:")
    println("ans = ${sumAll(1)}")
    println()

    //Проверим Функцию sort():
    val arr : IntArray = intArrayOf(10, 5, 3, 7, 9)
    //чтобы ввести массив в данную функцию, надо поставить *, иначе несовпадение типов данных:
    val ans = sort(*arr)
    println("Исходный массив: 10 5 3 7 9 \nВыводим отсортированный массив:")
    ans.forEach { elem ->
        print("$elem ")
    }
    println()
    println()

    //Циклы for()
    //выведется 0 1 2 3, концы включаются!!!
    val start = 0
    val end = 10
    val stepCircle = 2
    println("проверка цикла от $start до $end с шагом $stepCircle:")
    for(i in start..end step stepCircle) {
        print("$i ")
    }
    //Обратный цикл:
    /*for(i in start downTo end step stepCircle) {
        print("$i ")
    }*/
    //Так же можно пройтись циклом по алфавиту (аналогично можно от z до a с помощью downTo
    /*for(i in 'a'..'d' step 1) {
        print("$i ")
    }*/
    println()
}