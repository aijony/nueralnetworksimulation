package utilities;

import simulation.ReturnData;
public class IOInteraction {
	public static double[] getInput(ReturnData data){
		
		double output[] = new double[5] ;
		
		output[0] = data.x;
		output[1] = data.y;
		output[2] = data.i;
		output[3] = data.j;
		
		//Bias
		output[4] = 1.0;
		
		return output;
		
	}
}
