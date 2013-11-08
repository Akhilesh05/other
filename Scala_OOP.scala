import scala.math._

class Quadratic(aa:Double, bb:Double, cc:Double){
	var a:Double = aa
	var b:Double = bb
	var c:Double = cc
	
	def solve():List[Double] = {
		var x1 = (-b+ sqrt(pow(b,2) - 4*a*c))/(2*a)
		var x2 = (-b- sqrt(pow(b,2) - 4*a*c))/(2*a)
		List(x1, x2)
	}
	
}

object Main {
	var x:Quadratic = new Quadratic(3,13,6)
	var y:List[Double] = (new Quadratic(2,8,4)).solve()
	println(y)
	println(x.a)
	println(x.solve)
	
   def addInt(a:Int)(b:Int) : Int = {
   	a + b
   }
   def mult(a:Int, b:Int):Int = {
   	a * b
   }
   def main(args: Array[String]) {
      println(addInt(5){
          var x : Int = 3
          var y : Int = 2
          x + y
        }
      )
      println(mult(3,{
      	var x:Int = 2
      	var y:Int = 4
      	x * y
      }))
      var x:Map[String, String] = Map("Akh" -> "Best", "Udaye" -> "Good")
      println(x("Akh"))
      x.keys.foreach{ a =>
          println(a)
      }
      for(a <- x.values){
      	println(a)
      }
   }
}
