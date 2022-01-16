package settings;

import hash.*;

public class Settings {
    public static boolean includeSpace;
    public static boolean capitalize;
    public static HashFunction hashFunction = HashFunctions.BINARY_HASH_FUNCTION;
    public static HashFunction unhashFunction = HashFunctions.BINARY_HASH_FUNCTION;
}
