// BAD: This class violates the Single Responsibility Principle
// BadUser class performs storage actions as well as user related actions
class BadUser {
    fun login() {}
    fun storeAuthToken() {
        // Logic for storing auth token
    }
    fun clearAuthToken() {
        // Logic for clearing auth token
    }
}

// BETTER: This class no longer performs storage actions, reducing the number
// of reasons for this class to change
interface AuthTokenStorage {
    fun store(token: String)
    fun clear()
}

class User(private val authStorage: AuthTokenStorage) {
    fun login() {}
    fun storeAuthToken(token: String) {
        authStorage.store(token)
    }
    fun clearAuthToken() {
        authStorage.clear()
    }
}