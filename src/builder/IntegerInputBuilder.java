package builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class IntegerInputBuilder extends SetsInputBuilder {

	@SuppressWarnings("unchecked")
	@Override
	public List<Set<Integer>> generateRandomInput(int numSets, int maxSizeOfSets) {
		List<Set<Integer>> input = new ArrayList<Set<Integer>>();

		for (int i = 0; i < numSets; i++) {
			input.add(getRandomSet(maxSizeOfSets));
		}

		return input;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Set<Integer>> generateSampleInput() {
		List<Integer> A = Arrays.asList(10, 20, 30);

		List<Integer> B = Arrays.asList(30, 40, 50, 60);

		List<Integer> C = Arrays.asList(80, 70);

		List<Integer> D = Arrays.asList(90);

		List<Integer> E = Arrays.asList(93, 92, 91, 90);

		List<Set<Integer>> input = new ArrayList<Set<Integer>>();

		input.add(new HashSet<Integer>(A));
		input.add(new HashSet<Integer>(B));
		input.add(new HashSet<Integer>(C));
		input.add(new HashSet<Integer>(D));
		input.add(new HashSet<Integer>(E));

		return input;
	}

	private int getRandomInt() {

		Random r = new Random();
		return r.nextInt(100);
	}

	private Set<Integer> getRandomSet(int maxSize) {

		Set<Integer> set = new HashSet<Integer>();

		int setSize = (int) (maxSize * Math.random());

		for (int i = 0; i < setSize + 1; i++)
			set.add(getRandomInt());

		return set;
	}

}
