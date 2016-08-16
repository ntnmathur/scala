package com.nitin.scalaForImpatient

/**
  * Created by nmathur on 5/10/16.
  */
class Point(val x: Double = 0, val y: Double = 0) {
  println(s"Welcome to (${x},${y})")
}

object Point {
  def apply(x: Double, y: Double) = new Point(x,y)
}


package com {
  package company {
    package dept {
      class Employee {

      }
    }
  }
}