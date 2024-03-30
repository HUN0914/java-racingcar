package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
class Car {
    private String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public void advance() {
        distance++;
    }

    public void displayProgress() {
        System.out.println(name + " : " + "-".repeat(distance));
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }

        System.out.println("시도할 회수는 몇 회인가요?");
        int attempts = Integer.parseInt(Console.readLine());

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }

        System.out.println("\n실행 결과");
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    car.advance();
                }
                car.displayProgress();
            }
            System.out.println();
        }

        int maxDistance = 0;
        for (Car car : cars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
            }
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
