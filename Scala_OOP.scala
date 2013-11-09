import scala.math._


case class Point(x:Double, y:Double)

class QuadraticEqt(aa:Double=0, bb:Double=0, cc:Double=0){
	var a:Double = aa
	var b:Double = bb
	var c:Double = cc
	
	def yIntercept():Double = c
	
	def gradAt(x:Double):Double = 2*a*x + b
	
	def normalAt(x:Double):Double = -1 / gradAt(x)
	
	def solve():Map[String, Double] = {
		var x1 = (-b+ sqrt(pow(b,2) - 4*a*c))/(2*a)
		var x2 = (-b- sqrt(pow(b,2) - 4*a*c))/(2*a)
		Map("x1" -> x1, "x2" -> x2)
	}
	
	def stationary():Point = {
		var x:Double = -b/(2*a)
		var y:Double = -pow(b,2)/(4*a) + c
		Point(x, y)
	}
	
}

object Main {

   def main(args: Array[String]) {
   	    var x:QuadraticEqt = new QuadraticEqt(3,13,6)
   	    println(x.gradAt(x.stationary().x))  //equals zero everytime
   	    var z = (new QuadraticEqt(2,4,6)).stationary
   	    println(z)
   	    println(x.gradAt(3))
   	    println(x.normalAt(3))
   	    println(x.yIntercept)
   	    
   	    var fx:QuadraticEqt = new QuadraticEqt
   	    fx.a = 2
   	    fx.b = 8
   	    fx.c = 6
   	    println(fx)
   	    println(fx.solve)
   	    println(fx.gradAt(5))
   	    println(fx.stationary)
   	    println(fx.normalAt(fx.stationary.x)) // normal at stationary is always infinity
   	    println(fx.gradAt(fx.stationary.x))   // grad at stationary is always zero
   }
   
}
