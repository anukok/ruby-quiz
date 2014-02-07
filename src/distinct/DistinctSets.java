package distinct;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utils.MergeUtility;

import builder.InputBuilderFactory;
import builder.SetsInputBuilder;

public class DistinctSets {

	/**
	 * @param args
	 * Takes 3 integer arguments
	 * First argument indicates the number of sets to be generated.
	 * Second argument indicates the maximum size of any set generated.
	 * Third argument indicates the type of set element, 
	 * 1 = Character, 2 = Integer .. more type can be added later.
	 * 
	 * If argument 1 or argument 2 are invalid,
	 *  a sample fixed input is considered.
	 */
	public static void main(String[] args) {

		int inputSize = 0, maxSetSize = 0, type = 0;

		if (args.length >= 3) {
			try {
				inputSize = Integer.parseInt(args[0]);
				maxSetSize = Integer.parseInt(args[1]);
				type = Integer.parseInt(args[2]);
			} catch (NumberFormatException e) {
				System.err.println("Argument" + " must be an integer");
				System.exit(1);
			}
		}
		else{
			System.err.println("Expects 3 int arguments");
			System.exit(1);
		}
		System.out.println(inputSize + " " + maxSetSize + " " + type);
		SetsInputBuilder inputBuilder = null;

		if(type == 1){
			inputBuilder = InputBuilderFactory
			.getCharacterInputBuilder();
		}
		else if(type == 2){
			inputBuilder = InputBuilderFactory
			.getIntegerInputBuilder();
		}

		runMerger(inputBuilder, inputSize, maxSetSize);

	}

	/**
	 * Generates a random list of sets based on input parameters,
	 * and runs the merger algorithm to generate disjoint sets.
	 * @param <T>
	 * @param inputBuilder
	 * @param inputSize
	 * @param maxSetSize
	 */
	private static <T> void runMerger(SetsInputBuilder inputBuilder, Integer inputSize, Integer maxSetSize){

		List<Set<T>> input = null ;
		
		if(inputSize > 0 && maxSetSize > 0)
			input = inputBuilder.generateRandomInput(inputSize,maxSetSize);
		else
			input = inputBuilder.generateSampleInput();

		System.out.println("------------INPUT------------");
		for( Set<T> set : input){
			System.out.println(set);
		}

		long startTime = System.currentTimeMillis();

		List<Set<T>> output = MergeUtility.merge(input);

		long stopTime = System.currentTimeMillis();

		long elapsedTime = stopTime - startTime;
		System.out.println("Runtime in ms:" + elapsedTime);

		System.out.println("------------OUTPUT------------");
		for( Set<T> set : output){
			System.out.println(set);
		}

	}

}
