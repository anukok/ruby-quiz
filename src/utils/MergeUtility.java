package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MergeUtility {

	/*
	 * Merge intersecting sets into one.
	 * Returns list of disjoint sets.
	 */
	public static <T> List<Set<T>> merge( List<Set<T>> input ) {

		if(input == null || input.size() <= 1)
			return input;
		
		// djSets represents disjoint sets.
		List<Set<T>> djSets = new ArrayList<Set<T>>();

		for (Set<T> inputSet : input) {

			if (djSets.size() == 0) {
				djSets.add(inputSet);
				continue;
			}

			// iSets represent intersecting sets.
			List<Set<T>> iSets = new ArrayList<Set<T>>();

			// for every set in input, find the intersecting sets in djSets
			for (Set<T> djSet : djSets) {

				if (intersection(inputSet, djSet)) {

					iSets.add(djSet);

				}
			}

			if (iSets.size() > 0) {
				
				iSets.add(inputSet);
				
				Set<T> union = findUnion(iSets);

				for (Set<T> set : iSets) {

					djSets.remove(set);

				}
				
				djSets.add(union);
				
			} else
				djSets.add(inputSet);

		}

		return djSets;
	}

	/**
	 * returns union of all input sets
	 */
	private static <T> Set<T> findUnion(List<Set<T>> sets) {

		if(sets == null)
			return null;
		
		Set<T> union = new HashSet<T>();

		for (Set<T> set : sets) {
			for (T element : set) {
				if ( ! union.contains(element)) {
					union.add(element);
				}
			}
		}

		return union;

	}

	/**
	 * 
	 * @return : boolean indicating if the sets intersect.
	 */
	private static <T> boolean intersection(Set<T> A, Set<T> B) {

		if (A == null || B == null)
			return false;
		
		for (T element : B) {
			if (A.contains(element)) {
				return true;
			}

		}

		return false;
	}

}
