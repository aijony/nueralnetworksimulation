
package neuralnetwork;

import java.util.*;

import utilities.MatrixMath;

public class NeuralNetwork {
	
	Propagation propagation;
	
	int [] neuronsPerLayer;
	Neurons neurons;
	Connections connections;
    
	/* */
    public NeuralNetwork(int [] npl, double learningRate) {
		neuronsPerLayer = npl;
		for(int index = 1; index < neuronsPerLayer.length -1; index++){
			neuronsPerLayer[index]++;
		}
		connections = new Connections(neuronsPerLayer);
		neurons = new Neurons(neuronsPerLayer);
    	propagation = new Propagation(neurons, connections, neuronsPerLayer, learningRate);
	}	
		

    public void propagate(double [] input, double [] expected){
    		propagation.forward(input);
    		propagation.backward(expected);
    }
    
    public double calculateCost(double [] expected){
		double [][] difference = MatrixMath.subtract(MatrixMath.rowToMatrix(expected), propagation.output());
		difference = MatrixMath.multiply(difference, MatrixMath.transpose(difference));
    	return difference[0][0] * 0.5;
    }
    
    public double[][] getOutput(){
    	return propagation.output();
    }
  

}
