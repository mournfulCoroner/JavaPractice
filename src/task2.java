
import java.util.HashMap;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner cn = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        String str1, str2, ks = "";
        int k = 0;
        System.out.println("Введите первую последовательность:");
        str1 = cn.nextLine();
        System.out.println("Введите вторую последовательность:");
        str2 = cn.nextLine();
        if(str1.length()!=str2.length()) System.out.println("Не подходит");
        else
        {
            for(int i = 0; i < str1.length(); i++)
            {
                ks += str1.charAt(i);
                if(map.containsKey(ks))
                {
                    k = map.get(ks);
                    k++;
                    map.remove(ks);
                    map.put(ks,k);
                }
                else map.put(ks,1);
                ks = "";

                ks += str2.charAt(i);
                if(map2.containsKey(ks))
                {
                    k = map2.get(ks);
                    k++;
                    map2.remove(ks);
                    map2.put(ks,k);
                }
                else map2.put(ks,1);
                ks = "";
            }
            if(map.size() == map2.size()) {
                    for (String key : map.keySet()) {
                        if (!map.get(key).equals(map2.get(key))) {
                            System.out.println("Не подходит");
                            return;
                        }
                    }
                System.out.println("Подходит");
            }
            else System.out.println("Не подходит");
        }
    }
}
