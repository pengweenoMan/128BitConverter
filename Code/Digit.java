import java.util.*;

public class Digit {
    private ArrayList<Boolean> onOff = new ArrayList<Boolean>();
    private int num;

    public Digit(int number) {
      num = number;

      for(int i = 0; i < 7; i++)
        onOff.add(false);

      for(int i = num; i > 0; i--) {
        for(int j = 6; j >= 0; j--) {
          if(i >= Math.pow(2, j)) {
            onOff.set(j, true);

            i -= Math.pow(2, j);
          }
        }
      }
    }//34359738368

    public ArrayList<Boolean> getBinary() {
        return onOff;
    }

    public int getNum() {
        return num;
    }
}