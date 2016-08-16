
/******* Remove all but first negative integer from ArrayBuffer *******/

import java.net.URL
import java.util.Scanner

import scala.collection.mutable.ArrayBuffer

val x = new ArrayBuffer[Int]()
x+=(1,2,3,-1,4,5,-7,-8)

// Create another ArrayBuffer with all but first
val negAB = new ArrayBuffer[Int]()

// All negatives
for (index <- x.indices if x(index) < 0) {
    negAB.append(x(index))
}
//Remove the first
negAB.remove(0)
negAB
x.diff(negAB)

/** Another way **/

val y = new ArrayBuffer[Int]()
y+=(1,2,3,-1,4,5,-7,-8)


def removeAllButFirstNegNumber(buf: ArrayBuffer[Int]) = {
  // All negatives
  val indexToRemove = for (index <- x.indices if x(index) < 0)
    yield index

  //Remove the first
  val indexToRemove1 = indexToRemove.drop(1)

  //Remove the same. Reverse will avoid out of bound exception
  for (i <- indexToRemove1.reverse) y.remove(i)

}

removeAllButFirstNegNumber(y)
y

/** Another way Immutable **/

// Find all indexes to be removed
val indexesToRemove = (for (index <- y.indices if y(index)<0) yield index).drop(1)

// Return the ArrayBuffer except the indexes that are to be removed
for (i <- 0 until y.length if !indexesToRemove.contains(i)) yield y(i)
y

/******* Word Count *******/

  val in = new java.util.Scanner(new java.net.URL("http://www.umich.edu/~umfandsf/other/ebooks/alice30.txt").openStream())
  //val count = scala.collection.mutable.Map[String, Int]() // Mutable
  var count = Map[String, Int]() // Mutable
  while (in.hasNext) {
    val word = in.next()
    //count(word) = count.getOrElse(word,0) + 1 // Mutable Implementation
    count = count + (word -> (count.getOrElse(word,0) + 1)) // Immutable Map but var is used to change value

  }

  println(count("Alice"))
  println(count("Rabbit"))


/******* Group By *******/

val words = Array("Mary", "had", "a","little","lamb","its","fleece","as","white","as","snow")

// Map of 1st alphabet and all words starting with the same
words.groupBy(_.substring(0,1))
//res13: scala.collection.immutable.Map[String,Array[String]] = Map(s -> [Ljava.lang.String;@434ea6ec, f -> [Ljava.lang.String;@60b0f279, a -> [Ljava.lang.String;@ff1787, M -> [Ljava.lang.String;@6b61a093, i -> [Ljava.lang.String;@567549f8, l -> [Ljava.lang.String;@2e4b6520, h -> [Ljava.lang.String;@57dc2f9e, w -> [Ljava.lang.String;@38ba5b22)

// Map of lengths and all words of same length
words.groupBy(_.length)
//res14: scala.collection.immutable.Map[Int,Array[String]] = Map(5 -> [Ljava.lang.String;@5e47e2a0, 1 -> [Ljava.lang.String;@416fa6bb, 6 -> [Ljava.lang.String;@92b608d, 2 -> [Ljava.lang.String;@7ecfcdae, 3 -> [Ljava.lang.String;@7cc89b8c, 4 -> [Ljava.lang.String;@565c4454)

for ((k,v) <- words.groupBy(_.substring(0,1))) {
  println(k+":")
  for (i <- v)
    println(v.toString)
}


for ((k,v) <- words.groupBy(_.length))
  println(k+":"+v)

/******* Partition *******/
"New York".partition(_.isUpper) // res17: (String, String) = (NY,ew ork)

// Use partition to remove all but 1st negative number
val buf = ArrayBuffer(1,2,-3,4,-5,6,-7,8)
//buf: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 2, -3, 4, -5, 6, -7, 8)

val (neg,pos) = buf.partition(_ <0)
//res18: (scala.collection.mutable.ArrayBuffer[Int],
// scala.collection.mutable.ArrayBuffer[Int]) =
// (ArrayBuffer(-3, -5, -7),ArrayBuffer(1, 2, 4, 6, 8))

val result = pos  // assign all positive numbers
result += neg(0)  // append the 1st negative

result
//res19: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 2, 4, 6, 8, -3)

/******* Zip *******/

val symbols = Array("<","-",">")
val counts = Array(2,10,2)
val pairs = symbols.zip(counts)
// pairs: Array[(String, Int)] = Array((<,2), (-,10), (>,2))

for ((k,v)<-pairs)   print(k*v)
// <<---------->>