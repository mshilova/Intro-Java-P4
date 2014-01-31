/**
 * File name: P4.java
 * Program that sorts Strings using comparison methods
 * into 1-D and 2-D arrays.
 * 1-D array holds all words that are sorted
 * 2-D array - table of 26 rows
 * Date: 02/07/2013
 */
import java.util.Scanner;        // read sentence from keyboard
public class P4
{

  /**
   * Reads input from keyboard
   * call sort1D(), display the sorted array
   * Call sort2D().
   */
  public static void main(String [] args)
  {
    Scanner scan = new Scanner(System.in);
    String sentence;                                            // read line
    System.out.print("Enter your words to be sorted (exit ^D): ");
    do
    {
      sentence = scan.nextLine();                        // read entire line
      String [] words = sentence.split(" ");          // allocate words input

      sort1D(words);                             // sort 1-D array of strings

      System.out.print("1-D Sorted: ");
      for( int i = 0; i < words.length; i++)
         System.out.print(words[i] + " ");     // place into array
      System.out.println();

      sort2D(words);                         // sort 2-D array of strings

      System.out.print("Enter your words to be sorted (exit ^D): ");
    }while(scan.hasNext() );              // loop until no more input lines
    System.exit(0);                       // terminates current JVM
  }

  /**
   * Filename: sort1D
   * Created by: Mariya Shilova
   * @param array of words that 
   * needs to be sorted
   * Bubble sort is used to sort
   * Date: 02/07/2013
   */
  public static void sort1D(String [] w)
  {
    // create a temporary String reference for swap.
    String tmp;

    // loop through the array of words and compare characters
    for(int i = 0; (i < w.length) && (w[i] != null); i++)
      for(int j = w.length - 1; i < j && (w[j] != null); j--)
          if( w[j-1].compareToIgnoreCase(w[j]) > 0)//sort words-case
                                                   // insensitive
          // bulble sort
          {
            tmp = w[j-1];
            w[j-1] = w[j];
            w[j] = tmp;
          }
  }
  /**
   * File name: sort2D
   * Created by: Mariya Shilova
   * @param sorted array of words
   * Instanciates 2-D array, consisting of 26 rows.
   * Each row represents a letter of the alphabet.
   * Each row is filled with words with the same letter, 
   * i.e. first row - words that start with 'A' or 'a', second 
   * row - words with 'B' or 'b', etc.
   * Date: 02/26/2013
   */
  public static void sort2D(String [] sw)
  {
    final int ALPHA = 26;        // 26 letters in the alphabet - # of rows
    int i, j;                    // indeces for loops
    boolean nextAlpha = false;   // sequence to next alpha letter
    char A = 'A';                // 1st letter of alphabet uppercase
    char a = 'a';                // 1st letter of alphabet lowercase

    int col;                     // number of words start with letter
    char tmpFirstChar;           // first letter of strings

    String a2D[][] = new String[ALPHA][]; // allocate 26 rows for each
                                          // alpha letter
    // initialize a2D with nulls
    for(int k = 0; k < ALPHA; k++)
    {
     a2D[k] = null;
    }

    // traverse sw[] and test if begins with 'A' or 'a'
    // then increment col else sequence to 'B' or 'b'
    // repeat with each letter of alphabet
    // allow 26 elements of alphabet
    for(i = j = col = 0; j <= a2D.length; ++j)
    {
      if( col > 0 )
        a2D[j - 1] = new String [col]; // allocate row with # words start
                                       // with letter
      nextAlpha = false;

      for(col = 0; (i < sw.length) && !nextAlpha; ++i)
      {
        if(sw[i] == null)
        {
          nextAlpha = true;
          break;
        }

        // if 1st letter of sw[i] matches 'A' or 'a' then increment
        // col counter, else sequence to 'B' or 'b'
        // repeat for each letter of the alphabet
         tmpFirstChar = sw[i].charAt(0);
         if(tmpFirstChar == A || tmpFirstChar == a)
         {
           col++;
         } else {
         nextAlpha = true;
         A++; // sequence to next letter if not match
         a++;
         break;
         }

      }
    }
    // traverse sw[] and assign 'A' from sw[] into a2D, using length of each
    // row "a2D.length" as a delimiter. print each element's indeces and value
    // test for a null reference in sw[] and a2D[][].
    int k = 0;
    for(i = 0; i < a2D.length && k < sw.length; i++)
    {
      // checking for null reference
      if (a2D[i] != null)
      {
        System.out.println();
        for(j =  0; j < a2D[i].length; j++, k++)
        {
          System.out.println("a2D[" + i + "][" + j + "]: " + sw[k]);
        }
      }
    }
  }
}
