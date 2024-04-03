package physics;

public class Gravity {
		
	static boolean goingup = true;
	
	private static double x = 0;

	private static double vi = 100;

	private static double t=0;

	private static double g = 9.8;
	
	
	public static int jump() {
		
		//X =viT + 0.5At2
		//if (goingup) {
			
		x = vi*t + 0.5*g*(t/60)*(t/60);
		t++;
		//}
		
		return (int) x;
		
	}

}
