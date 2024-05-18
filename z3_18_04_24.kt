package org.example

//3. перегрузка конструктора + настройка доступа

// Определение класса с примером приватных, публичных и защищенных полей и функций
open class User {
    // Публичное свойство (по умолчанию)
    var name: String = ""

    // Приватное свойство
    private var age: Int = 0

    // Защищенное свойство
    protected var email: String = ""

    // конструктор с двумя параметрами
    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    // конструктор с одним параметром (возраст по умолчанию = 0)
    constructor(name: String) {
        this.name = name
    }

    // Публичная функция для вывода информации о пользователе
    fun displayInfo() {
        println("Name: $name")
        println("Age: $age") // Можно обратиться к приватному свойству внутри класса
        println("Email: $email") // Можно обратиться к защищенному свойству внутри класса
    }

    // Приватная функция, доступная только внутри класса
    private fun increaseAge() {
        age++
    }

    // Защищенная функция, доступная в этом классе и его подклассах
    protected fun updateEmail(newEmail: String) {
        email = newEmail
    }
}

fun main() {
    val user1 = User("Alice", 30)
    user1.name = "Kate" //Name: Kate
//     user1.age = 25 // Cannot access 'age': it is private in 'User'
//     user1.email = "alice@example.com" // Cannot access 'email': it is protected in 'User'

    user1.displayInfo() // Можно вызывать публичные методы класса
//    Name: Kate
//    Age: 30
//    Email:

//     user1.increaseAge() // Cannot access 'increaseAge': it is private in 'User'
//     user1.updateEmail("newemail@example.com") // Cannot access 'updateEmail': it is protected in 'User'

    val user2 = User("Bob")
    user2.displayInfo() // Можно вызывать публичные методы класса
//    Name: Bob
//    Age: 0
//    Email:
}
