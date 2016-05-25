/**
 * Created by upxs078 on 5/24/16.
 */
public class ShiftCipherTest {
    public static void main(String[] args) {
        if(args.length == 2) {
            int shift = Integer.parseInt(args[0]);
            String message = args[1];
            ShiftCipher sf = new ShiftCipher(shift, message);
            String ciphertext = sf.encipher();
            System.out.println(ciphertext);
            System.out.println(sf.decipher());

        }

    }
}
