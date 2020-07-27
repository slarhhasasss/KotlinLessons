/* В данном файле рассматриваются различные способы создания массивов на языке Kotlin

 */


//Массив можно создать с помощью функции arrayOf, при этом тип данных указывать не обязательно.
//Но если указать тип данных Any в Array<Any>, тогда в этом массиве можно будет использовать знчения разных типов данных
var array_usual : Array<Any> = arrayOf(1, 2.0f, "Values")

//Аналогично можно создать список различных или одних данных.
//У списков больше функций, чем у массивов!
var array_list : List<Any> = listOf(1, 2, "three")

//Так можно создать массив из null размером size:
//(При этом размер массива не будет зависеть от пустых или непустых ячеек - все равно 100)
var array_null = arrayOfNulls<Any>(100)

//Можно просто создать пустой массив и потом в него доавлять элементы
var array_empty = emptyArray<Any?>()

//Создания ассоциативного массива (ключ - значение)
//Аналогично, если нужно создать динамический ассоциативный массив: mutableMapOf<>()
var array_map : Map<Any, Any> = mapOf(
    "name" to "Dima",
    "Age" to 19
)

//Динамические массивы:
//(Можно добавлять и удалять значения
var array_dynamic = mutableListOf<Any>("first val", "second val", "third val")

fun main() {
    //В array_usual и array_list можно перебрать элементы несколькими способами:
    println("Перебор элементов в массиве array_usual:")
    for (el in array_usual) {
        println("Элемент $el принадлежит классу ${el.javaClass.toString()}")
    }
    println()

    //Или же с помощью спец функции:
    println("Перебор массива array_list:")
    array_list.forEach {elem ->
        println("Элемент $elem")
    }
    println()


    //Обращение к ассоциативному массиву (Выводит значение ключа "name"):
    println("Значение ключа \"name\" в массиве array_map = ${array_map["name"]}\n")

    //Перечисление ассоциативного массива:
    println("Посмотрим содержимое массива array_map:")
    array_map.forEach { (key, value) ->
        println("key : $key -> value : $value")
    }
    println()

    //Добавим к массиву array_dynamic новое значение и удалим первое, и выведем содержимое:
    array_dynamic.add("fourth val")
    array_dynamic.removeAt(0)
    println("Перечислим итоговые элементы массива array_dynamic:")
    array_dynamic.forEachIndexed {index, elem ->
        println("На $index-м месте стоит элемент $elem")
    }
    println("Массив array_dynamic имеет размер ${array_dynamic.size}")
    println()

    //Добавим в array_empty новые элементы и посмотрим как изменится его размер:
    array_empty += 1
    array_empty += "second"
    array_empty += true
    println("В массиве array_empty следующие элементы:")
    array_empty.forEachIndexed{index, elem ->
        println("На $index-м месте стоит элемент $elem")
    }
}


