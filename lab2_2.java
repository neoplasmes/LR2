import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class lab2_2 {

    public static void println(Object l){
        System.out.println(l);
    }

    public static void main(String[] args) {
        println("Придумайте пароль ^_^\nПароль может содержать только латинские буквы, " +
                "цифры от 0 до 9 и символ \"_\" \nЧтобы пароль был надёжным, он должен содержать минимум " +
                "8 символов, хотя бы одну заглавную букву, одну маленькую букву и одну цифру.\n");
        try{
            while(true){
                Scanner scn = new Scanner(System.in);
                String input = scn.nextLine().replaceAll("\\n", "").strip();

                //проверям некорректные символы
                String symbols = "[a-zA-Z0-9_]*";

                Pattern s = Pattern.compile(symbols);
                Matcher correct = s.matcher(input);

                if(!correct.matches()){
                    println("Пароль содержит недопустимые символы!");
                    continue;
                }

                //проверям надёжность
                String check = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$";

                Pattern p = Pattern.compile(check);
                Matcher m = p.matcher(input);

                if(!m.matches()){
                    println("Пароль ненадёжен. Придумайте заново");
                    continue;
                }

                println("Пароль надёжен");

            }
        } catch (Exception e) {
            println("Да блин какая то ошибка :/");
        }
    }
}
