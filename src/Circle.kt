// TODO: дополнить определение класса размерами и позицией
class Circle(var radius: Float, var x: Float, var y: Float) : Figure(0), Movable, Transforming {

    var color: Int = -1
    lateinit var name: String

    constructor(circle: Circle) : this(circle.radius, circle.x, circle.y);


    // TODO: реализовать интерфейс Transforming
    override fun area(): Float {
        return  3.14f*radius*radius;
    }

    override fun move(dx: Float, dy: Float) {
        x += dx; y += dy
    }

    override fun resize(zoom: Float) {
        // Увеличиваем радиус, центр остается на месте
        radius *= zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        // Поворот центра круга вокруг точки (centerX, centerY) на 90 градусов
        val dx = x - centerX
        val dy = y - centerY

        when (direction) {
            RotateDirection.Clockwise -> {
                // Поворот на 90° по часовой стрелке: (x, y) -> (y, -x)
                x = centerX + dy
                y = centerY - dx
            }
            RotateDirection.CounterClockwise -> {
                // Поворот на 90° против часовой стрелки: (x, y) -> (-y, x)
                x = centerX - dy
                y = centerY + dx
            }
        }
    }

    override fun toString(): String {
        return "Circle(radius=$radius, center=($x, $y), area=${area()})"
    }
}