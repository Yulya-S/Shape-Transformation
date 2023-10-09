// сочетание определения класса и конструктора одновременно объявляет переменные и задаёт их значения
class Rect(var x: Int, var y: Int, var width: Int, var height: Int) : Movable, Transforming, Figure(0) {
    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        var h_plus = if (y > centerY){
            y -= height
            true
        } else false
        var w_plus = if (x < centerX){
            x += width
            true
        } else false

        val rzX = x - centerX
        val rzY = y - centerY

        x = centerX
        y = centerY

        if (direction == RotateDirection.Clockwise) {
            if (h_plus && !w_plus) h_plus = false
            else if (h_plus == w_plus) w_plus = !w_plus
            else if (w_plus && !h_plus) h_plus = true
            x += rzY
            y -= rzX
        } else if (direction == RotateDirection.CounterClockwise){
            if (h_plus && !w_plus) w_plus = true
            else if (h_plus == w_plus) h_plus = !h_plus
            else if (w_plus && !h_plus) w_plus = false
            x -= rzY
            y += rzX
        }

        val rem = width
        width = height
        height = rem

        if (w_plus) x -= width
        if (h_plus) y += height
    }

    override fun resize(zoom: Int) {
        if (width + zoom > 0 && height + zoom > 0){
            width += zoom
            height += zoom
        }
    }

    var color: Int = -1

    lateinit var name: String // значение на момент определения неизвестно (только для объектных типов)
    // дополнительный конструктор вызывает основной
    constructor(rect: Rect) : this(rect.x, rect.y, rect.width, rect.height)

    // нужно явно указывать, что вы переопределяете метод
    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    // для каждого класса area() определяется по-своему
    override fun area(): Float {
        return (width*height).toFloat() // требуется явное приведение к вещественному числу
    }

    override fun toString(): String {
        return "I'm Rect. ($x, $y) size($width, $height)"
    }
}