package encryptdecrypt;

public class AlgMake {

    public static Decryptor make(String alg) {
        switch (alg) {
            case "unicode":
                return new ShiftUnicode();
            case "shift":
                return new ShiftAlpha();
            default:
                return null;
        }
    }
}

