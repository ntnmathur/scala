import scala.math._
val num = 3.14 // num: Double = 3.14
val fun = ceil _  // fun: Double => Double = <function1>

fun(num) // res0: Double = 4.0

Array(3.14, 1.42, 2.0).map(fun) //res1: Array[Double] = Array(4.0, 2.0, 2.0)

Array(3.14, 1.42, 2.0).map((x:Double)=> x*3) //res2: Array[Double] = Array(9.42, 4.26, 6.0)

//val triple = (x: Double) => x*3
//
//def triple(x:Double) = x*3

def valueAtOneQuarter(f:(Double) => Double) = f(0.25)

valueAtOneQuarter(3*_) // res3: Double = 0.75


valueAtOneQuarter(ceil _) // res3: Double = 1.0
valueAtOneQuarter(sqrt _) // res4: Double = 0.5

def mulBy (factor: Double) = (x:Double) => factor*x
val triple = mulBy(3)
triple(14)

mulBy(3) // res5: Double => Double = <function1>

val quintuple = mulBy(5) // quintuple: Double => Double = <function1>
quintuple(4) // res6: Double = 20.0

(1 to 9).map(0.1 * _) // (0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9)
(1 to 9).filter(_ % 2 ==0) // (2, 4, 6, 8)
(1 to 9).reduceLeft(_ * _) // 362880 ((1*2)*3)...*9)

(1 to 9).filter(_ % 2 == 0).map(0.1 * _) // (0.2, 0.4, 0.6, 0.8)
for (n <- 1 to 9 if n % 2 == 0) yield 0.1*n // (0.2, 0.4, 0.6, 0.8)

def mul (x: Int, y: Int) = x * y
def mulOneAtTime (x: Int) = (y: Int) => x * y

mulOneAtTime(3) // Int => Int = <function1>
mulOneAtTime(3)(14) // res15: Int = 42

def mul2(x:Int)(y:Int) = x*y

/************************************************************/

val zones = java.util.TimeZone.getAvailableIDs //Array(Etc/GMT+12, Etc/GMT+11, Pacific/Midway, Pacific/Niue,
zones.map(s=>s.split("/")) // Array(Array(Etc,GMT+12), Array(Etc,GMT+11), Array(Pacific,Midway), Array(Pacific,Niue),..
  .filter(_.length > 1) // filter all arrays that have length 1
  .map(a=>a(1)) // Pick up the 2nd vale from each array. Array(GMT+12, GMT+11, Midway, Niue),..)
  .grouped(10)  // This groups array in sets of 10 values and returns non-empty iterator
  .toArray  // To convert output of grouped to Array.  Array(Array(GMT+12, GMT+11, Midway, Niue..10values),Array(10 values..)
  .map(a=>a(0)) // Pick 1st value from each 10 length array. Array(GMT+12, Honolulu, Nome, Los_Angeles, Pitcairn,

1.to(10).reduceLeft(_ * _)  // res17: Int = 3628800: Product of n numbers

def fac(n: Int) = 1.to(n).reduceLeft(_ * _ ) // fac: fac[](val n: Int) => Int
fac(10) // res18: Int = 3628800

1.to(10)  // Generate 10 numbers
  .map(a=>2) // substitute each with constant 2
  .reduceLeft(_*_) //multiply 2 10 times. This is 2 power 10

def pow(a:Int, b: Int) = 1.to(b).map(n => a).reduceLeft(_ * _) // a power b
pow(2,4)  // res20: Int = 16

def concat (str: Seq[String], sep: String) = str.reduceLeft(_ + sep + _)
concat(Array("Nitin", "is", "great"), " ") // res21: String = Nitin is great

def While ( cond: => Boolean) (body: => Unit) {
  if(cond) {
    body;
    While (cond) (body)
  }
}

val n = 10;var i = 1;var f = 1
While(i<n) {f = f*i; i=i+1}
f // 362880


