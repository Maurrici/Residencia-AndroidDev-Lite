data class Book(
    var name: String,
    var gender: String,
    var author: String,
    var totalPage: Float,
    var currentPage: Float
) {
    fun calcProgress(): String {
        val progress = (this.currentPage/this.totalPage) * 100

        return String.format("%.2f", progress)
    }
}

val library = ArrayList<Book>()

fun main() {
    try {
        var option = 0
        do {
            println("------- Bem vindo a Livraria -------")
            println("(1) - Cadastrar Livro")
            println("(2) - Buscar Livro")
            println("(3) - Ver todos os livros")
            println("(4) - Atualizar leitura")
            println("(0) - Encerrar programa")
            println("------------------------------------")
            print("Selecione uma opção: ")
            option = readLine()?.toInt() ?: 0

            when(option) {
                1 -> insertBook()
                2 -> searchBook()
                3 -> showLibrary()
                4 -> updateBook()
            }
        } while (option != 0)
    } catch (ex: Exception) {
        println("Valor inválido encontrado!")
    }
}

fun showLibrary() {
    println()
    println("-------      Seus Livros     -------")
    if (library.isEmpty()) println("Nenhum Livro cadastrado...")
    else {
        for (book in library) {
            showBook(book)
        }
    }
    print("Pressione Enter para voltar ao menu")
    readLine()
}

fun searchBook() {
    println()
    print("Pesquisa: ")
    val search = readLine() ?: ""

    val filterBooks = library.filter {
        it.name.contains(search) || it.author.contains(search) || it.gender.contains(search)
    }

    println("-------      Seus Livros     -------")
    if (filterBooks.isEmpty()) println("Nenhum Livro encontrado...")
    else {
        for (book in filterBooks) {
            showBook(book)
        }
    }
    print("Pressione Enter para voltar ao menu")
    readLine()
}

fun insertBook() {
    println()
    println("-------      Cadastro     -------")
    print("Nome: ")
    val name = readLine() ?: ""
    print("Autor: ")
    val author = readLine() ?: ""
    print("Gênero: ")
    val gender = readLine() ?: ""
    print("Total de páginas: ")
    val totalPage = readLine()?.toFloat() ?: 0F
    print("Página atual: ")
    val currentPage = readLine()?.toFloat() ?: 0F

    library.add(Book(
        name,
        gender,
        author,
        totalPage,
        currentPage
    ))

    print("Livro cadastrado com sucesso! Pressione Enter para voltar ao menu.")
    readLine()
}

fun updateBook() {
    println()
    println("-------      Atualizar     -------")

    if (library.isEmpty()) println("Nenhum Livro cadastrado...")
    else {
        println("ID  | Nome")
        for (index in library.indices) {
            val book = library[index]
            println("(${index}) | ${book.name}")
        }
        print("Digite o ID do livro:")
        val bookIndex = readLine()?.toInt() ?: -1
        println()
        if(library.indices.any { it == bookIndex }) {
            print("Digite a página atual:")
            val currentPage = readLine()?.toFloat() ?: 0F
            library[bookIndex].currentPage = currentPage
        } else {
            println("ID inválido!")
        }
    }

    print("Livro atualizado com sucesso! Pressione Enter para voltar ao menu.")
    readLine()
}

fun showBook(book: Book) {
    print("${book.name}\nAutor: ${book.author}\nGênero:${book.gender}\nProgresso:${book.calcProgress()}%\n")
    println("------------------------------------")
}