package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Car> cars = new ArrayList<>();

    private int attempts;

    public Game(String[] carNames, int attempts){
        for(String name:carNames){
            cars.add(new Car(name));
        }
        this.attempts=attempts;
    }
    public void start() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < attempts; i++) {
            playGame();
            System.out.println();
        }
        Win();
    }
    private void playGame(){
        for(Car car : cars){
            if(Randoms.pickNumberInRange(0,9)>=4){
                car.advance();
            }
            car.displayProgress();
        }
        System.out.println();
    }

    private void Win(){
        int maxDistance=0;
        for(Car car : cars){
            if(car.getDistance()>maxDistance){
                maxDistance=car.getDistance();
            }
        }
        List<String> winners= new ArrayList<>();
        for(Car car : cars){
            if(car.getDistance()==maxDistance){
                winners.add(car.getName());
            }
        }
        // 출력 포맷 수정: 콜론 다음에 공백 추가
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }


}

