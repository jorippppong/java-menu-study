package menu.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FoodList {
    public static List<String> categories = new ArrayList<>(Arrays.asList("카테고리", "일식", "한식", "중식", "아시안", "양식"));


    public static List<List<String>> menus = new ArrayList<>() {{
        add(Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
        add(Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
        add(Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
        add(Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
        add(Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
    }};

    public static final List<String> weekday = new ArrayList<>(Arrays.asList("구분","월요일", "화요일", "수요일", "목요일", "금요일"));

}