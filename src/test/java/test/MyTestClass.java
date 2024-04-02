package test;

import org.junit.jupiter.api.Test;

import java.util.StringTokenizer;

public class MyTestClass {


    @Test
    public void test1() {
        String input = "aabcccbbad";
        String consecutiveStr;
        while ((consecutiveStr = this.findConsecutive(input)) != null) {
            input = input.replace(consecutiveStr, "");
            System.out.println("-> " + input);
        }
    }

    @Test
    public void test2() {
        String input = "abcccbad";
        String consecutiveStr;
        while ((consecutiveStr = this.findConsecutive(input)) != null) {
            //find the char before it
            char c = consecutiveStr.charAt(0);
            c = (char) (c - 1);
            if (c >= 'a') { // ensure not less than 'a'
                input = input.replace(consecutiveStr, String.valueOf(c));
                System.out.println("-> " + input + ", " + consecutiveStr + " is replaced by " + c);
            } else {
                input = input.replace(consecutiveStr, "");
                System.out.println("-> " + input);
            }

        }

//        System.out.println(  (char)('b'-1) );
//        System.out.println(  String.valueOf('b').getClass() );
//        System.out.println('c' > 'a');
    }


    private String findConsecutive(String str) {
        String prev = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(i, i + 1);
            if (prev == null || s.equals(prev)) {
//                System.out.println(sb + ", ");
            } else { // if not consecutive

                String output = sb.toString();
                if (output.length() >= 3) { // if found more than 3 chars
                    return output;
                }
                sb.setLength(0);
            }

            prev = s;
            sb.append(s);
        }

        String output = sb.toString();
        if (output.length() >= 3) { // if found more than 3 chars
            return output;
        } else {
            return null;
        }
    }
}