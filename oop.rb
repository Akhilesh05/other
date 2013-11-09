class QuadraticEqt
	
	@@count = 0
	
	def initialize(a, b, c)
		@a, @b, @c = a.to_f, b.to_f, c.to_f
		@@count += 1
	end
	
	def solve
		x1 = (-@b+Math::sqrt(@b**2 - 4*@a*@c))/(2*@a)
		x2 = (-@b-Math::sqrt(@b**2 - 4*@a*@c))/(2*@a)
		Array[x1, x2]
	end
	
	def gradAt x
		2*@a*x + @b
	end
	
	def normalAt x
		-1 / gradAt(x)
	end
	
end

fx = QuadraticEqt.new 2, 8, 6

puts fx.solve
