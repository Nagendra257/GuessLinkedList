package guessme;

/**
 * A LinkedList-based implementation of the Guess-A-Number game
 */
public class LinkedListGame {
	public LLIntegerNode head;
	public LLIntegerNode priorguess;
	public boolean state;
	public int guess;
	public int noOfGuesses;

	// TODO: declare data members as necessary

	/********************************************************
	 * NOTE: for this project you must use linked lists implemented by yourself. You
	 * are NOT ALLOWED to use Java arrays of any type, or any class in the java.util
	 * package (such as ArrayList).
	 *******************************************************/

	/********************************************************
	 * NOTE: you are allowed to add new methods if necessary, but DO NOT remove any
	 * provided method, and do NOT add new files (as they will be ignored by the
	 * autograder).
	 *******************************************************/

	// LinkedListGame constructor method
	public LinkedListGame() {
		head = new LLIntegerNode(1000);
		LLIntegerNode current = head;
		for (int i = 1001; i < 10000; i++) {
			current.setLink(new LLIntegerNode(i));
			current = current.getLink();
		}
		priorguess = null;
		state = false;
		noOfGuesses = 0;
		guess = 1000;

	}

	// Resets data members and game state so we can play again

	public void reset() {
		// TODO
		head = null;
		priorguess = null;
		state = false;
		noOfGuesses = 0;
		guess = 1000;
		head = new LLIntegerNode(1000);

		LLIntegerNode current = head;
		for (int i = 1001; i < 10000; i++) {
			current.setLink(new LLIntegerNode(i));
			current = current.getLink();
		}
	}

	// Returns true if n is a prior guess; false otherwise.
	public boolean isPriorGuess(int n) {
		LLIntegerNode current= priorguess;
		while(current!=null) {
			if(n==current.getInfo()) {
				return true;
			}
			current=current.getLink();
		}

		return false;

	}

	// Returns the number of guesses so far.
	public int numGuesses() {
		// TODO
		return noOfGuesses;
	}

	/**
	 * Returns the number of matches between integers a and b. You can assume that
	 * both are 4-digits long (i.e. between 1000 and 9999). The return value must be
	 * between 0 and 4.
	 * 
	 * A match is the same digit at the same location. For example: 1234 and 4321
	 * have 0 match; 1234 and 1114 have 2 matches (1 and 4); 1000 and 9000 have 3
	 * matches (three 0's).
	 */
	public static int numMatches(int a, int b) {
		// TODO
		int match=0;
	    int temp1;
	    int temp2;
		for(int i=0;i<4;i++) {
			temp1=a%10;
			temp2=b%10;
			a=a/10;
			b=b/10;
			if(temp1==temp2) {
				match++;
			}
		}
		return match;
	}

	/**
	 * Returns true if the game is over; false otherwise. The game is over if the
	 * number has been correctly guessed or if no candidate is left.
	 */
	public boolean isOver() {
		// TODO

		return state;
	}

	/**
	 * Returns the guess number and adds it to the list of prior guesses. The
	 * insertion should occur at the end of the prior guesses list, so that the
	 * order of the nodes follow the order of prior guesses.
	 */
	public int getGuess() {
		// TODO: add guess to the list of prior guesses.
		LLIntegerNode newGuess = new LLIntegerNode(guess);
		LLIntegerNode temp=priorguess;
		if(priorguess==null) {
			priorguess=newGuess;
		}
		else {
			while(temp.getLink()!=null) {
				temp=temp.getLink();
			}
			temp.setLink(newGuess);
		}
		noOfGuesses++;
		return guess;
	}

	/**
	 * Updates guess based on the number of matches of the previous guess. If
	 * nmatches is 4, the previous guess is correct and the game is over. Check
	 * project description for implementation details.
	 * 
	 * Returns true if the update has no error; false if no candidate is left
	 * (indicating a state of error);
	 */
	public boolean updateGuess(int nmatches) {
		// TODO

		if (nmatches == 4) {
			state = true;
			return true;
           }
		else {
			LLIntegerNode current = head;
			LLIntegerNode newCad = null;
			LLIntegerNode cadLast = null;
			while (current != null) {
				if (numMatches(guess, current.getInfo()) == nmatches) {
					LLIntegerNode newNode = new LLIntegerNode(current.getInfo());
					if (newCad == null) {
						newCad = newNode;
						cadLast = newNode;
					} else {
						cadLast.setLink(newNode);
						cadLast = newNode;
					}
				}
                current = current.getLink();
			}
			head = newCad;
			if (head == null) {
				return false;
			}
			guess = head.getInfo();
		}

		return true;
	}

	// Returns the head of the prior guesses list.
	// Returns null if there hasn't been any prior guess
	public LLIntegerNode priorGuesses() {
		// TODO
		if (priorguess == null) {
			return null;
		}
		return priorguess;
	}

	/**
	 * Returns the list of prior guesses as a String. For example, if the prior
	 * guesses are 1000, 2111, 3222, in that order, the returned string should be
	 * "1000, 2111, 3222", in the same order, with every two numbers separated by a
	 * comma and space, except the last number (which should not be followed by
	 * either comma or space).
	 *
	 * Returns an empty string if here hasn't been any prior guess
	 */
	public String priorGuessesString() {
		// TODO
		String result="";
	    LLIntegerNode curr=priorguess;
		while(curr!=null) {
		    result=result+curr.getInfo();
		    if(curr.getLink()!=null) {
			result=result+", ";
		    }
		    curr=curr.getLink();
	    }
		return result;
	
	}

}
