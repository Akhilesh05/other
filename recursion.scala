//Recursive program in Scala

object Main extends App {
	def factorial(num:Int):Int =
        if(num == 1)
            1
        else
    	    num * factorial(num - 1)
        
	println( factorial(4) )
}
