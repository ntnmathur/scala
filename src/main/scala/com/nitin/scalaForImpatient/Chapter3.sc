
// Remove all but first negative integer from ArrayBuffer

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