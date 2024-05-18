package org.example

fun nas_cH(a: Double) : Double {
    println("nas_cH рассчитан ${1 * a}")
    return 1*a
}
fun nas_cK(a: Double) : Double {
    println("nas_cK рассчитан ${2 * a}")
    return 2*a
}
fun nas_rH(a: Double) : Double {
    println("nas_rH рассчитан ${4 * a}")
    return 4*a
}
fun nas_rK(a: Double) : Double {
    println("nas_rK рассчитан ${8 * a}")
    return 8*a
}

fun nas(h_func: (Double) -> Double, k_func: (Double) -> Double): (Double, Double) -> Double {
    if ((h_func == ::nas_cH && k_func == ::nas_cK) || (h_func == ::nas_rH && k_func == ::nas_rK)) {
        println("Возвращена функция для конкретного насоса исходя из переданных функций")
        return {
            h: Double, k: Double ->
            println("Вызывана функция для конкретного насоса")
            h_func(h) * k_func(k)
        }
    } else {
        throw IllegalArgumentException("Неверный ввод")
    }
}

fun main() {
    //Вывод в консоли:
    val nasCFunc = nas(::nas_cH, ::nas_cK)
    //    Возвращена функция для конкретного насоса исходя из переданных функций
    val p1 = nasCFunc(2.0, 3.0)
    //    Вызывана функция для конкретного насоса
    //    nas_cH рассчитан 2.0
    //    nas_cK рассчитан 6.0
    println("nas_p: $p1")
    //    nas_p: 12.0

    val nasRFunc = nas(::nas_rH, ::nas_rK)
    //    Возвращена функция для конкретного насоса исходя из переданных функций
    val p2 = nasRFunc(2.0, 3.0)
    //    Вызывана функция для конкретного насоса
    //    nas_rH рассчитан 8.0
    //    nas_rK рассчитан 24.0
    println("nas_p: $p2")
    //    nas_p: 192.0
}