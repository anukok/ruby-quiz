
package builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * This class encapsulates the methods 
 * of generating input consisting of 
 * Sets of characters
 *
 */
public class CharacterInputBuilder extends SetsInputBuilder {

	
	@SuppressWarnings("unchecked")
	public List<Set<Character>> generateRandomInput(int numSets, int maxSizeOfSets) {
		
		List<Set<Character>> input = new ArrayList<Set<Character>>();
		
		for(int i=0; i<numSets; i++){
			input.add(getRandomSet(maxSizeOfSets));
		}
		
		return input;
	}
	
	/**
	 * 
	 *  generates a random letter
	 */
	private Character getRandomCharacter(){
		
		
		Character c = (Character)(char) ((int)(26 * Math.random()) + 'a');
		return c;
	}
	
	/**
	 * Generates a random set of letters ,
	 * of max size given.
	 */
	private Set<Character> getRandomSet(int maxSize){
		
		Set<Character> set = new HashSet<Character>();
		
		int setSize = (int)(maxSize * Math.random());
		
		for(int i=0; i<setSize+1; i++)
			set.add(getRandomCharacter());
		
		return set;
	}
	
	/* (non-Javadoc)
	 * @see distinct.SetsInputBuilder#generateSampleInput()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Set<Character>> generateSampleInput() {
		
		List<Character>  A = Arrays.asList('D', 'E', 'G');
		
		List<Character>  B = Arrays.asList('C', 'J', 'K', 'M');
		
		List<Character>  C = Arrays.asList('K', 'M');
		
		List<Character>  D = Arrays.asList('H');
		
		List<Character>  E = Arrays.asList('D', 'H', 'L', 'R');
		
		List<Character>  F = Arrays.asList('G', 'L');
		
		List<Set<Character>> input = new ArrayList<Set<Character>>();
		
		input.add(new HashSet<Character>(A));
		input.add(new HashSet<Character>(B));
		input.add(new HashSet<Character>(C));
		input.add(new HashSet<Character>(D));
		input.add(new HashSet<Character>(E));
		input.add(new HashSet<Character>(F));
	
		return input;
	}

	
}
