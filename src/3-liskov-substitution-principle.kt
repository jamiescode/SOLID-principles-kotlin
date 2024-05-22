// Example of the Liskov Substitution Principle

// When main() runs, VehicleRepository.getAll() will return a list
// of vehicles. One will be a Car subtype and another will be a
// Campervan subtype. They will both be accessible under the interface
// of the Vehicle object

fun main() {
    val vehicles: List<Vehicle> = VehicleRepository().getAll()
    for (vehicle in vehicles) {
        println(vehicle.registration)
    }
}

open class Vehicle(val registration: String)

data class Car(val reg: String) : Vehicle(reg)

data class Campervan(val reg: String, val numberOfBeds: Int) : Vehicle(reg)

class VehicleRepository {
    fun getAll(): List<Vehicle> {
        val vehicles: MutableList<Vehicle> = ArrayList()
        vehicles.add(Car(reg = "AB66 GHJ"))
        vehicles.add(Campervan(reg = "CA66 MPR", numberOfBeds = 2))
        return vehicles
    }
}