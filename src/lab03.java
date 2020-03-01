import java.io.IOException;
import java.util.Scanner;

public class lab03 {
    public static int getPriority(char s)
    {
        switch (s)
        {
            case '^': return 4;
            case '*': case '/': return 3;
            case '+': case '-': return 2;
            case '(': case ')': return 1;
            default: return 0;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String input, output = "";
        input = sc.nextLine();
        char n;
        Stack opz = new Stack(input.length());
        for(int i = 0; i < input.length(); i++)
        {
            if(i == 0 && input.charAt(i) == '-') output+="0 ";
            while(Character.isDigit(input.charAt(i)))
            {
                output+=input.charAt(i);
                if(i == input.length()-1) break;
                i++;
            }
            output+=" ";
            if(getPriority(input.charAt(i)) == 0)
                continue;
            else
            {
                switch (input.charAt(i))
                {
                    case '(':
                        opz.push(input.charAt(i));
                        break;
                    case '*': case '/': case '+': case '-': case '^':

                        while(!opz.isEmpty() && (getPriority(input.charAt(i)) <= getPriority((char)opz.showTop())))
                        {
                            output+=opz.showTop();
                            opz.pop();
                        }
                        if(opz.isEmpty() || getPriority(input.charAt(i)) > getPriority((char)opz.showTop()) && !opz.isEmpty())
                        {
                            opz.push(input.charAt(i));
                        }
                        break;
                    case ')':
                        while ((char)opz.showTop() != '(')
                        {
                            output+=(char)opz.showTop();
                            opz.pop();
                        }
                        opz.pop();
                }
            }
        }
        while(!opz.isEmpty()) {
            output += (char) opz.showTop();
            opz.pop();
        }

        System.out.println(output);

        Stack calc = new Stack(output.length());
        int n1, n2, result = 0;
        String num = "";
        for(int i = 0; i < output.length(); i++)
        {
            if(Character.isDigit(output.charAt(i))) {
                while(Character.isDigit(output.charAt(i))){
                    num+= output.charAt(i);
                    if(i == output.length() - 1) break;
                    i++;
                }
                calc.push(Integer.parseInt(num));
                num = "";
            }
            else if(output.charAt(i) == ' ') continue;
            else
            {
                n2 = (int)calc.pop();
                n1 = (int)calc.pop();
                switch (output.charAt(i))
                {
                    case '+': result = n1 + n2; break;
                    case '-': result = n1 - n2; break;
                    case '*': result = n1 * n2; break;
                    case '/': result = n1 / n2; break;
                    case '^': result = (int)Math.pow(n1,n2); break;
                    default: System.out.println("Ошибка"); break;
                }
                calc.push(result);
            }
        }
        System.out.println("Результат: " + result);
    }
}
