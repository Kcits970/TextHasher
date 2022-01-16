package hash;

public class HashFunctions {
    public static final HashFunction BINARY_HASH_FUNCTION;
    public static final HashFunction QUATERNARY_HASH_FUNCTION;
    public static final HashFunction OCTAL_HASH_FUNCTION;
    public static final HashFunction DECIMAL_HASH_FUNCTION;
    public static final HashFunction HEXADECIMAL_HASH_FUNCTION;
    public static final HashFunction TRIACONTAKAIDECIMAL_HASH_FUNCTION;

    static {
        BINARY_HASH_FUNCTION = new HashFunction(2, 8, "Binary Hash") {};
        QUATERNARY_HASH_FUNCTION = new HashFunction(4, 4, "Quaternary Hash") {};
        OCTAL_HASH_FUNCTION = new HashFunction(8, 3, "Octal Hash") {};
        DECIMAL_HASH_FUNCTION = new HashFunction(10, 3, "Decimal Hash") {};
        HEXADECIMAL_HASH_FUNCTION = new HashFunction(16, 2, "Hexadecimal Hash") {};
        TRIACONTAKAIDECIMAL_HASH_FUNCTION = new HashFunction(32, 2, "Triacontakaidecimal Hash") {};
    }
}
