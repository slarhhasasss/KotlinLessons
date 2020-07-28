import java.awt.color.ICC_ColorSpace
import kotlin.math.cos

class Fridge(_maxWeight: Int) {
    var model : String? = null
    var maxWeight : Int = _maxWeight
    var price : Int? = null
    private var curWeight : Int = 0
    private var productsInFridge = mutableMapOf<String, Int>()

    constructor(_model : String?, _maxWeight : Int, _price : Int?) : this(_maxWeight) {
        model = _model
        maxWeight = _maxWeight
        price = _price
    }

    fun addProduct(productName : String, productWeight : Int) {
        if ((curWeight + productWeight) <= maxWeight) {
            productsInFridge[productName] = productWeight
            curWeight += productWeight
        }
        else {
            println("-Error! It is too many products in the fridge!")
        }
    }

    fun removeProduct(productName: String) {
        if(productName in productsInFridge) {
            curWeight -= productsInFridge[productName]!!
            productsInFridge.remove(productName)
        }
        else {
            println("-Error! No such product!")
        }
    }

    fun printFridgeInfo() {
        println("-The weight of fridge : $curWeight")
        println("Products in fridge:")
        productsInFridge.forEach { (product, weight) ->
            println("Product $product - weight : $weight")
        }
    }
}



interface FridgeFunctions {
    //переменные в интерфейсе
    val fridge : Fridge

    fun printModel()

    //так как эта функция реализована в интерфейсе, она не обязательно должна быть реализована в самом классе-наследнике
    fun printDeluxeFridgeInfo() {
        fridge.printFridgeInfo()
    }
}

interface FridgeShops {
    val placeToBuy : String

    fun whereBuy() : String
}

//если создать класс, наследующий интерфейс, то в этом классе должны быть переопределены все функции интерфейса
//но если сделать класс abstract, то все функции интерфейса реализовывать не надо.
//Можно наследовать сразу 2 интерфейса и более
class DeluxeFridge(_fridge: Fridge, _cost : Int, _whereBuy : String = "MVideo") : FridgeFunctions, FridgeShops {
    override var fridge : Fridge = _fridge

    val cost: Int = _cost

    override fun printModel() {
        println("-The model of fridge: ${fridge.model}")
    }

    //мы можем обращаться к функции printDeluxeFridgeInfo(fridge: Fridge) и дополнить ее функционал
    //для этого сначала выполнится функция из интерфейса (super.printDeluxeFridgeInfo(fridge)),
    // а потом мы можем добавить код
    override fun printDeluxeFridgeInfo() {
        super.printDeluxeFridgeInfo()
        //TODO:Some code
        println("You Have Deluxe Fridge, that costs $cost!")
    }

    fun addProduct(productName: String, productWeight: Int) {
        fridge.addProduct(productName, productWeight)
    }

    fun removeProduct(productName: String) {
        fridge.removeProduct(productName)
    }

    override val placeToBuy: String = _whereBuy

    override fun whereBuy(): String {
        return placeToBuy
    }
}


//Функция для проверку переменных на принадлежность к тому или иному интерфейсу:
fun checkDataTypes(obj : Any) {
    if(obj is FridgeFunctions) {
        println("-$obj принадлежит интерфейсу FridgeFunctions")
        obj.printDeluxeFridgeInfo()
    }
    if(obj is FridgeShops) {
        println("-$obj принадлежит интерфейсу FridgeShops, значит вы можете купить его в ${obj.whereBuy()}")
    }
}



fun main() {
    val fridge1 = Fridge(100)
    fridge1.addProduct("meat", 13)
    fridge1.addProduct("milk", 20)
    fridge1.addProduct("cheese", 10)
    fridge1.printFridgeInfo()
    println()
    fridge1.removeProduct("milk")
    fridge1.printFridgeInfo()
    println()

    val deluxeFridge = DeluxeFridge(Fridge(100), 200000, "Now How")
    deluxeFridge.addProduct("Cheese", 25)
    deluxeFridge.printDeluxeFridgeInfo()
    deluxeFridge.printModel()
    println("-You can buy this fridge in ${deluxeFridge.whereBuy()}")
    println()

    checkDataTypes(deluxeFridge)

}