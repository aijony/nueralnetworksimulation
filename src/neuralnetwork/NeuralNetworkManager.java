package neuralnetwork;

public class NeuralNetworkManager {

	private double inputs[][];
	private double expectedOutputs[][];
	private final boolean isTrained = false;
    
 
	private double  learningRate = 12.2;
	private int maxRuns = 6000;
	private double minErrorCondition = 0.001;
	
	
	
	 //NPL is neurons per layer
    private int neuronsPerLayer [] = {3, 10, 5, 1};
    
	private NeuralNetwork  network;
    
	public static void main(String[] args) {
		NeuralNetworkManager manager = new NeuralNetworkManager();
		manager.testXOR();
		        
	}
		 
	public void testXOR(){
		
		
        network = new NeuralNetwork(neuronsPerLayer, learningRate);

		
		// Inputs for xor
	     inputs = new double[][]{ { 1, 1 , 1 }, { 1, 0 , 1}, { 0, 1 , 1}, { 0, 0 , 1} };
	 
	    //  xor training data
	     expectedOutputs = new double[][]{ { 0 }, { 1 }, { 1 }, { 0 } };
	     
	     int i;
	     
	     double error = 1;
	     for (i = 0; i < maxRuns; i++) {
	          error = 0;
	          results(false);       	  	
	             
	         }
	     results(true);
	}
	
	/*
	 * @params If truue the results will be printed
	*/
    public void results(boolean print)
    {
    	//Propagates through all different inputs
    	for (int inputIndex = 0; inputIndex < inputs.length; inputIndex++) {
    	  	network.propagate(inputs[inputIndex], expectedOutputs[inputIndex]);	  
    	  	if(print)
    	  		printResult(inputIndex);
         }
    }

   /*Prints the current target, actual, and output*/
	private void printResult(int inputIndex) {
		System.out.println("Input: " + doubleArrayToString(inputs[inputIndex])
		+ "Target: " + doubleArrayToString(expectedOutputs[inputIndex]) 
		+ "Actual: " + doubleArrayToString(network.getOutput()[0]));
	}
	
	
	/*Converts a double to  a string*/
	private String doubleArrayToString(double [] input){

		String outString = "";
		for(double out : input){
			
			outString = outString +  out + " "  ;
		}
		return outString;
	}
		
	}

