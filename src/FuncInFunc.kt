//Здесь мы создадим функцию, которая принимает функцию в качеств параметра (по аналогии с qsort())
fun sortArray(arr : Array<Int>, comparator : (Int, Int) -> Boolean) : Array<Int>{
    val arrSize = arr.size
    var execArr = emptyArray<Int>()
    arr.forEach { elem ->
        execArr += elem
    }
    for(i in 0 until arrSize) {
        for(j in i until arrSize) {
            if(comparator(execArr[i], execArr[j])) {
                val tmpVar = execArr[i]
                execArr[i] = execArr[j]
                execArr[j] = tmpVar
            }
        }
    }
    return execArr
}

//Функция компаратор не совсем функция, а скорее переменная
val comparatorFromMinToMax : (a : Int, b : Int) -> Boolean = { a: Int, b: Int ->
    a >= b
}

val comparatorFromMaxToMin : (a : Int, b : Int) -> Boolean = { a: Int, b: Int ->
    a <= b
}

fun main() {
    val arr = arrayOf(4, 2, 6, 1, 8, 4)
    println("Исходный массив:")
    arr.forEach { elem ->
        print("$elem ")                                                //print: 4 2 6 1 8 4
    }
    println()

    val arrSorted1 = sortArray(arr, comparatorFromMinToMax)
    println("Отсортированный по возрастанию:")
    arrSorted1.forEach { elem ->
        print("$elem ")                                                 //print: 1 2 4 4 6 8
    }
    println()

    println("Отсортированный по убыванию:")
    val arrSorted2 = sortArray(arr, comparatorFromMaxToMin)
    arrSorted2.forEach { elem ->
        print("$elem ")                                                 //print: 8 6 4 4 2 1
    }
    println()

}