class QuadraticEqt
	
	
	def initialize(a, b, c)
		@a = a.to_f
		@b = b.to_f
		@c = c.to_f
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
