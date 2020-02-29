import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class lab01 {
    public static void main(String[] args) throws IOException {
        Scanner cn = new Scanner(System.in);
        InputStreamReader in = new InputStreamReader(System.in);

            boolean check = true;
            Stack st = new Stack();
            char next;
            System.out.println("Введите последовательность скобочек:");
                next = (char)in.read();
                if(next != '('  && next != '{'  && next != '[')
                 {
                     System.out.println("Неправильная комбинация");
                 }
                else {
                    st.push(next);
                    while (in.ready()){
                        next = (char) in.read();
                        if (next!= '(' && next!= ')' && next!= '{' && next!= '}' && next!= '[' && next!= ']' ) {
                            if(next!='\n') check = false;
                            break;
                        }
                        if (!st.isEmpty() && ((st.showTop().equals('(') && next == ')') || (st.showTop().equals('{') &&
                                next == '}') || (st.showTop().equals('[') && next == ']'))) st.pop();
                        else if (!st.isEmpty() && (st.showTop().equals(']') || st.showTop().equals('}') || st.showTop().equals(')'))) {
                            check = false;
                            break;
                        }
                        else st.push(next);
                    }
                    if (check && st.isEmpty()) System.out.println("Правильная комбинация");
                    else System.out.println("Неправильная комбинация");
                }
    }
}
