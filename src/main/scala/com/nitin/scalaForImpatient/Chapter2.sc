//def isVowel(ch: Char) = {
//  if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
//    true
//  else
//    false
//}

/* Check if a Char is String */
def isVowel (ch: Char) = "aeiou".contains(ch)

//Test
isVowel('u')

/* Return all vowels in String */
def vowels(s: String): String = {
  var vowels: String = ""
  for (ch: Char <- s if isVowel(ch)) {vowels += ch}

  vowels
}

//Test
println (vowels("kick"))  //i


/* Return all vowels in String */
def vowels2(s: String): String = {
  var vowels: String = ""
  for (ch: Char <- s if isVowel(ch)) yield ch
}

//Test
println (vowels("hahahaha")) //aaaa

def vowelRecursion(s: String): String = {
  if (s.length == 0) ""
  else {
    val ch = s(0)
    val rest = vowelRecursion(s.substring(1))
    if (isVowel(ch)) ch + rest else rest
  }

}

vowelRecursion("nitin")

/* With Defaults */
/* Return all vowels in String */
def isVowelX (ch: Char, vowelChars: String) = vowelChars.contains(ch)

def vowelsX(s: String, vowelChars: String = "aeiou", ignoreCase: Boolean = true): String = {
  var vowels: String = ""
  for (ch: Char <- if(ignoreCase) s.toLowerCase else s if isVowelX(ch,vowelChars)) yield ch
}

val nums = new Array[Int](10)
val a = Array("Hello", "World")
a(0)  //res4: String = Hello
for (element <- a) print(element)
for (i <- 0 until a.length) print(i)
for (i <- a.indices) print(a(i))

val x = new Array[Int](10)  //x: Array[Int] = Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
for (i <- x.indices) x(i) = i*i  //res9: Array[Int] = Array(0, 1, 4, 9, 16, 25, 36, 49, 64, 81)
for (elem <- x) print(elem) //0149162536496481

import scala.collection.mutable.ArrayBuffer
val b = new ArrayBuffer[Int]() //b: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer()

b+=1  //res10: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1)
b+= (1,2,3,4) //res11: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 1, 2, 3, 4)
b++= Array(5,6,7,8) // res12: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 1, 2, 3, 4, 5, 6, 7, 8)

b.remove(3)
b //res14: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 1, 2, 4, 5, 6, 7, 8)

b.insert(3, 2)
b //res16: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 1, 2, 2, 4, 5, 6, 7, 8)

b.trimEnd(5)
b //res18: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 1, 2, 2)


val bArray = b.toArray  //bArray: Array[Int] = Array(1, 1, 2, 2)
val bBuffer = bArray.toBuffer //bBuffer: scala.collection.mutable.Buffer[Int] = ArrayBuffer(1, 1, 2, 2)

val arrayExample = Array(2,3,5,7,11)
val result = for (elem <- arrayExample) yield elem*2 //result: Array[Int] = Array(4, 6, 10, 14, 22)
result
//with guard
val result1 = for (elem <- arrayExample if elem%2 != 0) yield elem*2 //result1: Array[Int] = Array(6, 10, 14, 22)

Array(2,3,5,7,11).sum

val arr = ArrayBuffer(1,7,2,9) //arr: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 7, 2, 9)
arr.sum //res21: Int = 19
arr.sorted  //res22: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 2, 7, 9)
arr.sorted.reverse //res23: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(9, 7, 2, 1)

Array(1,2,3,4).toString //res24: String = [I@6b8b4ad8
Array(1,2,3,4).mkString("|") //res25: String = 1|2|3|4

val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8) //isVowelX: isVowelX[](val ch: Char,val vowelChars: String) => Boolean
val mscores = scala.collection.mutable.Map("Alice" -> 10) // mscores: scala.collection.mutable.Map[String,Int] = Map(Alice -> 10)

val bobScore = scores("Bob") //bobScore: Int = 3

//scores("Nitin") //  This can be an exception
scores.getOrElse("Nitin",0) // If not found - you can add a default value

mscores("Bob") = 7 // Add a new element
mscores //res28: scala.collection.mutable.Map[String,Int] = Map(Bob -> 7, Alice -> 10)

mscores += ("Nitin" -> 25, "Aarav" -> 29)
mscores // res29: scala.collection.mutable.Map[String,Int] = Map(Bob -> 7, Aarav -> 29, Nitin -> 25, Alice -> 10)
mscores -= "Alice"
mscores //res31: scala.collection.mutable.Map[String,Int] = Map(Bob -> 7, Aarav -> 29, Nitin -> 25)

scores // res33: scala.collection.immutable.Map[String,Int] = Map(Alice -> 10, Bob -> 3, Cindy -> 8)
scores + ("Bob" -> 10, "Fred" -> 7) // res34: scala.collection.immutable.Map[String,Int] = Map(Alice -> 10, Bob -> 10, Cindy -> 8, Fred -> 7)
scores // res35: scala.collection.immutable.Map[String,Int] = Map(Alice -> 10, Bob -> 3, Cindy -> 8)

val scores1 = scores + ("Bob" -> 10, "Fred" -> 7) //scores1: scala.collection.immutable.Map[String,Int] = Map(Alice -> 10, Bob -> 10, Cindy -> 8, Fred -> 7)
val scores2 = scores1 - "Alice" //scores2: scala.collection.immutable.Map[String,Int] = Map(Bob -> 10, Cindy -> 8, Fred -> 7)

scores //res36: scala.collection.immutable.Map[String,Int] = Map(Alice -> 10, Bob -> 3, Cindy -> 8)
for ((k,v) <- scores)
  println (k + " has value " + v)
/*
Alice has value 10
Bob has value 3
Cindy has value 8
res37: Unit = ()
 */

for ((k,v) <- scores) yield(v,k) //res38: scala.collection.immutable.Map[Int,String] = Map(10 -> Alice, 3 -> Bob, 8 -> Cindy)
scores.keySet // res39: scala.collection.immutable.Set[String] = Set(Alice, Bob, Cindy)
scores.values // res39: scala.collection.immutable.Set[String] = Set(Alice, Bob, Cindy)

val t = (1,3.14,"Fred") // t: (Int, Double, String) = (1,3.14,Fred)
t._2 //res41: Double = 3.14
t _2 // res42: Double = 3.14


val (_, second, third) = t
second // second: Double = 3.14
third // third: String = Fred


