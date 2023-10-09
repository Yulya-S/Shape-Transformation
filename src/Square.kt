class Square(var x: Int, var y: Int, var side: Int): Figure(0), Transforming {

    override fun area(): Float {
        return (side*side).toFloat()
    }

    override fun resize(zoom: Int) {
        if (side + zoom > 0){
            side += zoom
        }
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        var h_plus = if (y > centerY){
            y -= side
            true
        } else false
        var w_plus = if (x < centerX){
            x += side
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

        if (w_plus) x -= side
        if (h_plus) y += side
    }

    override fun toString(): String {
        return "I'm Square. ($x, $y) size($side, $side)"
    }
}