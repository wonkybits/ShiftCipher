/**
 * Created by upxs078 on 5/24/16.
 */
public class ShiftCipher {
    // shift factor
    private int s;

    private String plaintext;
    private String ciphertext;

    // divisor
    private final int N = 26;

    private final char[] ALPHABET = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public ShiftCipher(int s, String plaintext) {
        setS(s);
        setPlaintext(plaintext);
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public String getPlaintext() {
        return plaintext;
    }

    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }

    public String encipher() {
        ciphertext = "";
        int idx = 0;

        for(int i = 0; i < plaintext.length(); i++) {
            idx = find(plaintext.charAt(i));
            ciphertext += ALPHABET[this.mod((idx + s), N)];
        }

        return ciphertext;
    }

    public String decipher() {
        String output = "";
        int idx = 0;

        for(int i = 0; i < ciphertext.length(); i++) {
            idx = find(ciphertext.charAt(i));
            output += ALPHABET[this.mod((idx - s), N)];
        }

        return output;
    }

    private int find(char val) {
        for(int i = 0; i < ALPHABET.length; i++) {
            if(ALPHABET[i] == val) return i;
        }
        return 0;
    }

    private int mod(int a, int n) {
        return ((a % n + n) % n);
    }
}
