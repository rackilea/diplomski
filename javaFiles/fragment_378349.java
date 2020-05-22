package whyNotZoidberg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Agents {

    public static final int N = 5;  // amount of total agents / booths 

    static int position[] = new int[N]; // index = agent, value = boot
    static boolean occupied[] = new boolean[N];
    static ArrayList<Integer> answers = new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 0; i < N; i++) {
            position[i] = -1;
        }

        System.out.println("Solutions: ");
        int answer = getWays(0);

        System.out.println();
        System.out.println("The answer is ");
        System.out.println(answer);
        System.out.println();
        Collections.sort(answers,new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                }
                if (o2 > o1) {
                    return -1;
                }
                System.out.println("Repetition between answers detected. Quiting.");
                System.exit(0);
                return 0;
            }
        });
        System.out.println("The solutions are following (the number is agent number)");
        for (int i = 0; i < answers.size(); i++) {
            System.out.println(answers.get(i));
        }
    }

    static int getWays(int agentNr) {
        if (agentNr == N-1) {

            position[N-1] = viableBootOptions().get(0);

            int number = 0;
            for (int i = 0; i < N; i++) {

                for (int j = 0; j < N; j++) {
                    if (position[j] == i) {
                        number += (int) ((j+1) * Math.pow(10, N - i - 1));
                    }
                }
            }

            answers.add(number);

            return 1;     

        }

        int result = 0;
        ArrayList<Integer> options = viableBootOptions();

        for (int i = 0; i < options.size(); i++) {
            position[agentNr] = options.get(i);
            for (int j = agentNr + 1; j < N; j++) {
                position[j] = -1;
            }
            updateOccupied();
            result += getWays (agentNr + 1);
        }

        return result;

    }

    static ArrayList<Integer> viableBootOptions() {
        int ruleSelected = 3;
        ArrayList<Integer> result = new ArrayList<>();

        if (!occupied[0] && !occupied[1]) {
            ruleSelected = 1;
            result.add(0);
        }
        if (!occupied[N-2] && !occupied[N-1]) {
            ruleSelected = 1;
            result.add(N-1);
        }
        if (!occupied[0]) {
            if (ruleSelected != 1) {
                ruleSelected = 2;
                result.add(0);
            }
        }
        if (!occupied[N-1]) {
            if (ruleSelected != 1) {
                ruleSelected = 2;
                result.add(N-1);
            }
        }

        for (int i = 1; i < N-1; i++) {
            if (!occupied[i]) {
                if (!occupied[i - 1] && !occupied[i + 1]) {
                    if (ruleSelected > 1) {
                        ruleSelected = 1;
                        result.clear();
                    }
                    result.add(i);
                    continue;
                }
                if ((!occupied[i - 1] || !occupied[i + 1]) && ruleSelected != 1) {

                    if (ruleSelected > 1) {
                        if (ruleSelected == 3) {
                            result.clear();
                        }
                        ruleSelected = 2;   
                        result.add(i);
                        continue;
                    }

                }

                if (ruleSelected == 3) {
                    result.add(i);
                }

            }
        }
        return result;

    }

    static void updateOccupied() {
        for (int i = 0; i < N; i++) {
            occupied[i] = false;
        }
        for (int i = 0; i < N; i++) {
            if (position[i] > -1) {
                occupied[position[i]] = true;
            }
        }
    }
}