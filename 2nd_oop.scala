class Animal {
	var habitat  : String = null
	var name     : String = null
	
	def eat(food : Animal) : String = s"At last ${food.name} was eaten by ${this.name}"
}

class Bird extends Animal {
	var breed       : String = null
	var featherType : String = null
	
	def escape(predator : Cat) : String = s"${this.name} was able to escape from the deadly claws of ${predator.name}"
	
}

class Cat extends Animal {
	var breed   : String = null
	var furType : String = null
	
	def attack(prey : Bird) = s"${this.name} jumped on ${prey.name}"
}

object Main {
	def main(args:Array[String]) {
		
		var bird = new Bird
		bird.name = "Piggu"
		bird.habitat  = "Tree"
		bird.breed = "Pink pigeon"
		bird.featherType = "Smooth"
		
		var canine = new Cat
		canine.name = "Catie"
		canine.habitat  = "Houses"
		canine.breed = "Dobbercat"
		canine.furType = "Rough"
		
		println(canine.attack(bird))
		println(bird.escape(canine))
		println(canine.eat(bird))
	}
}
