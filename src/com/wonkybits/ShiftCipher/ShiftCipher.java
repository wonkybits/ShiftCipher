package com.wonkybits.ShiftCipher;

/**
 * Created by upxs078 on 5/24/16.
 */
public class ShiftCipher {
    // shift factor
    private int s;

    private String message;
    private String output;

    // divisor
    private final int N = 26;

    private final char[] ALPHABET = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public ShiftCipher() {
        setS(0);
        setMessage(null);
    }

    public ShiftCipher(int s, String plaintext) {
        setS(s);
        setMessage(plaintext);
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String encipher() {
        this.clearOutput();
        int idx = 0;

        for(int i = 0; i < this.getMessage().length(); i++) {
            idx = find(this.getMessage().charAt(i));
            output += ALPHABET[this.mod((idx + s), N)];
        }

        return output;
    }

    public String decipher() {
        this.clearOutput();
        int idx = 0;

        for(int i = 0; i < this.getMessage().length(); i++) {
            idx = find(this.getMessage().charAt(i));
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

    private void clearOutput() {
        output = "";
    }
}
