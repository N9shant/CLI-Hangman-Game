import org.w3c.dom.ls.LSOutput;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

class Hangman_game {
    public static void main(String args[]) {
        Scanner aa = new Scanner(System.in);

//        System.out.println("Enter the word Size");
//        int n = aa.nextInt();
//        aa.nextLine();
//        System.out.println("Enter each character of the word in new line");
//
//        String s = "";
//        for(int i=0; i<n; i++) {
//            s += aa.nextLine();
//        }
//
//        System.out.println("Your word is " + s);

        String arr[] = {"nishant", "sanjay", "samir"};

        String target_string = arr[new Random().nextInt(arr.length)];
//        int cout[] = new int[26];
        int max_guess = 5;
        int cnt_guess = 0;
        int char_left = target_string.length();
        boolean ans = false;

        StringBuilder s = new StringBuilder();
        for(int i=0; i<target_string.length(); i++) {
            s.append("-");
        }
        System.out.println(s);
        System.out.println("maximum guesses are " + max_guess);

        HashSet<String> set = new HashSet<>();

        while(cnt_guess < max_guess && char_left > 0) {

            System.out.println("Guess a lowercase character");
            String guess_char = aa.nextLine();

            boolean flag = false;

            if(guess_char.length() != 1 || (guess_char.charAt(0) < 'a' || guess_char.charAt(0) > 'z')) {
                System.out.println("Invalid Input, input should contain only one lowercase character");
            }
            else if(set.contains(guess_char)) {
                System.out.println("Guessed character has been repeated");
            }
            else {
                set.add(guess_char);
                for(int i=0; i<target_string.length(); i++) {
                    if(guess_char.charAt(0) == target_string.charAt(i)) {
                        s.setCharAt(i, target_string.charAt(i));
                        flag = true;
                        char_left--;
                    }
                }


                if(flag) {
                    System.out.println(s);
//                    System.out.println("Chances Left " + (max_guess-cnt_guess));
                }
                else {
                    cnt_guess++;
                    System.out.println(s);
                    System.out.println("Guessed character dosen't appears in the given word");
//                    System.out.println("Chances Left " + (max_guess-cnt_guess));
                    if(max_guess - cnt_guess == 0) {
                        ans = true;
                    }
                }
                if(char_left != 0)
                    System.out.println("Chances Left " + (max_guess-cnt_guess));
            }
        }

        if(ans) {
            System.out.println();
            System.out.println("YOU LOOSE, TRY NEXT TIME");
            System.out.println("The word was " + target_string);
        }
        else {
            System.out.println();
            System.out.println("Congrulations, YOU WON!!!");
//            System.out.println("The word was " + target_string);
        }

    }
}