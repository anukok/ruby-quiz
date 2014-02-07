/**
 * 
 */
package builder;

import java.util.List;
import java.util.Set;

/**
 * Abstract class representing a generic input builder.
 *
 */
public abstract class SetsInputBuilder {

	public abstract <T> List<Set<T>> generateSampleInput();

	public abstract <T> List<Set<T>> generateRandomInput(int inputSize, int maxSetSize);
		
}
