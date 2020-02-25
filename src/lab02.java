import java.util.Scanner;

public class lab02 {
    public static void main(String[] args) {
        Scanner cn = new Scanner(System.in);
        int a, b, c , d, sum;
        int a2=0, b2=0, c2=0, d2=0;
        System.out.println("Введите количество купюр 1000, 500, 100 и 30:");
        a = cn.nextInt();
        b = cn.nextInt();
        c = cn.nextInt();
        d = cn.nextInt();
        System.out.println("Введите необходимую сумму:");
        sum = cn.nextInt();
        if(sum%10!=0) System.out.println("Ошибка, нельзя выдать данную сумму.");
        else {
            int ost;
            ost = sum / 1000;
            if (ost <= a) {
                sum -= 1000 * ost;
                a2 = ost;
                if(sum >=10 && sum<=90)
                {
                    a2--;
                    sum+=1000;
                }
            } else {
                sum -= 1000 * a;
                a2 = a;
            }
            if (sum == 0)
                System.out.println("Понадобится " + a2 + " - 1000-х купюр, " + b2 + " - 500-х купюр, " + c2 + " - 100-х купюр и " + d2 + " - 30-х купюр");
            else {
                ost = sum / 500;
                if (ost <= b) {
                    sum -= 500 * ost;
                    b2 += ost;
                    if(sum >=10 && sum<=90)
                    {
                        b2--;
                        sum+=500;
                    }
                } else {
                    sum -= 500 * b;
                    b2 += b;
                }
                if (sum == 0)
                    System.out.println("Понадобится " + a2 + " - 1000-х купюр, " + b2 + " - 500-х купюр, " + c2 + " - 100-х купюр и " + d2 + " - 30-х купюр");
                else {
                    ost = sum / 100;
                    if (ost <= c) {
                        sum -= 100 * ost;
                        if(sum == 10 ||  sum == 40 || sum == 70)
                        {
                            c2-=2;
                            sum+=200;
                        }
                        if(sum == 20 || sum == 50 || sum == 80)
                        {
                            c2--;
                            sum+=100;
                        }
                        c2 += ost;
                    } else {
                        sum -= 100 * c;
                        c2 += c;
                    }
                    if (sum == 0)
                        System.out.println("Понадобится " + a2 + " - 1000-х купюр, " + b2 + " - 500-х купюр, " + c2 + " - 100-х купюр и " + d2 + " - 30-х купюр");
                    else {
                        ost = sum / 30;
                        if (ost <= d) {
                            sum -= 30 * ost;
                            d2 += ost;
                        }
                        else {
                            sum -= 30 * d;
                            d2 += d;
                        }
                        if (sum == 0)
                            System.out.println("Понадобится " + a2 + " - 1000-х купюр, " + b2 + " - 500-х купюр, " + c2 + " - 100-х купюр и " + d2 + " - 30-х купюр");
                        else System.out.println("Ошибка, нельзя выдать данную сумму.");
                    }
                }
            }
        }
    }
}
