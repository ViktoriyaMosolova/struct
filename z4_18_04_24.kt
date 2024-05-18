package org.example

// Абстрактный класс для представления насоса
abstract class Pump(val h: Double, val k: Double) {
    abstract fun calculate(): Double
}

// Класс для насоса типа C
class PumpC(h: Double, k: Double) : Pump(h, k) {
    override fun calculate(): Double {
        println("nas_cH рассчитан ${h * 1}")
        println("nas_cK рассчитан ${k * 2}")
        return h * 1 * k * 2
    }
}

// Класс для насоса типа R
class PumpR(h: Double, k: Double) : Pump(h, k) {
    override fun calculate(): Double {
        println("nas_rH рассчитан ${h * 4}")
        println("nas_rK рассчитан ${k * 8}")
        return h * 4 * k * 8
    }
}

// Фабрика для создания конкретных насосов
object PumpFactory {
    fun createPump(type: String, h: Double, k: Double): Pump {
        return when (type) {
            "C" -> PumpC(h, k)
            "R" -> PumpR(h, k)
            else -> throw IllegalArgumentException("Неподдерживаемый тип насоса")
        }
    }
}

fun main() {
    val pumpC = PumpFactory.createPump("C", 2.0, 3.0)
    println("Создан насос типа C с параметрами H = 2.0, K = 3.0")
    val resultC = pumpC.calculate()
    println("Результат для насоса типа C: $resultC")

    // Создание насоса типа R с параметрами H = 2.0, K = 3.0
    val pumpR = PumpFactory.createPump("R", 2.0, 3.0)
    println("Создан насос типа R с параметрами H = 2.0, K = 3.0")
    val resultR = pumpR.calculate()
    println("Результат для насоса типа R: $resultR")
}
