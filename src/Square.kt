// TODO: дополнить определение класса размерами и позицией
class Square(var side: Float, var x: Float, var y: Float): Figure(0), Movable, Transforming  {
    // TODO: унаследовать от Figure, реализовать area()
    // TODO: реализовать интерфейс Transforming

    var color: Int = -1
    lateinit var name: String

    constructor(square: Square) : this(square.side, square.x, square.y);

    override fun area(): Float {
        return side*side;
    }

    override fun move(dx: Float, dy: Float) {
        x += dx; y += dy
    }

    override fun resize(zoom: Float) {
        // Увеличиваем, левый верхний угол оставляем на месте
        side *= zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        // Вычисляем центр квадрата
        val centerFigureX = x + side / 2
        val centerFigureY = y + side / 2

        // Поворот центра квадрата вокруг точки (centerX, centerY) на 90 градусов
        val dx = centerFigureX - centerX
        val dy = centerFigureY - centerY

        val newCenterX: Float
        val newCenterY: Float

        when (direction) {
            RotateDirection.Clockwise -> {
                // Поворот на 90° по часовой стрелке: (x, y) -> (y, -x)
                newCenterX = centerX + dy
                newCenterY = centerY - dx
            }
            RotateDirection.CounterClockwise -> {
                // Поворот на 90° против часовой стрелки: (x, y) -> (-y, x)
                newCenterX = centerX - dy
                newCenterY = centerY + dx
            }
        }

        // Обновляем позицию левого верхнего угла
        x = newCenterX - side / 2
        y = newCenterY - side / 2
    }

    override fun toString(): String {
        return "Square(side=$side, position=($x, $y), area=${area()})"
    }
}