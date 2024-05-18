package org.example

//как программист кипятит воду в чайнике?
//1. Набирает воду в чайник
//2. Ставит чайник на огонь
//3. Ждет пока тот не вскипит
//
//как программист кипятит воду в чайнике если в нем уже есть вода?
//1. Выливает воду из чайника что сводит задачу к уже решенной
//(старый анекдот)

// не смешной анекдот честно говоря.
// и непонятно в чем состоит задача. зачем выливать воду из чайника если есть функция набора воды.
// никто же не говорит что она набирает только от 0 до максимума...
// если речь про то что есть очень большой и сложный код для набора воды от 0 до максимума,
// который уже написан и его нельзя(да и не надо) менять то тут уже логичнее выливать воду... или написать функцию долива воды...

class Kettle(
    var waterLevel: Int = 0,
    private var isOnFire: Boolean = false,
    private var isWaterBoiling: Boolean = false,
    private val maxWaterLevel: Int = 1000, // Максимальный уровень воды в чайнике
) {

    fun fillKettle() {
        if (waterLevel == 0) {
            waterLevel = maxWaterLevel // Типа наливает воду от 0 до максимума
            println("Kettle filled with water. Current water level: $waterLevel ml")
        } else {
            addWater() // Доливаем воду
        }
    }

    // Метод для добавления воды в чайник
    private fun addWater() {
        val amount = maxWaterLevel - waterLevel // Рассчитываем, сколько воды можно добавить
        waterLevel += amount // Увеличиваем уровень воды на доступное количество
        println("$amount ml of water added to the kettle. Current water level: $waterLevel ml")
    }

    // Метод для включения огня под чайником
    fun turnOnFire() {
        if (waterLevel == 0) {
            throw IllegalArgumentException("Cannot turn on fire. Add water first.")
        }
        isOnFire = true
        println("Kettle is placed on fire")
    }

    // Метод для ожидания закипания воды
    fun waitForBoiling() {
        if (isOnFire && waterLevel > 0) {
            println("Waiting for the water to boil...")
            isWaterBoiling = true
            println("Water is boiling!")
        } else {
            println("Cannot boil water. Check if the kettle is on fire and has water.")
        }
    }
}

// Функция для процесса кипячения воды в чайнике
fun boilingWaterInKettle(kettle: Kettle) {
    kettle.fillKettle() // Добавляем воду в чайник
    kettle.turnOnFire() // Включаем огонь
    kettle.waitForBoiling() // Ожидаем закипания
}

fun main() {
    val kettle1 = Kettle(0) // Создаем чайник с нулевым уровнем воды
    val kettle2 = Kettle(500) // Создаем чайник с уровнем воды 500 мл
    val kettle3 = Kettle(1000) // Создаем чайник с максимальным уровнем воды (заполненный)

    // Демонстрация процесса кипячения воды для каждого чайника
    println("Water level: ${kettle1.waterLevel} ml-------------------")
    boilingWaterInKettle(kettle1) // Пытаемся вскипятить воду в пустом чайнике
//    Water level: 0 ml-------------------
//    Kettle filled with water. Current water level: 1000 ml
//    Kettle is placed on fire
//    Waiting for the water to boil...
//    Water is boiling!

    println("Water level: ${kettle2.waterLevel} ml-------------------")
    boilingWaterInKettle(kettle2) // Кипятим воду в чайнике с 500 мл воды
//    Water level: 500 ml-------------------
//    500 ml of water added to the kettle. Current water level: 1000 ml
//    Kettle is placed on fire
//    Waiting for the water to boil...
//    Water is boiling!

    println("Water level: ${kettle3.waterLevel} ml-------------------")
    boilingWaterInKettle(kettle3) // Кипятим воду в полностью заполненном чайнике
//    Water level: 1000 ml-------------------
//    0 ml of water added to the kettle. Current water level: 1000 ml
//    Kettle is placed on fire
//    Waiting for the water to boil...
//    Water is boiling!
}

