# Геометрические фигуры в Kotlin

## Структура проекта

### Интерфейсы

- **`Movable`** - интерфейс для перемещаемых объектов
    - `move(dx: Float, dy: Float)` - перемещение на вектор (dx, dy)

- **`Transforming`** - интерфейс для трансформируемых объектов
    - `resize(zoom: Float)` - масштабирование с сохранением пропорций
    - `rotate(direction: RotateDirection, centerX: Int, centerY: Int)` - поворот на 90° вокруг точки

### Классы

- **`Figure`** - абстрактный базовый класс для всех фигур
    - `area(): Float` - абстрактный метод расчета площади

- **`Circle`** - класс круга
    - Свойства: `radius`, `x`, `y` (координаты центра)
    - Реализует: `Figure`, `Movable`, `Transforming`

- **`Square`** - класс квадрата
    - Свойства: `side`, `x`, `y` (координаты левого верхнего угла)
    - Реализует: `Figure`, `Movable`, `Transforming`

- **`Rect`** - класс прямоугольника
    - Свойства: `width`, `height`, `x`, `y` (координаты левого верхнего угла)
    - Реализует: `Figure`, `Movable`, `Transforming`

## Особенности реализации

### Метод `resize(zoom: Float)`
Увеличивает размеры фигуры в `zoom` раз, сохраняя пропорции и не изменяя позицию:
- **Circle**: увеличивается радиус, центр остается на месте
- **Square**: увеличивается сторона, левый верхний угол остается на месте
- **Rect**: увеличиваются ширина и высота, левый верхний угол остается на месте

### Метод `rotate(direction, centerX, centerY)`
Поворачивает центр фигуры на 90° вокруг заданной точки:
- **Clockwise** - по часовой стрелке: `(x, y) → (y, -x)`
- **CounterClockwise** - против часовой стрелки: `(x, y) → (-y, x)`
- Для **Circle**: поворачивается центр круга
- Для **Square**: поворачивается центр квадрата, затем пересчитывается позиция левого верхнего угла
- Для **Rect**: поворачивается центр прямоугольника, меняются местами ширина и высота, пересчитывается позиция левого верхнего угла


## Вывод программы:

```
До перемещения:
  Circle(radius=5.0, center=(10.0, 10.0), area=78.5)
  Square(side=4.0, position=(20.0, 20.0), area=16.0)
  Rect(width=8.0, height=6.0, position=(30.0, 30.0), area=48.0)

После перемещения (circle: +5,+3; square: -2,+4; rect: +10,-5):
  Circle(radius=5.0, center=(15.0, 13.0), area=78.5)
  Square(side=4.0, position=(18.0, 24.0), area=16.0)
  Rect(width=8.0, height=6.0, position=(40.0, 25.0), area=48.0)

До масштабирования:
  Circle(radius=5.0, center=(15.0, 13.0), area=78.5)
  Square(side=4.0, position=(18.0, 24.0), area=16.0)
  Rect(width=8.0, height=6.0, position=(40.0, 25.0), area=48.0)

После масштабирования (circle: x2; square: x1.5; rect: x0.5):
  Circle(radius=10.0, center=(15.0, 13.0), area=314.0)
  Square(side=6.0, position=(18.0, 24.0), area=36.0)
  Rect(width=4.0, height=3.0, position=(40.0, 25.0), area=12.0)

Центр поворота: (25, 25)

До поворота:
  Circle(radius=10.0, center=(15.0, 13.0), area=314.0)
  Square(side=6.0, position=(18.0, 24.0), area=36.0)
  Rect(width=4.0, height=3.0, position=(40.0, 25.0), area=12.0)

После поворота (circle: по часовой; square: против часовой; rect: по часовой):
  Circle(radius=10.0, center=(13.0, 35.0), area=314.0)
  Square(side=6.0, position=(20.0, 18.0), area=36.0)
  Rect(width=3.0, height=4.0, position=(25.0, 6.0), area=12.0)

Исходная фигура: Circle(radius=3.0, center=(0.0, 0.0), area=28.26)
После перемещения (10, 10): Circle(radius=3.0, center=(10.0, 10.0), area=28.26)
После увеличения в 2 раза: Circle(radius=6.0, center=(10.0, 10.0), area=113.04)
После поворота вокруг своего центра: Circle(radius=6.0, center=(10.0, 10.0), area=113.04)

Проверка на полиморфизм
До перемещения:
  Circle(radius=1.0, center=(0.0, 0.0), area=3.14)
  Square(side=2.0, position=(0.0, 0.0), area=4.0)
  Rect(width=3.0, height=4.0, position=(0.0, 0.0), area=12.0)
Перемещение всех фигур на (5, 5):
  Circle(radius=1.0, center=(5.0, 5.0), area=3.14)
  Square(side=2.0, position=(5.0, 5.0), area=4.0)
  Rect(width=3.0, height=4.0, position=(5.0, 5.0), area=12.0)
```