package hash;

import settings.Settings;

public abstract class HashFunction {
	int hashRadix;
	int hashUnitSize;
	String name;

	public HashFunction(int hashRadix, int hashUnitSize, String name) {
		this.hashRadix = hashRadix;
		this.hashUnitSize = hashUnitSize;
		this.name = name;
	}

	public String hash(String s) {
		String hash = "";

		for (int i = 0; i < s.length(); i++) {
			hash += hashChar(s.charAt(i));

			if (Settings.includeSpace == true)
				hash += " ";
		}

		return hash.trim();
	}

	public String unhash(String s) throws UnhashException {
		s = s.trim();
		String unhash = "";

		try {
			for (int parseIndex = 0; parseIndex < s.length(); parseIndex += hashUnitSize) {
				while (s.charAt(parseIndex) == ' ') parseIndex++;
				unhash += unhashChar(s.substring(parseIndex, parseIndex + hashUnitSize));
			}
		} catch (RuntimeException e) {
			throw new UnhashException(s, this);
		}

		return unhash;
	}

	public String hashChar(char input) {
		MyNumber hashedNumber = new MyNumber(input, hashRadix);

		int lengthOffset = hashUnitSize - hashedNumber.toString().length();
		return (lengthOffset <= 0) ? hashedNumber.toString() : "0".repeat(lengthOffset) + hashedNumber;
	}

	public char unhashChar(String input) {
		return (char) new MyNumber(input, hashRadix).changeRadix(10).value;
	}

	@Override
	public String toString() {
		return name;
	}
}