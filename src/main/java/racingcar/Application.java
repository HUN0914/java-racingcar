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
