fun main() {
    // Создаем фигуры
    val circle = Circle(5.0f, 10.0f, 10.0f)
    circle.name = "Круг 1"

    val square = Square(4.0f, 20.0f, 20.0f)
    square.name = "Квадрат 1"

    val rect = Rect(30.0f, 30.0f, 8.0f, 6.0f)
    rect.name = "Прямоугольник 1"

    println("До перемещения:")
    println("  $circle")
    println("  $square")
    println("  $rect")

    circle.move(5.0f, 3.0f)
    square.move(-2.0f, 4.0f)
    rect.move(10.0f, -5.0f)

    println("\nПосле перемещения (circle: +5,+3; square: -2,+4; rect: +10,-5):")
    println("  $circle")
    println("  $square")
    println("  $rect")

    println("\nДо масштабирования:")
    println("  $circle")
    println("  $square")
    println("  $rect")

    circle.resize(2.0f)
    square.resize(1.5f)
    rect.resize(0.5f)

    println("\nПосле масштабирования (circle: x2; square: x1.5; rect: x0.5):")
    println("  $circle")
    println("  $square")
    println("  $rect")

    val centerX = 25
    val centerY = 25
    println("\nЦентр поворота: ($centerX, $centerY)")

    println("\nДо поворота:")
    println("  $circle")
    println("  $square")
    println("  $rect")

    circle.rotate(RotateDirection.Clockwise, centerX, centerY)
    square.rotate(RotateDirection.CounterClockwise, centerX, centerY)
    rect.rotate(RotateDirection.Clockwise, centerX, centerY)

    println("\nПосле поворота (circle: по часовой; square: против часовой; rect: по часовой):")
    println("  $circle")
    println("  $square")
    println("  $rect")

    val testCircle = Circle(3.0f, 0.0f, 0.0f)
    testCircle.name = "Тестовый круг"

    println("\nИсходная фигура: $testCircle")
    testCircle.move(10.0f, 10.0f)
    println("После перемещения (10, 10): $testCircle")
    testCircle.resize(2.0f)
    println("После увеличения в 2 раза: $testCircle")
    testCircle.rotate(RotateDirection.Clockwise, 10, 10)
    println("После поворота вокруг своего центра: $testCircle")

    println("\nПроверка на полиморфизм")
    val movableFigures: List<Movable> = listOf(
        Circle(1.0f, 0.0f, 0.0f),
        Square(2.0f, 0.0f, 0.0f),
        Rect(0.0f, 0.0f, 3.0f, 4.0f)
    )

    println("До перемещения:")
    movableFigures.forEach { figure -> println("  $figure") }

    println("Перемещение всех фигур на (5, 5):")
    movableFigures.forEach { figure ->
        figure.move(5.0f, 5.0f)
        println("  $figure")
    }

}