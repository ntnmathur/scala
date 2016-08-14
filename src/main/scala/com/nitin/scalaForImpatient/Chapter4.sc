import java.sql.Timestamp
import java.text.SimpleDateFormat

//class Point(val x: Double = 0, val y: Double = 0) {
//  println(s"Welcome to (${x},${y})")
//
//  def move(dx:Double,dy:Double) = new Point(x + dx, y+dy)
//  def distanceFromOrigin = math.sqrt(x*x + y*y)
//  override def toString = s"(${x},${y})"
//  def *(factor: Double) = new Point(x*factor,y*factor)
//}
//
//val p = new Point(3,4)
//p*2 //res0: Point = (6.0,8.0)
//p.*(2) // res1: Point = (6.0,8.0)
//
//
//
//p.move(10,20)
//p.distanceFromOrigin // res1: Double = 5.0
//p.x // res2: Double = 3.0
//p.y // res3: Double = 4.0

class Point(val x: Double = 0, val y: Double = 0) {
  println(s"Welcome to (${x},${y})")
}

object Point {
  def apply(x: Double, y: Double) = new Point(x,y)
}

val p = Point(3,4)
p


1 to 10 map (3 * _) filter (_%5 == 2)
1.to(10).map(3*_).filter(_%5 ==2)

1::2::3::Nil // res8: List[Int] = List(1, 2, 3)
1::(2::(3::Nil)) // res9: List[Int] = List(1, 2, 3)

object Accounts {
  private var lastNumber = 0
  // Use () as this is a mutator method
  def newUniqueNumber() = {
    lastNumber +=1
    lastNumber
  }
}

Accounts.newUniqueNumber() // res10: Int = 1
Accounts.newUniqueNumber() // res11: Int = 2
Accounts.newUniqueNumber() // res12: Int = 3


"1".toDouble.toLong

0.toLong

// Creating the class
class Time1 (val hours: Int, val minutes: Int = 0) {
  def this (h: Int) = {this (h,0)} // auxilliary constructor if only hour is provided or default above
  if (hours <0 || hours > 24 || minutes <0 || minutes >60 )
    throw new IllegalArgumentException
  override def toString = f"${hours}:${minutes}%02d"

  def - (other: Time) = hours*60 + minutes - other.hours*60 - other.minutes
  def < (other: Time) = this - other < 0

  //def before(other: Time) = hours < other.hours || hours == other.hours && minutes < other.minutes
}

object Time1 {
  def apply (h: Int, m: Int) = new Time (h,m)
}

//Time(9,0) - Time (12,30) // res10: Int = -210
//Time(9,0) < Time (12,30) // res11: Boolean = true



class Time (val h: Int, val m: Int = 0) {
  private var minutesSinceMidnight = h*60 + m  // added new variable
  // Uniform access - converted hours to method
  def hours = minutesSinceMidnight/60
  def minutes = minutesSinceMidnight%60

  // Inorder to update the minutes, we can implement minutes_= method
  def minutes_=  (newValue: Int)  {
    if (newValue <0 || newValue > 60) throw new IllegalArgumentException
    minutesSinceMidnight = minutesSinceMidnight + newValue
  }
  // auxilliary constructor if only hour is provided or default above
  def this (h: Int) = {this (h,0)}

  if (h <0 || h > 24 || m <0 || m >60 ) throw new IllegalArgumentException

  override def toString = f"${hours}:${minutes}%02d"

  def before(other: Time) = minutesSinceMidnight < other.minutesSinceMidnight  // improved
}

/** No change below **/
val morning = new Time(9,0) // morning: Time = 9:00
//val crazy = new Time(-3,2)  // java.lang.IllegalArgumentException
val afternoon = new Time(16,30) //afternoon: Time = 16:30
afternoon.before(morning) // res10: Boolean = false
morning.before(afternoon) // res11: Boolean = true
val hourOnly = new Time(9) // hourOnly: Time = 9:00

// New
val noon = new Time(12)  // noon: Time = 12:00
noon.hours  // res12: Int = 12
noon.minutes // res13: Int = 0
noon.minutes = 30 // noon.minutes: Int = 30
noon.minutes = -999 // java.lang.IllegalArgumentException

val now = new java.util.Date
//val now1 = new java.sql.Date


import java.util.Date
val dt = new Date  //shortcut due to import

import java.util._
import java.lang.Math._ // static import

import java.awt.{Color,Font} // import 2 classes
import java.util.{HashMap => JavaHashMap} // Alias
import java.util.{HashMap => _,_} // Hide a class

