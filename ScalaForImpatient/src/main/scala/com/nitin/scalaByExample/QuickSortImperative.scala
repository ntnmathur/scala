package com.nitin.scalaByExample

object QuickSortImperative {
  def main(args: Array[String]): Unit = {
    /*
     * Definitions start with a reserved word:
     *  Function definitions start with def
     *  Variable definitions start with var 
     *  Definitions of values (i.e. read only variables) start with val.
     */
    val xs = Array(3, 7, 2, 8, 6, 0, 10)
    println("Unsorted:")
    println(xs.deep.mkString("\t"))
    sort(xs)
    println("Sorted:")
    println(xs.deep.mkString("\t"))

    def sort(xs: Array[Int]) {
      def swap(i: Int, j: Int) {
        /*
         * Array types are written Array[T] rather than T[]
         * Array selections are written a(i) rather than a[i].
         */
        val t = xs(i); xs(i) = xs(j); xs(j) = t
      }
      /*
       * The declared type of a symbol is given after the symbol and a colon. 
       * The declared type can often be omitted-the compiler can infer it from the context.
       * Functions can be nested inside other functions. 
       * Nested functions can access parameters and local variables of enclosing functions. 
       * For instance, the name of the array xs is visible in functions swap and sort1, 
       * and therefore need not be passed as a parameter to them.
       */
      def sort1(l: Int, r: Int) {
        val pivot = xs((l + r) / 2)
        var i = l; var j = r
        while (i <= j) {
          while (xs(i) < pivot) i += 1
          while (xs(j) > pivot) j -= 1
          if (i <= j) {
            swap(i, j)
            i += 1
            j -= 1
          }
        }
        if (l < j) sort1(l, j)
        if (j < r) sort1(i, r)
      }
      sort1(0, xs.length - 1)
    }
  }
}