package calculator;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();

        // 기본 구분자 저장
        ArrayList<String> delimiter = new ArrayList<>();
        delimiter.add(",");
        delimiter.add(":");

        // 커스텀 구분자("//"와 "\n"사이에 존재)가 존재하는지 확인 후 모두 delimiter에 저장
        while (input.contains("//") && input.contains("\\n")){
            String[] parts = input.split("\\\\n",2);
            String n_delimiter = parts[0].replaceAll("//","");
            if (!delimiter.contains(n_delimiter)){
                delimiter.add(n_delimiter);
            }
            input = parts[1];
        }

        // delimiter안에 있는 모든 구분자들을 ","으로 통일해서 변경
        for (String delim: delimiter){
            input = input.replace(delim,",");
        }

        System.out.println(input);
    }
}
