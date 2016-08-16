package com.nitin.scalaByExample

object QuickSortFunctional {

  def main(args: Array[String]): Unit = {
    val xs = Array(3, 7, 2, 8, 6, 0, 10)
    println("Unsorted:")
    println(xs.deep.mkString("\t"))
    println("Sorted:")
    println(sort(xs).deep.mkString("\t"))

    def sort(xs: Array[Int]): Array[Int] = {
      /*
       * If the array is empty or consists of a single element, 
       * it is already sorted, so return it immediately.
       */
      if (xs.length <= 1) xs
      else {
        /*
         * If the array is not empty, pick an an element in the middle of it as a pivot.
         */
        val pivot = xs(xs.length / 2)
        /*
         * Partition the array into two sub-arrays containing elements that are less than,
         * respectively greater than the pivot element, and a third array which contains
         * elements equal to pivot.
         */
        Array.concat(
          //Sort the first two sub-arrays by a recursive invocation of the sort function
          //The result is obtained by appending the three sub-arrays together.
          sort(xs filter (pivot >)),
          xs filter (pivot ==),
          sort(xs filter (pivot <)))
      }
    }
  }
}