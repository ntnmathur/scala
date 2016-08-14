val x = "Nitin"
val ch = '+'

val sign = ch match {
  case '+' => 1
  case '-' if Character.isDigit(ch) => Character.digit(ch,10)
  case _ =>  0
}

val i = '-'
val pair = (1,0)

val y = pair match {
  case (0,_) => "0"
  case (y,0) => y + "0"
  case _ => "neither is 0"
}

y//res0: String = 10

val arr = Array(1,2)
val z = arr match {
  case Array(0) => "0"
  case Array(x,y) => x+" "+y
  case Array(0, _*) => "0 ..."
  case _ => "Something else"
}
z //z: String = 1 2

val (lowercase, uppercase) = "Hello Nitin".partition(Character.isUpperCase(_))
lowercase // res2: String = HN
uppercase // res3: String = ello itin

abstract class Amount
case class Dollar(value: Double) extends Amount
case class Currency(value: Double, unit: String) extends Amount
case object Nothing extends Amount

val amt = new Dollar(2)

//amt match {
//  case Dollar(v) => "$" + v
//  case Currency(_,u) => "Oh no " + u
//  case Nothing => ""
//}

val scores = Map("Alice"->1, "Bob" -> 2)
scores.get("Alice") match {
  case Some(score) => println(score)
  case None => println("No score")
} // 1