import java.util.*;

public class One28BitConverter {

  static void convert(int base10Number) {
    ArrayList<Digit> digits = new ArrayList<Digit>();
    String[] segments = {" _","|", "_", "|", "|", "_", "|"};

    if(base10Number < 0) {
      base10Number *= -1;

      System.out.print("-");
    }

    while(base10Number != 0) {
      digits.add(0, new Digit(base10Number % 128));
     
      base10Number /= 128;
    }
  
    for(Digit digit : digits) {
      System.out.println(digit.getNum());

      for(int i = 0; i < 7; i++) {
        if(digit.getBinary().get(i))
          System.out.print("\u001B[33m" + segments[i] + "\u001B[0m");
        else
          System.out.print(" ");
      
        if(i % 3 == 0)
          System.out.println();
      }

      System.out.println();
    }

    digits.clear(); //consider changing to .removeAll()
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    while(true) {
      int number = 0;
      System.out.print("Input a number in base 10: ");
      
      try {
        number = input.nextInt();
        convert(number);
      } catch(InputMismatchException e) {
        input.next();
        System.out.println("You must input a number.");
      }
    }
  }
}
