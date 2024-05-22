// BAD: This class violates the Dependency Inversion Principle
// by creating the BookRepository dependency inside of Library

data class Book(val name: String)

class BookRepository(val apiKey: String) {
    fun getBooks(): List<Book> {
        val books = ArrayList<Book>()
        books.add(Book("Harry Potter"))
        return books
    }
}

class BadLibrary {
    fun list() = BookRepository(BOOK_API_KEY).getBooks()

    companion object {
        const val BOOK_API_KEY = "abc123"
    }
}

// BETTER: BookRepository is now provided in the constructor of Library,
// making this class much easier to test and maintain. Changes to the
// constructor of BookRepository no longer affect the Library class.

class Library(private val repository: BookRepository) {
    fun list() = repository.getBooks()
}