// Example of Open Closed Principle using Animals
fun main() {
    val dog = Dog()
    dog.move()
    dog.woof()
}

open class Animal {
    fun move() {
        println("I am moving!")
    }
}

// Dog class is able to add the woof() functionality
// but the Dog class is unable to change the existing move() functionality
class Dog: Animal() {
    fun woof() {
        println("woof!")
    }
}