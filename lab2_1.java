import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class lab2_1 {

    public static void println(Object l){
        System.out.println(l);
    }

    public static void main(String[] args) {
        try{
            while(true){

                int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

                println("Введите дату в формате dd/mm/yyyy");

                Scanner scn = new Scanner(System.in);
                String input = scn.nextLine().replaceAll("\\n", "").strip();

                //проверяем символы
                String letters = "[0-9[/._,-]]*";
                Pattern symbols = Pattern.compile(letters);
                Matcher sym_m = symbols.matcher(input);

                if(!sym_m.matches()){
                    println("Введённое выражение содержит недопустимые символы");
                    continue;
                }

                //проверяем формат
                String format = "[0-9]{2}/{1}[0-9]{2}/{1}[0-9]{4}";
                Pattern f = Pattern.compile(format);
                Matcher form_m = f.matcher(input);

                if(!form_m.matches()){
                    println("Введённое выражение не соответствует формату");
                    continue;
                }

                String[] d = input.split("/");
                int[] date = new int[3];

                for (int i = 0; i <= 2; i++){
                    date[i] = Integer.parseInt(d[i]);
                }

                //для високосных годов
                if (date[2] % 4 == 0){days[1] = 29;}

                //проверка даты на корректность
                if (date[1] <= 12 & date[1] >= 0){
                    if ((date[0] >= 0) & (date[0] <= days[date[1] - 1])){
                        println("Введённое выражение является датой");
                    } else { println("Такой даты не существует!");}
                } else { println("Такой даты не существует!");}
            }
        } catch (Exception e) {
            println("Да блин какая то ошибка :/");
        }
    }
}