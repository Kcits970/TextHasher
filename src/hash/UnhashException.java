package hash;

public class UnhashException extends Exception {
    static final int MAX_ERR_LENGTH = 32;

    public UnhashException(String errorString, HashFunction function) {
        super(String.format("Cannot unhash '%s' with '%s'",
                (errorString.length() > MAX_ERR_LENGTH) ? errorString.substring(0, MAX_ERR_LENGTH - 3) + "..." : errorString,
                function));
    }
}
