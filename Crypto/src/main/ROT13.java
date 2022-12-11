import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;


public class ROT13  {
   Character cs;
   Character cf;
    ROT13(Character cs, Character cf) {
        this.cs = cs;
        this.cf = cf;
    }

    ROT13() {
    }

    public String crypt(String text) throws UnsupportedOperationException {
        // declare: text to charArray, calculate the shift number, StringBuilder to append element
        // get the new position and convert to char, by (char)s.charAt(0)+shift;
        // go through the whole root;
        char[] charArr = text.toCharArray();
        int shift = (int)this.cf - (int)this.cs;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<charArr.length; i++) {
            if (isUpperCase(charArr[i])) {
                sb.append((char) ((int) (charArr[i] + shift - 65) % 26 + 65));
            } else if (isLowerCase(charArr[i])) {
                sb.append( (char) ((int) (charArr[i] + shift - 97) % 26 + 97));
            } else {
                sb.append(text.charAt(i));
            }
        }
        return String.valueOf(sb);
    }
    public String encrypt(String text) {
        char[] charArr = text.toCharArray();
        int shift = (int)this.cf - (int)this.cs;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<charArr.length; i++) {
            if (isUpperCase(charArr[i])) {
                sb.append((char) ((int) (charArr[i] + shift - 65) % 26 + 65));

            } else if (isLowerCase(charArr[i])) {
                sb.append( (char) ((int) (charArr[i] + shift - 97) % 26 + 97));
            } else {
                sb.append(text.charAt(i));
            }
        }
        return String.valueOf(sb);
    }

    public String decrypt(String text) {
        Character[] charArr = text.toCharArray();
        int shift = (int)this.cs - (int)this.cf;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<charArr.length; i++) {
            if (isUpperCase(charArr[i])) {
                sb.append((char) ((int) (charArr[i] + shift - 65) % 26 + 65));

            } else if (isLowerCase(charArr[i])) {
                sb.append( (char) ((int) (charArr[i] + shift - 97) % 26 + 97));
            } else {
                sb.append(text.charAt(i));
            }
        }
        return String.valueOf(sb);
    }

    public static String rotate(String s, Character c) {
        int cf = String.valueOf(c).codePointAt(0);
        char newChar;
        StringBuilder sb = new StringBuilder();
        for (String p : s.split("")) {
            int pc = p.codePointAt(0);
            if (pc > 64 && pc < 91 || pc > 96 && pc < 124) {
                int cs = 65;
                if (pc > 90) cs = 97;
                int dif = cf - cs;
                if (dif > 13) dif -= 32;
                if (pc > (cs + dif - 1)) newChar = (char) (pc - dif);
                else newChar = (char) (pc + dif);
                sb.append(newChar);
            } else sb.append(p);
        }
        return String.valueOf(sb);
    }
    }