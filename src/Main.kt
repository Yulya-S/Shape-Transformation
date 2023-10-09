fun main() {
    println("Move:")

    val figures: Array<Movable>
    val movable: Movable = Rect(0,0,1,1)
    movable.move(1,1)
    println(movable)

    println("Area:")

    val f: Figure = Rect(0,0,1,1)
    val f2: Figure = Circle(4, 4, 4)
    val f3: Figure = Square(-1, 4, 2)

    println(f.area())
    println(f2.area())
    println(f3.area())

    val tf: Transforming = Rect(0,0,1,2)
    val tf2: Transforming = Circle(4, 4, 4)
    val tf3: Transforming = Square(-1, 4, 2)

    println("Resize:")

    tf.resize(3)
    tf2.resize(2)
    tf3.resize(2)

    println(tf)
    println(tf2)
    println(tf3)


    println("Rotate Clockwise:")

    for (i in 0..2){
        tf.rotate(RotateDirection.Clockwise, 1, 1)
        println(tf)
    }

    for (i in 0..2){
        tf2.rotate(RotateDirection.Clockwise, 1, 1)
        println(tf2)
    }

    for (i in 0..2){
        tf3.rotate(RotateDirection.Clockwise, 1, 1)
        println(tf3)
    }


    println("Rotate CounterClockwise:")

    for (i in 0..2){
        tf.rotate(RotateDirection.CounterClockwise, 1, 1)
        println(tf)
    }

    for (i in 0..2){
        tf2.rotate(RotateDirection.CounterClockwise, 1, 1)
        println(tf2)
    }

    for (i in 0..2){
        tf3.rotate(RotateDirection.CounterClockwise, 1, 1)
        println(tf3)
    }
}