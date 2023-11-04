import kotlin.math.*

class Circle(var x: Int, var y: Int, var radius: Int) : Figure(0), Transforming {
    override fun resize(zoom: Int) {
        radius *= zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        val rzX = x - centerX
        val rzY = y - centerY

        x = centerX
        y = centerY

        when (direction) {
            RotateDirection.Clockwise -> {
                x += rzY
                y -= rzX
            }
            RotateDirection.CounterClockwise -> {
                x -= rzY
                y += rzX
            }
        }
    }

    override fun area(): Float {
        return (radius * radius * PI).toFloat();
    }

    override fun toString(): String {
        return "I'm Circle. ($x, $y) radius($radius)"
    }
}