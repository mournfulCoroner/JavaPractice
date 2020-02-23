import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class lab01 {
    public static void main(String[] args) throws IOException {
        Scanner cn = new Scanner(System.in);
        InputStreamReader in = new InputStreamReader(System.in);
        int n;
        boolean check = true;
        System.out.println("Введите количество символов:");
        n = cn.nextInt();
        if(n%2!=0)
        {
            System.out.println("Не может быть правильной комбинации с нечётным количество символов");
        }
        else {
            Stack st = new Stack(n);
            System.out.println("Введите последовательность скобочек:");
            st.push((char) in.read());

            for (int i = 0; i < n - 1; i++) {
                if (!st.showTop().equals('{') && !st.showTop().equals('}') && !st.showTop().equals('(') && !st.showTop().equals(')')
                        && !st.showTop().equals('[') && !st.showTop().equals(']')) {
                    check = false;
                    break;
                }
                st.push((char) in.read());
                if ((st.showPrevious().equals('(') && st.showTop().equals(')')) || (st.showPrevious().equals('{') && st.showTop().equals('}'))
                        || (st.showPrevious().equals('[') && st.showTop().equals(']'))) {
                    st.pop();
                    st.pop();
                } else if (st.showTop().equals(']') || st.showTop().equals('}') || st.showTop().equals(')')) {
                    check = false;
                    break;
                }
            }
            if (check) System.out.println("Правильная комбинация");
            else System.out.println("Неправильная комбинация");
        }
    }
}
