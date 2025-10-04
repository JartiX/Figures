// сочетание определения класса и конструктора одновременно объявляет переменные и задаёт их значения
class Rect(var x: Float, var y: Float, var width: Float, var height: Float) : Movable, Figure(0), Transforming {
    // TODO: реализовать интерфейс Transforming
    var color: Int = -1 // при объявлении каждое поле нужно инициализировать
    lateinit var name: String // значение на момент определения неизвестно (только для объектных типов)

    // дополнительный конструктор вызывает основной
    constructor(rect: Rect) : this(rect.x, rect.y, rect.width, rect.height)

    // нужно явно указывать, что вы переопределяете метод
    override fun move(dx: Float, dy: Float) {
        x += dx; y += dy
    }

    // для каждого класса area() определяется по-своему
    override fun area(): Float {
        return width*height // требуется явное приведение к вещественному числу
    }

    override fun resize(zoom: Float) {
        // Увеличиваем, левый верхний угол оставляем на месте
        width *= zoom
        height *= zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        // Вычисляем центр прямоугольника
        val centerFigureX = x + width / 2
        val centerFigureY = y + height / 2

        // Поворот центра прямоугольника вокруг точки (centerX, centerY) на 90 градусов
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

        // При повороте на 90° меняем местами ширину и высоту
        val temp = width
        width = height
        height = temp

        // Обновляем позицию левого верхнего угла (с учетом новых размеров)
        x = newCenterX - width / 2
        y = newCenterY - height / 2
    }

    override fun toString(): String {
        return "Rect(width=$width, height=$height, position=($x, $y), area=${area()})"
    }

}