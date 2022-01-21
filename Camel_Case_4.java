
//Problem url


/*
https://www.hackerrank.com/challenges/three-month-preparation-kit-camel-case/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=three-month-preparation-kit&playlist_slugs%5B%5D=three-month-week-one
*/

//Probelm description
/*
Camel Case is a naming style common in many programming languages. In Java, method and variable names typically start with a lowercase letter, with all subsequent words starting with a capital letter (example: startThread). Names of classes follow the same pattern, except that they start with a capital letter (example: BlueCar).

Your task is to write a program that creates or splits Camel Case variable, method, and class names.

Input Format

Each line of the input file will begin with an operation (S or C) followed by a semi-colon followed by M, C, or V followed by a semi-colon followed by the words you'll need to operate on.
The operation will either be S (split) or C (combine)
M indicates method, C indicates class, and V indicates variable
In the case of a split operation, the words will be a camel case method, class or variable name that you need to split into a space-delimited list of words starting with a lowercase letter.
In the case of a combine operation, the words will be a space-delimited list of words starting with lowercase letters that you need to combine into the appropriate camel case String. Methods should end with an empty set of parentheses to differentiate them from variable names.
Output Format

For each input line, your program should print either the space-delimited list of words (in the case of a split operation) or the appropriate camel case string (in the case of a combine operation).
Sample Input

S;M;plasticCup()

C;V;mobile phone

C;C;coffee machine

S;C;LargeSoftwareBook

C;M;white sheet of paper

S;V;pictureFrame

Sample Output

plastic cup

mobilePhone

CoffeeMachine

large software book

whiteSheetOfPaper()

picture frame

Explanation

Use Scanner to read in all information as if it were coming from the keyboard.

Print all information to the console using standard output (System.out.print() or System.out.println()).

Outputs must be exact (exact spaces and casing).
*/



//******************* Solution *******************

import java.io.*;
import java.util.*;

public class Solution {
    public static void C_helper(String temp,char x){
        String arr[] = temp.split(" ");
        String res="";
        if(x!='C'){
            for(int i=0;i<arr.length;i++){
             if(i==0){
                res = arr[0].toLowerCase();   
             } else{
                 res+= Character.toUpperCase(arr[i].charAt(0))+ arr[i].substring(1);
             } 
            }
            if(x=='M')
                res+="()";
            System.out.println(res);
            return;
        }
        // case C;C
            for(int i=0;i<arr.length;i++){
                String r=Character.toUpperCase(arr[i].charAt(0))+ arr[i].substring(1);
                System.out.print(r);
            }
            System.out.println();
    }
    
    public static void S_helper(String temp){
                    for(int i=0;i<temp.length();i++){
                        if(Character.isUpperCase(temp.charAt(i))){
                            if(i==0){
                               System.out.print(Character.toLowerCase(temp.charAt(i)));
                            continue; 
                            }
                            System.out.print(" "+Character.toLowerCase(temp.charAt(i)));
                            continue;
                            
                        }
                        System.out.print(temp.charAt(i));
                    }
                    System.out.println();
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String s="";
        while(sc.hasNext()){
            s+= sc.nextLine()+"\n";
        }
        String c[] = s.split("\n");
        for(String a : c){
            String d[] = a.split(";");
            if(d[0].equals("S")){
                if(d[1].equals("M")){
                    String temp =d[2];
                    temp=temp.substring(0,temp.length()-2);
                    S_helper(temp);
                }else if(d[1].equals("C")){
                    S_helper(d[2]);
                }else{
                    S_helper(d[2]);
                }
            }else{
                if(d[1].equals("M")){
                    C_helper(d[2],'M');
                }else if(d[1].equals("C")){
                    C_helper(d[2],'C');
                }else{
                    C_helper(d[2],'V');
                }
            }
        }  
        
    }
}
