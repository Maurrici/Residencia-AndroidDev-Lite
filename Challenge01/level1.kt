fun main() {
    try {
        print("Qual livro você está lendo? ")
        val bookName = readLine() ?: ""
        print("Quantas páginas tem o livro? ")
        val totalPage = readLine()?.toFloat() ?: 0F
        print("Em qual página você está? ")
        val currentPage = readLine()?.toFloat() ?: 0F

        val progress = (currentPage/totalPage) * 100

        println("${bookName} : ${String.format("%.2f", progress)}%")
    } catch (exception: Exception) {
        println("Valores inválidos foram encontrados")
    }
}