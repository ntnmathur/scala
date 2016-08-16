val a = 6*7
a
//a=43
val b: BigInt = 6*7
b.pow(1000)

import scala.math._
sqrt(10)
1.to(10)
1.to(10).map(sqrt(_))

6.*(7)

Int.MaxValue
"Mmissisippi".distinct
"Rhine".permutations.toArray

"ABC".sum.toInt
'A'.toInt
val x = 4
if (x >0) 1 else -1

//val y = if (x >0) "Hello" else -1
val z = if (x <0) "Hello"
val aa = ()

if (x>0) 1
if (x>0) 1 else ()

val y = 8
val x0 = 1
val y0 = 2

val distance = {
  val dx = x - x0
  val dy = y - y0
  sqrt(dx * dx + dy * dy)
}


val nothingReturned = {
  val yo = 10
}
nothingReturned

val n = 10
for (i <- 1 to n) println(i)
for (c <- "Hello") println(c)

for (k <- 1 to 3 ; l <- 1 to 3 if (k != l)) print((10*k+l) + " ")

for (i <- 1 to 10) yield i % 3

def abs(x: Double) = if (x >0) x else -x

def fact(n: Int): BigInt = if (n <=0 ) 1 else n*fact(n-1)

def box(s: String): Unit = {
  println (s)
}

box("Nitin")

def ifact (n: Int): Unit = {
  var r = 1
  for (i <- 1 to n) r = r*i
  println(r)
}

ifact(3)

def decorate(str: String, left: String = "[", right: String = "]") =
  left + str + right

decorate("Nitin")
decorate("Nitin", "[[[[")
decorate("Nitin", right = "[[[[")

def sum(args: Int*) = {
  var result = 0
  for (i <- args) result += i
  result
}
sum(1,2,3)
sum(1 to 10: _*)

def recSum (args: Int*): BigInt = {
  if (args.length == 0) 0 else
    args.head + recSum(args.tail:_*)
}
recSum(1 to 10:_*)


object ORDER_STATUS extends Enumeration {
  val deadOrder = 0 :: Nil
  val newOrder = 1 :: Nil
  val processingOrder = 2 :: Nil
  val completedOrder = 3 :: Nil
  val onHoldOrder = 4 :: 20 :: Nil
}

ORDER_STATUS.values.flatten


