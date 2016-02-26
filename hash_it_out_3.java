package hash_it_out_3;

public class Answer {

	public static int[] answer(int[] digest) {

		int[] ansArr = new int[digest.length];

		int imo;
		int xord = 0;
		/*
		 * This is the algorithm to get the digest, but we need to get the
		 * inverse... for(int i = 0; i < digest.length; i++){
		 * 
		 * if (i == 0){ imo = 0; } else imo = digest[i-1];
		 * 
		 * ansArr[i] = ((129*digest[i])^imo)%256;
		 * 
		 * 
		 * }
		 */

		// If this is the first element, set XOR value to 0,
		// otherwise, set to previous element
		for (int i = 0; i < digest.length; i++) {
			if (i == 0)
				imo = 0;
			else
				imo = ansArr[i - 1];

			// Get the XOR. Inverse of XOR is XOR ;)
			xord = digest[i] ^ imo;

			// I thought about this as a looping numberline from 0 - 255. To get
			// the inverse mod,
			// we loop every 129 digits through the numberline until we reach 0.
			// The number of loops is the input value
			// I XOR'd first to make this easier.
			ansArr[i] = (((xord * 129) % 256) + 256) % 256;
		}

		return ansArr;

	}

}
